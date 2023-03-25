package com.example.numberselection.common;

public class Result {
    private Boolean success;
    private Object data;
    private Integer code;
    private String msg;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result createSuccess(Object data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result createSuccess(String msg,Object data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result createFalse(Integer code,String msg,Object data){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
