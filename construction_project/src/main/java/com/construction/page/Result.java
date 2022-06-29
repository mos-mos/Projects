package com.construction.page;

/**
 * @作者: Steel.D虫洞时空
 * @时间: 2021-3-24 23:55
 * @版本 1.0
 * 祖师爷保佑，永无Bug
 */
import com.construction.constants.Status;

import java.io.Serializable;

/**
 * 封装返回结果
 */
public class Result implements Serializable{
    private boolean flag = false;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息
    private Object data;//返回数据

    public Result() {
    }

    public Result(boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static Result success(){
        return new Result(Status.SUCCESS.isFlag(),Status.SUCCESS.getMessage());
    }
    public static Result fail(){
        return new Result(Status.FAIL.isFlag(),Status.FAIL.getMessage());
    }
}