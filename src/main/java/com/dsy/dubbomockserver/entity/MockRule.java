package com.dsy.dubbomockserver.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dsy.dubbomockserver.bean.dto.MockRuleDto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author dongshuaiyin
 * @since 2023-04-25
 */
@TableName("mock_rule")
public class MockRule implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 创建时间
     */
      private LocalDateTime createdAt;

      /**
     * 更新时间
     */
      private LocalDateTime updatedAt;

    public static MockRule deepClone(MockRuleDto dto) {
        return JSON.parseObject(JSON.toJSONString(dto), MockRule.class);
    }


    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getServiceName() {
        return serviceName;
    }

      public void setServiceName(String serviceName) {
          this.serviceName = serviceName;
      }
    
    public String getMethodName() {
        return methodName;
    }

      public void setMethodName(String methodName) {
          this.methodName = methodName;
      }
    
    public String getRule() {
        return rule;
    }

      public void setRule(String rule) {
          this.rule = rule;
      }
    
    public Integer getBaseWrapper() {
        return baseWrapper;
    }

      public void setBaseWrapper(Integer baseWrapper) {
          this.baseWrapper = baseWrapper;
      }
    
    public Integer getEnable() {
        return enable;
    }

      public void setEnable(Integer enable) {
          this.enable = enable;
      }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

      public void setCreatedAt(LocalDateTime createdAt) {
          this.createdAt = createdAt;
      }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

      public void setUpdatedAt(LocalDateTime updatedAt) {
          this.updatedAt = updatedAt;
      }

    @Override
    public String toString() {
        return "MockRule{" +
              "id=" + id +
                  ", serviceName=" + serviceName +
                  ", methodName=" + methodName +
                  ", rule=" + rule +
                  ", baseWrapper=" + baseWrapper +
                  ", enable=" + enable +
                  ", createdAt=" + createdAt +
                  ", updatedAt=" + updatedAt +
              "}";
    }
}
