package com.aisino.util;

import nuonuo.open.sdk.NNOpenSDK;

import java.util.UUID;

/**
 * 请求Api
 * 
 *【这是一个Eclipse工程, JDK支持1.7+】
 */
public class OpenApi {
    
    /**
     * 请求开放平台api
     * 
     * 请求地址, 详见 https://open.nuonuo.com/#/dev-doc/sdk-usage
     */
    public void requestApi() {
    	// 参数配置
    	String taxnum = "339901999999142";//授权企业税号, 商户填""
    	String appKey = "SD86754078";
    	String appSecret = "填写应用的appSecret";
    	String method = "填写API方法名";
    	String token = "填写访问令牌,可通过OpenToken.java获取";
    	String content = "填写API私有请求参数, 标准JSON格式";
    	String url = "https://sdk.nuonuo.com/open/v1/services";// 票据识别请使用https://sdk.nuonuo.com/open/v2/ocr
    	String senid = UUID.randomUUID().toString().replace("-", ""); // 唯一标识，由企业自己生成32位随机码
    	
    	// 接口调用
    	NNOpenSDK sdk = NNOpenSDK.getIntance();
        String json = sdk.sendPostSyncRequest(url, senid, appKey, appSecret, token, taxnum, method, content);
        
        // 响应报文解析
        System.out.println("\n\n\n【API请求】");
    	System.out.println(json);
    }
}