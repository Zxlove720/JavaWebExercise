package com.wzb.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeleteEnum {

    DELETE(1, "删除"),
    NOT_DELETE(0, "未删除"),
    ;

    private final Integer value;

    private final String desc;
}
