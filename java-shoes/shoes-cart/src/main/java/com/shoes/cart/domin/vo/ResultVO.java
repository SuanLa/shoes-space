package com.shoes.cart.domin.vo;


/**
 * 返回VO
 * @author Tomcat
 * @Date 2023/7/5
 */
public class ResultVO<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    protected ResultVO() {
    }

    protected ResultVO(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResultVO<T> success(T data, String message) {
        return new ResultVO<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResultVO<T> failed(IErrorCode errorCode) {
        return new ResultVO<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> ResultVO<T> failed(IErrorCode errorCode,String message) {
        return new ResultVO<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultVO<T> failed(String message) {
        return new ResultVO<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultVO<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultVO<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultVO<T> validateFailed(String message) {
        return new ResultVO<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResultVO<T> unauthorized(T data) {
        return new ResultVO<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultVO<T> forbidden(T data) {
        return new ResultVO<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
