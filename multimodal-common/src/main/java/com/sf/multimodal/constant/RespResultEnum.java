package com.sf.multimodal.constant;

public enum RespResultEnum {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    VALIDATION_FAILURE(2, "校验错误"),

    //10 通用的异常
    COMMON_lOGIN_TIME_OUT(1000001, "登录超时"),
    COMMON_lOGIN_FALIUE(1000002, "登录失败"),
    COMMON_lOGIN_FALIUE_USERPWD_ERROR(1000003, "用户名或密码错误"),
    COMMON_VALIDATETION_ERROR(1000004, "数据验证异常"),
    COMMON_PAGINATION_ERROR(1000005, "分页异常"),
    COMMON_ACCESS_DB_ERROR(1000006, "访问数据库异常"),
    COMMON_ACCESS_CODIS_ERROR(1000007, "访问Redis缓存异常"),
    COMMON_ILLEGAL_ACCESS(1000008, "非法访问"),
    COMMON_REPEAT_ACCESS(1000009, "重复请求"),
    COMMON_PARAMS_ERROR(1000010, "参数有误"),
    COMMON_ORDER_NUMBER_GENERATE_FAILURE(1000011, "生成单号失败"),
    COMMON_NOT_EXIST(1000012, "记录不存在");

    // 11 订单模块的业务异常

    // 12 用户模块的业务异常
    private int code;

    private String msg;

    RespResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
