package com.vp.bootstore.pojo;

/**
 * @Author: duYang
 * @Date: 2019/12/23 11:16
 * @Version: 1.0
 */

import lombok.Data;

import java.sql.Timestamp;

/**
 * 日志信息表
 */
@Data
public class Log implements java.io.Serializable{
    /** 版本号 */
    private static final long serialVersionUID = 5628999092542545126L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** logId */
    private Integer log_id;

    /** 日志内容 */
    private String log_content;

    /** 谁产生的 */
    private Integer user_id;

    /** 日志类别 */
    private Integer log_type;

    /** 产生时间 */
    private Timestamp log_date;
}
