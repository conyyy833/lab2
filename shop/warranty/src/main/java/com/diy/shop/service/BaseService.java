package com.diy.shop.service;

import com.alibaba.fastjson.JSONObject;

public class BaseService<T> {

    public JSONObject responseOk(){
        JSONObject obj = new JSONObject();
        obj.put("status","200");
        obj.put("message","请求成功");
        return obj;
    }

    public JSONObject responseOk(String message,T data){
        JSONObject obj = new JSONObject();
        obj.put("status","200");
        obj.put("message","请求成功");
        obj.put("data",data);
        return obj;
    }

    public JSONObject responseFail(){
        JSONObject obj = new JSONObject();
        obj.put("status","400");
        obj.put("message","请求失败");
        return obj;
    }

    public JSONObject responseFail(String message){
        JSONObject obj = new JSONObject();
        obj.put("status","400");
        obj.put("message",message);
        return obj;
    }
}

