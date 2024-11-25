package com.wzb.Controller;

/**
 * 用户相关方法
 *
 */
public class UserController {
    public String getGender(String id) {
        if (id.length() != 18) {
            throw new IllegalArgumentException("身份证错误");
        }
        int gender = id.charAt(16) - 48;
        if (gender % 2 == 0) {
            return "女";
        } else {
            return "男";
        }
    }
}
