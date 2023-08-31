package com.dsy.dubbomockserver.controller;


import com.dsy.dubbomockserver.bean.base.ResultDto;
import com.dsy.dubbomockserver.bean.dto.MockRuleDto;
import com.dsy.dubbomockserver.bean.dto.QueryMockRuleDto;
import com.dsy.dubbomockserver.bean.vo.MockRuleVo;
import com.dsy.dubbomockserver.service.IMockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dongshuaiyin
 * @since 2023-04-25
 */
@RestController
@RequestMapping("/mock")
public class MockRuleController {

    @Autowired
    private IMockRuleService mockRuleService;

    /**
     * 拿到mock结果
     * @param serviceName
     * @param methodName
     * @return
     */
    @GetMapping("/getMockValue/{service}/{method}")
    public String getMockValue(@PathVariable("service")String serviceName, @PathVariable("method")String methodName) {
        return mockRuleService.getMockValue(serviceName, methodName);
    }

    /**
     * 获取包装文本
     * @return
     */
    @GetMapping("/getWraaperText")
    public ResultDto<Map<Integer, String>> getWrapperText() {
        return new ResultDto<>(mockRuleService.getWrapperText());
    }

    /**
     * 保存mock规则
     * @param dto
     * @return
     */
    @PostMapping("/saveOrUpdateRule")
    public ResultDto<Boolean> saveOrUpdateRule(@RequestBody MockRuleDto dto) {
        return new ResultDto<>(mockRuleService.saveOrUpdateRule(dto));
    }

    /**
     * 查询列表
     * @param dto
     * @return
     */
    @PostMapping("/selectList")
    public ResultDto<List<MockRuleVo>> selectList(@RequestBody QueryMockRuleDto dto) {
        return new ResultDto<>(mockRuleService.selectList(dto));
    }
}

