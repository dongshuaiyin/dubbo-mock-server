package com.dsy.dubbomockserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dsy.dubbomockserver.bean.dto.MockRuleDto;
import com.dsy.dubbomockserver.bean.dto.QueryMockRuleDto;
import com.dsy.dubbomockserver.bean.vo.MockRuleVo;
import com.dsy.dubbomockserver.entity.MockRule;
import com.dsy.dubbomockserver.enums.DefaultWrapperEnum;
import com.dsy.dubbomockserver.enums.EnableEnum;
import com.dsy.dubbomockserver.mapper.MockRuleMapper;
import com.dsy.dubbomockserver.service.IMockRuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dongshuaiyin
 * @since 2023-04-25
 */
@Service
public class MockRuleServiceImpl extends ServiceImpl<MockRuleMapper, MockRule> implements IMockRuleService {

    @Override
    public String getMockValue(String serviceName, String methodName) {
//        LambdaQueryWrapper<MockRule> queryWrapper = new LambdaQueryWrapper<>();
        QueryWrapper<MockRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntityClass(MockRule.class)
                .eq("service_name", serviceName)
                .eq("method_name", methodName)
                .eq("enable", EnableEnum.ENABLE.getCode());
        MockRule mockRule = this.baseMapper.selectOne(queryWrapper);
        if (Objects.isNull(mockRule)) {
            return "为查询到mock-value，请检查配置";
        }
        if (DefaultWrapperEnum.NO.isTrue(mockRule.getBaseWrapper())) {
            return mockRule.getRule();
        }
        String wrapperText = DefaultWrapperEnum.getWrapperText(mockRule.getBaseWrapper());
        return String.format(wrapperText, mockRule.getRule());
    }

    @Override
    public Map<Integer, String> getWrapperText() {
        return Arrays.stream(DefaultWrapperEnum.values()).collect(Collectors.toMap(DefaultWrapperEnum::getSeq, DefaultWrapperEnum::getContent));
    }

    @Override
    public boolean saveOrUpdateRule(MockRuleDto dto) {
        MockRule rule = MockRule.deepClone(dto);
        //初始化开启状态
        rule.setEnable(EnableEnum.UNALBE.getCode());
        if (null == dto.getId()) {
            return super.save(rule);
        }
        Integer result = baseMapper.updateById(rule);
        return null != result && result >= 1;
    }

    @Override
    public List<MockRuleVo> selectList(QueryMockRuleDto dto) {
        QueryWrapper<MockRule> queryWrapper = new QueryWrapper<>();
        dto.addWrapper(queryWrapper);
        queryWrapper.orderByDesc("updated_at");
        List<MockRule> mockRules = baseMapper.selectList(queryWrapper);
        return MockRuleVo.convertToVo(mockRules);
    }
}
