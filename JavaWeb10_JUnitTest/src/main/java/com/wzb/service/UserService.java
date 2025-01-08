package com.wzb.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserService {
    /**
     * 根据身份证号码，计算出用户的年龄
     * @param idCard 身份证号码
     * @return 用户年龄
     */
    public Integer getAge(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("无效的身份证号码");
        }
        String birthday = idCard.substring(6, 14);
        LocalDate parse = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(parse, LocalDate.now()).getYears();
    }

    /**
     * 根据身份证号码判断用户性别
     * @param idCard 身份证号码
     * @return 性别
     */
    public String getGender(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("无效的身份证号码");
        }
        return Integer.parseInt(idCard.substring(16, 17)) % 2 == 1 ? "男" : "女";
    }
}
