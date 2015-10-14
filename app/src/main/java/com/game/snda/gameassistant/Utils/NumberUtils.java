package com.game.snda.gameassistant.Utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by zoubaolin on 15/10/13.
 */
public class NumberUtils {

    // 判断输入字符串是否是数字
    public static boolean isNumeric(String content) {
        boolean isNumeric = true;
        if (TextUtils.isEmpty(content)) {
            return isNumeric;
        }
        Pattern pattern = Pattern.compile("^[0-9]*");
        isNumeric = pattern.matcher(content).matches();
        return isNumeric;
    }

    // 判断输入字符是否是手机号码(13...,14...,15...,18...开头的号码)
    public static boolean isPhoneNo (String content) {
        boolean isPhoneNo = true;
        if (TextUtils.isEmpty(content)) {
            return isPhoneNo;
        }
        Pattern pattern = Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");
        isPhoneNo = pattern.matcher(content).matches();
        return isPhoneNo;
    }
}
