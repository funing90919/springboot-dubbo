package com.sf.multimodal.response;

public class RespResultUtil {

    /**
     * @param t   返回的对象
     * @param msg 提示给前端的消息（个人定制的消息）
     */
    public static <T> RespResult<T> success(T t, String msg) {
        RespResult<T> result = new RespResult<>();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(t);
        return result;
    }

    /**
     * @param t 返回给前端的对象
     */
    public static <T> RespResult<T> success(T t) {
        return success(t, "操作成功");
    }

    /**
     * @param msg 返回给前端的消息
     */
    public static <T> RespResult<T> success(String msg) {
        return success(null, msg);
    }

    /**
     *
     * @return
     */
    public static <T> RespResult<T> success() {
        return success("操作成功");
    }

    /**
     * @param code 异常码
     * @param msg  异常消息
     */
    public static <T> RespResult<T> error(Integer code, String msg) {
        RespResult<T> result = new RespResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * @param code 异常码
     * @param msg  异常消息
     */
    public static <T> RespResult<T> error(Integer code, String msg, T t) {
        RespResult<T> result = new RespResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(t);
        return result;
    }

}
