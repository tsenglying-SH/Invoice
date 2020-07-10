package com.aisino.service;

import com.aisino.domain.InvoiceResult;

import java.util.List;

/**
 * @description: InvoiceService <br>
 * @date: 2020-07-09 13:38 <br>
 * @author: joey <br>
 * @version: 1.0 <br>
 */
public interface InvoiceService {

    void saveResult (InvoiceResult invoiceResult);//增加一条记录

    int deleteById (int id);//删除一条记录

    InvoiceResult getById(int id);//查询一条记录
    List<InvoiceResult> selectAll();//查询所有记录

    InvoiceResult getInvoiceResult(String taxnum);//根据税号查询接口并封装成InvoiceResult对象


}