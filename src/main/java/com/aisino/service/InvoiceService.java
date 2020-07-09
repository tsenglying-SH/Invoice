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

    void saveResult (InvoiceResult invoiceResult);//增
    /**
     * @param id
     * @return int
     * @description: //删
     * @version: 1.0
     * @date: 2020-07-09 16:51
     * @author: LB
     */
    int deleteById (int id);

    InvoiceResult getById(int id);//查一个
    List<InvoiceResult> selectAll();//查询所有
}