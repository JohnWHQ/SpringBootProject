package com.example.demo.utils;

import com.example.demo.domain.Result;

public class ResultUtil {

    public static Result success(Object obj){
        Result res = new Result();
        res.setCode(1);
        res.setMsg("success");
        res.setData(obj);
        return res;
    }

    public static Result success(){
        return success(null);
    }

    public static Result fail(Integer code, String msg){
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }
}
