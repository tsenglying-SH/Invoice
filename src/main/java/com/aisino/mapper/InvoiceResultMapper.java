package com.aisino.mapper;

import com.aisino.domain.InvoiceResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: InvoiceResult <br>
 * @date: 2020-07-09 11:25 <br>
 * @author: joey <br>
 * @version: 1.0 <br>
 */
@Mapper
public interface InvoiceResultMapper {
    void saveResult (InvoiceResult invoiceResult);//增
    int deleteById (int id);//删
    InvoiceResult getById(int id);//查一个
    List<InvoiceResult> selectAll();//查询所有
}
