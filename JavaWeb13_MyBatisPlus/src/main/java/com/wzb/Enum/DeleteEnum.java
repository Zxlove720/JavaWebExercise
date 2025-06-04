package com.wzb.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeleteEnum {

    NOT_DELETE(0, "未删除"),
    DELETE(1, "删除"),
    ;

    // 使用@EnumValue注解标记枚举中的哪一个值需要存入数据库
    @EnumValue
    private final Integer value;

    private final String desc;
}
