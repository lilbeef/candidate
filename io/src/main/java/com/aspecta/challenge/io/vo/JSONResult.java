package com.aspecta.challenge.io.vo;

import lombok.Data;

/**
 * @Author: sxy
 * @Date: 2023/3/19 15:45
 */
@Data
public class JSONResult {
    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */

    private Object data;

    /**
     * 增加默认构造函数，远程调用才能接收
     */
    public JSONResult() {

    }


    public JSONResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JSONResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功数据
     *
     * @param data
     * @return
     */
    public static JSONResult success(Object data) {
        return new JSONResult(9000,"成功",data);
    }

    /**
     * 返回成功数据及信息
     *
     * @param msg
     * @param data
     * @return
     */
    public static JSONResult success(String msg, Object data) {

        return new JSONResult(9000, msg, data);
    }





    /**
     * 用户发出的请求有错误，如参数类型、格式等错误
     *
     * @param msg
     * @return
     */
    public static JSONResult failure(String msg) {
        return new JSONResult(9500, msg);
    }




    /**
     * 返回失败数据
     * @param msg
     * @param data
     * @return
     */
    public static JSONResult failure(String msg, Object data) {
        return new JSONResult(9500, msg, data);
    }

    /**
     * 自定义返回错误编码及提示信息
     *
     * @param code 错误编码
     * @param msg 错误信息
     * @return
     */
    public static JSONResult failure(int code, String msg) {
        return new JSONResult(code, msg);
    }






}
