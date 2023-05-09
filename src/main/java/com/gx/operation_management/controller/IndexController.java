package com.gx.operation_management.controller;


import com.gx.operation_management.exception.GuiguException;
import com.gx.operation_management.jwt.JwtHelper;
import com.gx.operation_management.pojo.LoginVo;
import com.gx.operation_management.pojo.SysUser;
import com.gx.operation_management.result.Result;
import com.gx.operation_management.security.utils.MD5;
import com.gx.operation_management.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sysUser")
public class IndexController {


    @Autowired
    private SysUserService sysUserService;

    @PostMapping("index")
    public Result login(@RequestBody LoginVo loginVo){
        SysUser sysUser = sysUserService.getByUsername(loginVo.getUsername());


        if(null == sysUser) {
            throw new GuiguException(201,"用户不存在");
        }
        if(!MD5.encrypt(loginVo.getPassword()).equals(loginVo.getPassword())) {
            throw new GuiguException(201,"密码错误");
        }
        if(sysUser.getStatus().intValue() == 0) {
            throw new GuiguException(201,"用户被禁用");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(sysUser.getId(), sysUser.getUsername()));
        return Result.ok(map);
    }



}
