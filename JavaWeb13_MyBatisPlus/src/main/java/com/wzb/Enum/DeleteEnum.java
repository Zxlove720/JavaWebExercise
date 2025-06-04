package com.wzb.Enum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeleteEnum {

    NOT_DELETE(0, "可用"),
    DELETE(1, "不可用"),
    ;

    // 使用@EnumValue注解标记枚举中的哪一个值需要存入数据库
    @EnumValue
    private final Integer value;
    // 使用@JsonValue注解标记返回数据时，使用枚举中的哪一个值
    @JsonValue
    private final String desc;
}
