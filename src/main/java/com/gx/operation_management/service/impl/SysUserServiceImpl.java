package com.gx.operation_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.gx.operation_management.mapper.SysUserMapper;
import com.gx.operation_management.pojo.SysUser;
import com.gx.operation_management.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {


    private SysUserMapper sysUserMapper;
    //根据用户名查询
    @Override
    public SysUser getByUsername(String username) {

        LambdaQueryWrapper<SysUser> wrapper  = new LambdaQueryWrapper<>();
         wrapper.eq(SysUser::getUsername,username);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        return  sysUser;

    }
}
