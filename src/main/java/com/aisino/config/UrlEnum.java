package com.aisino.config;

/**
 * @description: UrlEnum <br>
 * @date: 2020-07-10 17:09 <br>
 * @author: johnston <br>
 * @version: 1.0 <br>
 */
public enum UrlEnum {
    /*
     * @param null
     * @return
     * @description: 定义常量枚举型
     * @version: 1.0
     * @date: 2020-07-10 17:21
     * @author: johnston
     */
    TOKEN_URL("http://10.10.2.2:7879/fatp_api/nuonuo/token/getToken"),
    NUONUO_URL("https://sdk.nuonuo.com/open/v2/ocr"),
    API_METHOD("nuonuo.ElectronInvoice.obtainCurTaxPeriodThir");

    private String url;
    UrlEnum(String url) { this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
