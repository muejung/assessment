package com.kbtg.bootcamp.posttest.utils;

import java.util.ArrayList;
import java.util.List;

public class getTicketToString {
    public static List<String> getTicketToString(List<Object[]> objectArrayList) {
        List<String> stringList = new ArrayList<>();
        int totalCount = 0;
        int totalPrice = 0;

        for (Object[] objArray : objectArrayList){
            StringBuilder sb = new StringBuilder();
            int i = 0;

            for (Object obj : objArray){
                if (i == 0) {
                    sb.append("\"" + obj.toString() + "\"");
                }
                if (i == 1) {
                    sb.append("|count:" + obj.toString());
                    totalCount += Integer.parseInt(obj.toString());
                }
                if (i == 2) {
                    sb.append("|price:" + obj.toString());
                    totalPrice += Integer.parseInt(obj.toString());
                }
                i++;
            }
            stringList.add(sb.toString().trim());
        }
        stringList.add("\nTotal Ticket = " + totalCount + " | Total Price = " + totalPrice);

        return stringList;
    }
}
