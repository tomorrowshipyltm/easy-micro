package com.micro.custom.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.easy.micro.common.api.CommonPage;
import com.easy.micro.common.api.CommonResult;
import com.easy.micro.common.api.ResultCode;
import com.easy.micro.common.constant.AuthConstant;
import com.easy.micro.common.domain.UserDto;
import com.easy.micro.common.exception.Asserts;
import com.micro.custom.dto.CustomDataView;
import com.micro.custom.service.CustomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户业务管理Controller
 * 1. /list 模拟业务数据，需要通过micro-admini controller暴露，并且还需要新增role-resource表，否则403无权
 * 2. /current/user 演示了下游微服务从request.header获取userId/name，用于二次访问控制或其它逻辑
 */
@Api(tags = "CustomController", description = "模拟业务接口")
@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomService customService;
    @Autowired
    private HttpServletRequest request;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomController.class);


    @ApiOperation(value = "获取数据列表, 用户业务api demo")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CustomDataView>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<CustomDataView> data = customService.listData(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(data));
    }

    @ApiOperation(value = "下游微服务获取当前user")
    @RequestMapping(value = "/current/user", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UserDto> getCurrentUser() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if (StrUtil.isEmpty(userStr)) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        // UserDto(id=3, username=null, password=null, status=null, clientId=admin-app, roles=null)
        return CommonResult.success(userDto);
    }
}
