package com.dsy.dubbomockserver.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: dongshuaiyin
 * @Description: 默认包装枚举
 * @Date: 2023/4/25 21:12
 * @Modified by:
 */
@Getter
public enum DefaultWrapperEnum {

    NO(0, ""),
    XINAO_SUCCESS(1, "{\"code\":0,\"data\":%s,\"message\":\"mock-success\"}"),
    XINAO_FAIL(2, "{\"code\":1,\"data\":%s,\"message\":\"mock-error\"}"),
    ;

    private int seq;

    private String content;

    DefaultWrapperEnum(int seq, String content) {
        this.seq = seq;
        this.content = content;
    }

    private static Map<Integer, DefaultWrapperEnum> mapIdentity = new HashMap<>();

    static {
        mapIdentity = Arrays.stream(DefaultWrapperEnum.values()).collect(Collectors.toMap(DefaultWrapperEnum::getSeq, Function.identity(), (e1,e2) -> e1));
    }

    /**
     * 拿到需要包装的文本
     * @param seq
     * @return
     */
    public static String getWrapperText(Integer seq) {
        if (!mapIdentity.containsKey(seq)) {
            return "";
        }
        return mapIdentity.get(seq).getContent();
    }

    public boolean isTrue(Integer seq) {
        return this.seq == seq;
    }
}
