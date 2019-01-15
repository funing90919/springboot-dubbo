package com.sf.multimodal.exception;

import com.sf.multimodal.constant.RespResultEnum;

/**
 * Created by Jacky on 2019/1/15 14:31
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code;

    /*public ServiceException(RespResultEnum respResultEnum) {
        super(respResultEnum.getMsg());
        this.code = respResultEnum.getCode();
    }*/

    public ServiceException(RespResultEnum respResultEnum, String msg) {
        super(msg);
        this.code = respResultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
