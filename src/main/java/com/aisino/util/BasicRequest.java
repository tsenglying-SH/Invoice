package com.aisino.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: BasicRequest <br>
 * @date: 2020-07-09 9:52 <br>
 * @author: joey <br>
 * @version: 1.0 <br>
 */
public class BasicRequest {

    private static final String NUONUO_TYPE = "inputTaxCheck";
    public static JSONObject basicRequest(String companyId, String url) {
        Map<String, Object> requestParam = new HashMap<>(2);
        requestParam.put("tax", companyId);
        requestParam.put("type", NUONUO_TYPE);
        String response = HttpUtil.post(url, requestParam);
        return JSONObject.parseObject(response);
    }
}