package com.dsy.dubbomockserver.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author: dongshuaiyin
 * @Description: 增加规则对象
 * @Date: 2023/4/26 17:32
 * @Modified by:
 */
@Data
@ToString
public class MockRuleDto {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 服务名
     */
    private String serviceName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 规则
     */
    private String rule;

    /**
     * 默认包装 0 不包 1 新奥默认包装
     */
    private Integer baseWrapper;

}
