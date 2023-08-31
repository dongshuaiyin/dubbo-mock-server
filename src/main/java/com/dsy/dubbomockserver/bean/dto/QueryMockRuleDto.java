package com.dsy.dubbomockserver.bean.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dsy.dubbomockserver.entity.MockRule;

import java.util.Objects;

/**
 * @Author: dongshuaiyin
 * @Description:
 * @Date: 2023/4/26 17:53
 * @Modified by:
 */
public class QueryMockRuleDto {

    /**
     * 主键--回显的时候用
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
     * 是否开启
     */
    private Integer enable;

    public void addWrapper(QueryWrapper<MockRule> queryWrapper) {
        if (!Objects.isNull(this.id)) {
            queryWrapper.eq("id", this.id);
        }
        if (!Objects.isNull(this.serviceName)) {
            queryWrapper.eq("service_name", this.serviceName);
        }
        if (!Objects.isNull(this.methodName)) {
            queryWrapper.eq("method_name", this.methodName);
        }
        if (!Objects.isNull(this.enable)) {
            queryWrapper.eq("enable", this.enable);
        }
    }
}
