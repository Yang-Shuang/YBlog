package com.yang.base;


/**
 * Created by YangShuang
 * on 2017/3/23.
 */
public class BaseBean {
    private String errorCode;
    private String errorMsg;

    public BaseBean(){
    }

    public BaseBean(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


}
