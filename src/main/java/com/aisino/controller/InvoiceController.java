package com.aisino.controller;

import com.aisino.domain.InvoiceResult;
import com.aisino.service.impl.InvoiceServiceImpl;
import com.aisino.util.BasicRequest;
import com.alibaba.fastjson.JSONObject;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @description: CheckInvoice <br>
 * @date: 2020-07-08 10:37 <br>
 * @author: Johnston <br>
 * @version: 1.0 <br>
 */
@RestController
public class InvoiceController {

    @Resource
    private InvoiceServiceImpl invoiceServiceImpl;

    String taxnum = "91310107MA1G0XXR45";

    @RequestMapping(value = "/getInfo")
    public String setInfo() {
        JSONObject result = BasicRequest.basicRequest(taxnum, "http://10.10.2.2:7879/fatp_api/nuonuo/token/getToken");
        System.out.println(result);
        String token = result.getJSONObject("dataObject").getString("access_token");
        String appKey = result.getJSONObject("dataObject").getString("key");
        String appSecret = result.getJSONObject("dataObject").getString("secret");
        // 票据识别请使用https://sdk.nuonuo.com/open/v2/ocr
        String url = "https://sdk.nuonuo.com/open/v2/ocr";
        // 唯一标识，由企业自己生成32位随机码
        String senid = UUID.randomUUID().toString().replace("-", "");
        //填写API私有请求参数, 标准JSON格式
        String content = "{\"invoiceCode\":\"042001900211\",\"invoiceNo\":\"invoiceDate\":\"2020-4-24\"}";
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

        //jsonObject1.getJSONObject("result").getDate("utime")
        // invoiceResult.setUtime(LocalDateTime.now());
        //   LocalDateTime.now().format(DateTimeFormatter.ofPattern(""))
        System.out.println(invoiceResult);
        invoiceServiceImpl.saveResult(invoiceResult);

        //   LocalDateTime.now().format(DateTimeFormatter.ofPattern(""))

        return json;
    }

}