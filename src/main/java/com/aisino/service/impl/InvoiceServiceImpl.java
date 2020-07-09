package com.aisino.service.impl;

import com.aisino.domain.InvoiceResult;
import com.aisino.mapper.InvoiceResultMapper;
import com.aisino.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: InvoiceServiceImpl <br>
 * @date: 2020-07-09 15:38 <br>
 * @author: joey <br>
 * @version: 1.0 <br>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceResultMapper invoiceResultMapper;

    @Override
    public void saveResult(InvoiceResult invoiceResult) {
         invoiceResultMapper.saveResult(invoiceResult);
    }

    @Override
    public int deleteById(int id) {
        return invoiceResultMapper.deleteById(id);
    }

    @Override
    public InvoiceResult getById(int id) {
        return invoiceResultMapper.getById(id);

    }

    @Override
    public List<InvoiceResult> selectAll() {
        return invoiceResultMapper.selectAll();
    }
}