package com.aisino.invoice;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.aisino.InvoiceApplication;
import com.aisino.domain.Invoicebefore;
import com.aisino.mapper.InvoicebeforeMapper;
import com.aisino.util.BasicRequest;
import com.alibaba.fastjson.JSONObject;
import nuonuo.open.sdk.NNOpenSDK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= InvoiceApplication.class)
public class DataTest {
    @Autowired
    private InvoicebeforeMapper invoicebeforeMapper;

    @Test
    public void test(){
        List<Invoicebefore> invoicebefores = invoicebeforeMapper.queryInvoicebefore();
        System.out.println(invoicebefores);
    }

    @Test
    public void testHttps() {
        JSONObject json = new JSONObject();
        json.put("invoiceCode","042001900211");
        json.put("invoiceNo","58052070");
        json.put("invoiceDate","2020-04-24");
        json.put("invoiceCheckCode","525941");
        String result = HttpRequest.post("https://sandbox.nuonuocs.cn/open/v1/services")
                .header("Content-Type","application/json")
                /*.header("X-Bmob-Application-Id","2f0419a31f9casdfdsf431f6cd297fdd3e28fds4af")
                .header("X-Bmob-REST-API-Key","1e03efdas82178723afdsafsda4be0f305def6708cc6")*/
                .body(String.valueOf(json))
                .execute().body();
        System.out.println(result);

    }
    @Test
    public void testToken(){
        // 参数配置
        String appKey = "60135634"; // AppKey值
        String appSecret = "D6F84241BC454710";//appSecret值
        //String code = "12345";//临时授权码，请求authorize时返回的code"
        String taxnum = "91310230674560485R";//授权企业的税号，获取临时授权码返回的taxnum
        String redirect_uri = "https://open.jss.com.cn";//回调地址，必传且不能为空

        // 接口调用
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String json = sdk.getMerchantToken(appKey, appSecret,  "https://open.nuonuo.com/accessToken");

        // 响应报文解析
        System.out.println("\n\n\n【ISV获取Token】");
        System.out.println(json);
    }


    @Test
    public void testAPI(){
        // 参数配置

        String taxnum = "91310107MA1G0XXR45";//授权企业税号, 商户填""
        String appKey = "34707477";
        String appSecret = "75675D8AEFEF4673";
       // String method = "nuonuo.electronInvoice.requestBilling";//填写API方法名
        String method = "nuonuo.ElectronInvoice.obtainCurTaxPeriodThir";//填写API方法名
        String token = "ad3a7071c4f1560dbe1e160mzciyrp3s";//填写访问令牌,可通过OpenToken.java获取
        String content = "{\"invoiceCode\":\"042001900211\",\"invoiceNo\":\"invoiceDate\":\"2020-4-24\"}";//填写API私有请求参数, 标准JSON格式
        //String url = "https://sdk.nuonuo.com/open/v1/services";// 票据识别请使用https://sdk.nuonuo.com/open/v2/ocr
        //String url = "https://sandbox.nuonuocs.cn/openPlatform/services";// 票据识别请使用https://sdk.nuonuo.com/open/v2/ocr
        String url = "https://sdk.nuonuo.com/open/v2/ocr";// 票据识别请使用https://sdk.nuonuo.com/open/v2/ocr
        String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码

        // 接口调用
        NNOpenSDK sdk = NNOpenSDK.getIntance();
        String json = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);

        // 响应报文解析
        System.out.println("\n\n\n【API请求】");
        System.out.println(json);
    }

    @Test
    public void testRequest(){
        JSONObject result = BasicRequest.basicRequest("91310107MA1G0XXR45" , "http://10.10.2.2:7879/fatp_api/nuonuo/token/getToken");
        System.out.println("\n\n\n【返回请求】");
        System.out.println(result);
        String token = result.getJSONObject("dataObject").getString("access_token");
        String appKey = result.getJSONObject("dataObject").getString("key");
        String appSecret = result.getJSONObject("dataObject").getString("secret");
        System.out.println(token);
        System.out.println(appKey);
        System.out.println(appSecret);

        // System.out.println(access_token);


    }

    @Test
    public void test1(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("invoiceCode","042001900211" );
        jsonObj.put("invoiceNo","2321" );
        System.out.println(jsonObj.toJSONString());

        String content = String.format("%s 至 %s", "0709", "0710");
        System.out.println(content);

        JSONObject.parseObject("");



    }



}
