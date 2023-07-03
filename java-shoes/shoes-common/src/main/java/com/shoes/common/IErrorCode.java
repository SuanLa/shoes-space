package com.shoes.common;

/**
 * 常用API返回对象接口
 * Created by macro on 2023/7/3.
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
