package com.shoes.common.entity;

import lombok.Data;

/**
 * @Author: Tomcat
 * @Date: 2024/5/5
 **/
@Data
public class LogEntity {
    /**
     * 描述
     */
    private String description;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 耗时
     */
    private String spendTime;

    /**
     * 传入参数
     */
    private Object parameter;

    /**
     * 返回数据
     */
    private Object result;
}
