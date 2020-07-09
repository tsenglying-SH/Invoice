package com.aisino.domain;
import java.util.Date;
public class Invoicebefore {
    private Integer id;
    private String invoiceCode;
    private String invoiceNo;
    private Date  invoiceDate;
    private String payerName;
    private String payerTaxNo;
    private String  payerAddressTel;
    private String  payerBankAccout;
    private String payeeName;
    private String payeeTaxNo;
    private String payeeAddressTel;
    private String payeeBankAccout;
    private String remark;
    private String deviceCode;
    private String checkCode;
    private String invoiceKind;
    private String taxAmount;
    private String sumAmount;
    private String exTaxAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerTaxNo() {
        return payerTaxNo;
    }

    public void setPayerTaxNo(String payerTaxNo) {
        this.payerTaxNo = payerTaxNo;
    }

    public String getPayerAddressTel() {
        return payerAddressTel;
    }

    public void setPayerAddressTel(String payerAddressTel) {
        this.payerAddressTel = payerAddressTel;
    }

    public String getPayerBankAccout() {
        return payerBankAccout;
    }

    public void setPayerBankAccout(String payerBankAccout) {
        this.payerBankAccout = payerBankAccout;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeTaxNo() {
        return payeeTaxNo;
    }

    public void setPayeeTaxNo(String payeeTaxNo) {
        this.payeeTaxNo = payeeTaxNo;
    }

    public String getPayeeAddressTel() {
        return payeeAddressTel;
    }

    public void setPayeeAddressTel(String payeeAddressTel) {
        this.payeeAddressTel = payeeAddressTel;
    }

    public String getPayeeBankAccout() {
        return payeeBankAccout;
    }

    public void setPayeeBankAccout(String payeeBankAccout) {
        this.payeeBankAccout = payeeBankAccout;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getInvoiceKind() {
        return invoiceKind;
    }

    public void setInvoiceKind(String invoiceKind) {
        this.invoiceKind = invoiceKind;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getExTaxAmount() {
        return exTaxAmount;
    }

    public void setExTaxAmount(String exTaxAmount) {
        this.exTaxAmount = exTaxAmount;
    }

    @Override
    public String toString() {
        return "Invoicebefore{" +
                "id=" + id +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", payerName='" + payerName + '\'' +
                ", payerTaxNo='" + payerTaxNo + '\'' +
                ", payerAddressTel='" + payerAddressTel + '\'' +
                ", payerBankAccout='" + payerBankAccout + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", payeeTaxNo='" + payeeTaxNo + '\'' +
                ", payeeAddressTel='" + payeeAddressTel + '\'' +
                ", payeeBankAccout='" + payeeBankAccout + '\'' +
                ", remark='" + remark + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", invoiceKind='" + invoiceKind + '\'' +
                ", taxAmount='" + taxAmount + '\'' +
                ", sumAmount='" + sumAmount + '\'' +
                ", exTaxAmount='" + exTaxAmount + '\'' +
                '}';
    }
}
