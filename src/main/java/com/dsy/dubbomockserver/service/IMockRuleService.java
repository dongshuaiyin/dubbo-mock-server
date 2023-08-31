package com.dsy.dubbomockserver.service;

import com.dsy.dubbomockserver.bean.dto.MockRuleDto;
import com.dsy.dubbomockserver.bean.dto.QueryMockRuleDto;
import com.dsy.dubbomockserver.bean.vo.MockRuleVo;
import com.dsy.dubbomockserver.entity.MockRule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dongshuaiyin
 * @since 2023-04-25
 */
public interface IMockRuleService extends IService<MockRule> {

    String getMockValue(String serviceName, String methodName);

    Map<Integer, String> getWrapperText();

    boolean saveOrUpdateRule(MockRuleDto dto);

    List<MockRuleVo> selectList(QueryMockRuleDto dto);
}
