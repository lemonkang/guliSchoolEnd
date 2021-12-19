package com.atguigu.commonutils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class R {
    private Boolean success;
    private Integer code;
    private String message;
    private  Map<String,Object> data= new HashMap<>();
//    成功的方法
    public static R ok(){
        R r = new R();
        r.setMessage("成功");
        r.setCode(ResultCode.SUCCESS);
        r.setSuccess(true);
        return  r;
    }
//    失败的方法
    public static R fail(){
        R r = new R();
        r.setMessage("请求失败");
        r.setCode(ResultCode.ERROR);
        r.setSuccess(false);
        return r;
    }
//    设置message
 public    R message(String message){
        this.setMessage(message);
        return  this;
    }

//    设置data
 public    R data(String key,Object value){
       this.data.put(key,value);
       return this;
    }

}
