package com.dgut.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xieyougen
 * @email: xieyougen@tuandai.com
 * @description:
 * @date: 2018/2/6 16:42
 */
public class StringUtil {

    public static List<Integer> splitIds(String id){
        List<Integer> list = new ArrayList<>();
        if(id.contains(",")){
            String[] ids = id.split(",");
            for (int i = 0; i < ids.length; i++) {
                list.add(Integer.valueOf(ids[i]));
            }
            return list;
        }
        list.add(Integer.valueOf(id));
        return list;
    }
}
