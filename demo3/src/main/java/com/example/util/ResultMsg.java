package com.example.util;

/**
 * 响应数据包装
 *
 * @author shi
 * @date 2022/1/8
 */
public class ResultMsg<T> {
    /**
     * 状态: -1为异常，0为正常
     */
    private int state;
    /**
     * 提醒消息
     */
    private String msg;
    /**
     * 返回值
     */
    private T datas;

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public ResultMsg(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    //获取和设置 datas
    public ResultMsg(int state, String msg, T datas) {
        this.state = state;
        this.msg = msg;
        this.datas = datas;
    }

    public static ResultMsg<Void> returnError(String message) {
        return new ResultMsg<>(-1, message);
    }

    public static <T> ResultMsg<T> returnSuccess(String message, T datas) {
        return new ResultMsg<>(0, message, datas);
    }

    public static ResultMsg<Void> returnSuccess(String message) {
        return new ResultMsg<>(0, message);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
