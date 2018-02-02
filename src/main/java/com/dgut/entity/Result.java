package com.dgut.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyougen
 * @email: xieyougen@tuandai.com
 * @description:
 * @date: 2018/2/2 16:17
 */
public class Result extends HashMap<String,Object>{
     private Integer code;
     private String msg;
     private Integer count;
     private Object data;

     public static Result success(String msg,Integer count,Object object){
         Result result = new Result();
         result.put("code",0);
         result.put("count",count);
         result.put("msg",msg);
         result.put("data",object);
         return result;
     }

     public static Result error(){
         Result result = new Result();
         result.put("code",500);
         result.put("count","");
         result.put("msg","error");
         result.put("data",null);
         return result;
     }


}
