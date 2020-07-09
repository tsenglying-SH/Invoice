package com.aisino.domain;

import java.util.Date;

/**
 * @author joey
 */
public class InvoiceResult {
    private Integer id;
    private String ssq;
    private String gxrqq;
    private String gxrqz;
    private String jzssq;
    private Date utime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsq() {
        return ssq;
    }

    public void setSsq(String ssq) {
        this.ssq = ssq;
    }

    public String getGxrqq() {
        return gxrqq;
    }

    public void setGxrqq(String gxrqq) {
        this.gxrqq = gxrqq;
    }

    public String getGxrqz() {
        return gxrqz;
    }

    public void setGxrqz(String gxrqz) {
        this.gxrqz = gxrqz;
    }

    public String getJzssq() {
        return jzssq;
    }

    public void setJzssq(String jzssq) {
        this.jzssq = jzssq;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "InvoiceResult{" +
                "id=" + id +
                ", ssq='" + ssq + '\'' +
                ", gxrqq='" + gxrqq + '\'' +
                ", gxrqz='" + gxrqz + '\'' +
                ", jzssq='" + jzssq + '\'' +
                ", utime=" + utime +
                '}';
    }

}
