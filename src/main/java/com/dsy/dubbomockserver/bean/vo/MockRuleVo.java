package com.dsy.dubbomockserver.bean.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dsy.dubbomockserver.entity.MockRule;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: dongshuaiyin
 * @Description: 查询视图对象
 * @Date: 2023/4/26 17:48
 * @Modified by:
 */
@Data
@ToString
public class MockRuleVo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 是否启用 0 不启用 1 启用
     */
    private Integer enable;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    public static List<MockRuleVo> convertToVo(List<MockRule> mockRules) {
        return JSONArray.parseArray(JSON.toJSONString(mockRules), MockRuleVo.class);
    }
}
