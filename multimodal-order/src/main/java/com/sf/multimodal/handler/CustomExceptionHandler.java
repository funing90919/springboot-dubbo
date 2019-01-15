package com.sf.multimodal.handler;

import com.sf.multimodal.constant.RespResultEnum;
import com.sf.multimodal.exception.ControllerException;
import com.sf.multimodal.exception.ServiceException;
import com.sf.multimodal.response.RespResult;
import com.sf.multimodal.response.RespResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 通用异常处理和封装
 */
@RestControllerAdvice
public class CustomExceptionHandler {

//    @Value("${}")
    private String url;

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public RespResult<Map<String, String>> handler(Exception e) {
        logger.info("====异常处理 CustomExceptionHandler.handler 开始====");
        if (e instanceof ServiceException) {
            ServiceException ServiceException = (ServiceException) e;
            return RespResultUtil.error(ServiceException.getCode(), ServiceException.getMessage());
        } else if (e instanceof ControllerException) {
            ControllerException controllerException = (ControllerException) e;
            if (controllerException.getCode().intValue() == RespResultEnum.COMMON_lOGIN_TIME_OUT.getCode()) {
                RespResult<Map<String, String>> result = new RespResult<Map<String, String>>();
                Map<String, String> map = new HashMap<String, String>();
                map.put("loginURL", url);
                result.setCode(RespResultEnum.COMMON_lOGIN_TIME_OUT.getCode());
                result.setMsg("登录超时，请重新登录");
                result.setData(map);
                return result;
            }
            return RespResultUtil.error(controllerException.getCode(), controllerException.getMessage());
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            return RespResultUtil.error(RespResultEnum.VALIDATION_FAILURE.getCode(),
                    bindException.getFieldError().getDefaultMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            StringBuilder sb = new StringBuilder();
            Iterator<ObjectError> iterator = methodArgumentNotValidException.getBindingResult().getAllErrors()
                    .iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next().getDefaultMessage()).append("/");
            }
            return RespResultUtil.error(RespResultEnum.VALIDATION_FAILURE.getCode(), sb.toString());
        } else {
            logger.error("【系统异常】{}", e);
            return RespResultUtil.error(-1, "系统异常，请稍后访问 ");
        }
    }
}
