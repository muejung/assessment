package com.kbtg.bootcamp.posttest.utils;

import java.util.regex.Pattern;

public class numberValidation {
    public static boolean isLotteryPattern(String strNum) {
        Pattern pattern = Pattern.compile("^\\d{6}$");
        if (strNum == null) {
            return false;
        } else {
            return pattern.matcher(strNum).matches();
        }
    }
    public static boolean isUserPattern(String strNum) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        if (strNum == null) {
            return false;
        } else {
            return pattern.matcher(strNum).matches();
        }
    }
}

