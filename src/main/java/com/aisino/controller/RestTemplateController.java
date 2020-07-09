package com.aisino.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/testGetApi")
    public String getJson(){
       /* String url="";
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        return json;*/
        /*String url = "http://localhost:3306/aisino?serverTimezone=GMT%2B8";*/
        String url= "http://baidu.com";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    /*post方法*/
    @PostMapping(value = "/testPost")
    public Object postJson(@RequestBody JSONObject param) {
        System.out.println(param.toJSONString());
        param.put("action", "post");
        param.put("username", "tester");
        param.put("pwd", "123456748");
        return param;
    }

    @PostMapping(value = "/testPostApi")
    public Object testPost() {
           /* String url = "http://localhost:3306/aisino?serverTimezone=GMT%2B8";*/
           String url ="";
            JSONObject postData = new JSONObject();
            postData.put("descp", "request for post");
            JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
            return json;
    }



}
