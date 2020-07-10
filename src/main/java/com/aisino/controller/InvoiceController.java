package com.aisino.controller;

import com.aisino.domain.InvoiceResult;
import com.aisino.service.impl.InvoiceServiceImpl;
import com.aisino.util.BasicRequest;
import com.alibaba.fastjson.JSONObject;
import nuonuo.open.sdk.NNOpenSDK;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/getInfo")

    public String setInfo(@RequestParam(value = "taxnum",required = false,defaultValue = "91310107MA1G0XXR45") String taxnum) {

        InvoiceResult invoiceResult = invoiceServiceImpl.getInvoiceResult(taxnum);
        invoiceServiceImpl.saveResult(invoiceResult);
        System.out.println(invoiceResult);
        return "查询成功!"+"</br>"+invoiceResult.toString();
    }

}