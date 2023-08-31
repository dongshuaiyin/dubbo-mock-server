package com.dsy.dubbomockserver.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: dongshuaiyin
 * @Description: 禁用状态枚举
 * @Date: 2023/4/25 21:30
 * @Modified by:
 */
@Getter
@AllArgsConstructor
public enum EnableEnum {

    UNALBE(0),
    ENABLE(1),
    ;

    private Integer code;
}
