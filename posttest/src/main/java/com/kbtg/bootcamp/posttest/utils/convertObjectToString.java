package com.kbtg.bootcamp.posttest.utils;

import java.util.ArrayList;
import java.util.List;

public class convertObjectToString {
    public static List<String> convertObjectToString(List<Object[]> objectArrayList) {
        List<String> stringList = new ArrayList<>();
        for (Object[] objArray : objectArrayList){
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArray){
                sb.append(obj.toString());
            }
            stringList.add("\"" + sb.toString().trim() + "\"");
        }
        return stringList;
    }
}
