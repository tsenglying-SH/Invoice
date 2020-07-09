package com.aisino.util;

import nuonuo.open.sdk.NNOpenSDK;

/**
 * 获取Token
 * 
 * 【这是一个Eclipse工程, JDK支持1.7+】
 */
public class OpenToken {
   
    /**
     * 商户获取授权码
     * 
     * 辅助页面 https://open.nuonuo.com/#/dev-doc/auth-business
     */
    public void getMerchantToken() {
    	// 参数配置
    	String appKey = "填写应用的appKey";
    	String appSecret = "填写应用的appSecret";
    	
    	// 接口调用
    	NNOpenSDK sdk = NNOpenSDK.getIntance();
    	String json = sdk.getMerchantToken(appKey, appSecret);
    	
    	// 响应报文解析
    	System.out.println("\n\n\n【商户获取Token】");
    	System.out.println(json);
    }
    
    
    /**
     * ISV获取授权码
     * 
     * 辅助页面 https://open.nuonuo.com/#/dev-doc/auth-service
     */
    public void getISVToken() {
    	// 参数配置
    	String appKey = "填写应用的appKey";
    	String appSecret = "填写应用的appSecret";
    	String code = "临时授权码，请求authorize时返回的code";
    	String taxnum = "授权企业的税号，获取临时授权码返回的taxnum";
    	String redirect_uri = "回调地址，必传且不能为空";
    	
    	// 接口调用
    	NNOpenSDK sdk = NNOpenSDK.getIntance();
    	String json = sdk.getISVToken(appKey, appSecret, code, taxnum, redirect_uri);
        
    	// 响应报文解析
    	System.out.println("\n\n\n【ISV获取Token】");
    	System.out.println(json);
    }
    
    /**
     * ISV刷新授权码
     * 
     * 辅助页面 https://open.nuonuo.com/#/dev-doc/auth-service
     */
    public void refreshISVToken() {
    	// 参数配置
    	String refreshToken = "刷新令牌,由接口getISVToken返回";
    	String userId = "获取access_token时授权商户的userId";
    	String appSecret = "填写应用的appSecret";
    	
    	// 接口调用
    	NNOpenSDK sdk = NNOpenSDK.getIntance();
    	String json = sdk.refreshISVToken(refreshToken, userId, appSecret);
        
    	// 响应报文解析
    	System.out.println("\n\n\n【ISV刷新Token】");
    	System.out.println(json);
    }
}