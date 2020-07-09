package com.aisino.mapper;

import com.aisino.domain.Invoicebefore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface InvoicebeforeMapper {
    public List<Invoicebefore> queryInvoicebefore();
}
