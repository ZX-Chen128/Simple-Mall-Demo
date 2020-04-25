package com.czx.easydemo.controller;

import com.czx.easydemo.common.api.CommonResult;
import com.czx.easydemo.model.User;
import com.czx.easydemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/user")
@Api(tags = "UserController", description = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("创建用户")
    @RequestMapping(value = "/creatUser", method = RequestMethod.POST)
    public CommonResult<Integer> creatUser(User user) {
        int creatUser = userService.creatUser(user);
        return CommonResult.success(creatUser);
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public CommonResult<Integer> deleteUser(Long id) {
        int creatUser = userService.deletcUser(id);
        return CommonResult.success(creatUser);
    }

    @ApiOperation("修改用户")
    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public CommonResult<Integer> changeUser(User user) {
        int creatUser = userService.changeUser(user);
        return CommonResult.success(creatUser);
    }

    @ApiOperation("查找用户")
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public CommonResult<User> findUser(Long id) {
        User user = userService.findUser(id);
        return CommonResult.success(user);
    }
}