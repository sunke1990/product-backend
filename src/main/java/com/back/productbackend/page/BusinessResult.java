package com.back.productbackend.page;

import org.slf4j.MDC;

import java.io.Serializable;

/**
 * ClassName: BusinessResult
 *
 * 重写原有的 business-result框架中的此类，
 * 主要是替换其中的nonceStr 返回当前调用号
 *
 * @author: davidwang2006@aliyun.com DavidWang
 * @date: 2021/4/9 13:48
 * @description:
 */
public class BusinessResult<T> implements Serializable {

    private static final String RESP_CODE_SUCCESS = "0000";
    private static final String RESP_MSG_SUCCESS = "Success";
    private String returnCode = "0000";
    private String returnMsg = "Success";
    private String nonceStr = MDC.get("serialNo");
    private boolean success;
    private T data;

    private BusinessResult() {
    }

    public static <T> BusinessResult<T> success(T data) {
        BusinessResult<T> result = new BusinessResult();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> BusinessResult<T> fail(String code, String message, T data) {
        BusinessResult<T> result = new BusinessResult();
        result.setReturnCode(code);
        result.setData(data);
        result.setReturnMsg(message);
        result.setSuccess(false);
        return result;
    }

    public static <T> BusinessResult<T> fail(String code, String message) {
        BusinessResult<T> result = new BusinessResult();
        result.setReturnCode(code);
        result.setReturnMsg(message);
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
