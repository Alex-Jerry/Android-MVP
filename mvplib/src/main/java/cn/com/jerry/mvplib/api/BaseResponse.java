package cn.com.jerry.mvplib.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 获取json数据基类
 */

public class BaseResponse<T> implements Serializable{
    @SerializedName("code")
    public int code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public T data;
}
