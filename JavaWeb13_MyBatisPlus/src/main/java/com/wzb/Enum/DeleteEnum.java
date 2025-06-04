package com.wzb.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum DeleteEnum {

    DELETE(1, "删除"),
    NOT_DELETE(0, "未删除"),
    ;

    private Integer value;

    private String desc;
}
