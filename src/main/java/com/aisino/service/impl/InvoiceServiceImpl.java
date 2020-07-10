package com.aisino.service.impl;

import com.aisino.domain.InvoiceResult;
import com.aisino.mapper.InvoiceResultMapper;
import com.aisino.service.InvoiceService;
import com.aisino.util.BasicRequest;
import com.alibaba.fastjson.JSONObject;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @description: InvoiceServiceImpl <br>
 * @date: 2020-07-09 15:38 <br>
 * @author: johnston <br>
 * @version: 1.0 <br>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceResultMapper invoiceResultMapper;

    @Override
    public void saveResult(InvoiceResult invoiceResult) {
         invoiceResultMapper.saveResult(invoiceResult);
    }

    @Override
    public int deleteById(int id) {
        return invoiceResultMapper.deleteById(id);
    }

    @Override
    public InvoiceResult getById(int id) {
        return invoiceResultMapper.getById(id);

    }

    @Override
    public List<InvoiceResult> selectAll() {
        return invoiceResultMapper.selectAll();
    }

    @Override

    public InvoiceResult getInvoiceResult(String taxnum) {
        JSONObject result = BasicRequest.basicRequest(taxnum, "http://10.10.2.2:7879/fatp_api/nuonuo/token/getToken");
        JSONObject resultValue = result.getJSONObject("dataObject");
        String token = resultValue.getString("access_token");
        String appKey = resultValue.getString("key");
        String appSecret = resultValue.getString("secret");
        // 票据识别使用https://sdk.nuonuo.com/open/v2/ocr
        String url = "https://sdk.nuonuo.com/open/v2/ocr";
        // 唯一标识，由企业自己生成32位随机码
        String senid = UUID.randomUUID().toString().replace("-", "");
        //填写API私有请求参数, 标准JSON格式
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("invoiceCode","042001900211");
        jsonObj.put("invoiceNo","58052070");
        jsonObj.put("invoiceDate","2020-4-24");
        jsonObj.put("checkCode","525941");
        String content = jsonObj.toJSONString();
        //填写API方法名
        String method = "nuonuo.ElectronInvoice.obtainCurTaxPeriodThir";

        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String json = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        JSONObject jsonObject1 = JSONObject.parseObject(json);
        JSONObject jsonResult = jsonObject1.getJSONObject("result");
        InvoiceResult invoiceResult = new InvoiceResult();
        invoiceResult.setSsq(jsonResult.getString("ssq"));
        invoiceResult.setGxrqq(jsonResult.getString("gxrqq"));
        invoiceResult.setGxrqz(jsonResult.getString("gxrqz"));
        invoiceResult.setJzssq(jsonResult.getString("jzssq"));
        invoiceResult.setUtime(jsonResult.getDate("utime"));
        return invoiceResult;
    }
}