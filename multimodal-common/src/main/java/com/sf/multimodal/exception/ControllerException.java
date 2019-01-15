package com.sf.multimodal.exception;

import com.sf.multimodal.constant.RespResultEnum;

/**
 * Created by Jacky on 2019/1/15 14:40
 */
public class ControllerException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer code;

    public ControllerException(RespResultEnum respResultEnum, String msg) {
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