package com.atguigu.crowd.util;

/**
 * @author rookie
 * @create 2021-10-03-16:23
 */
public class ResultEntity<T> {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAILED = "FAILED";

    //	用来封装当前请求处理成功还是失败
    private String result;
    //	请求处理失败时返回的消息
    private String message;
    //	要返回的数据
    private T data;

    //	请求处理成功，不需要返回数据时使用的方法
    public static <Type> ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(SUCCESS,null,null);
    }

    //	请求处理成功，需要返回数据时使用的方法
    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(SUCCESS,null,data);
    }
    //	请求处理失败，
    public static <Type> ResultEntity<Type> failed(String message){
        return new ResultEntity<Type>(FAILED,message,null);
    }




    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResultEntity() {

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
