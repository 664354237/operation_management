package com.gx.operation_management.service;

import com.gx.operation_management.pojo.SysUser;

public interface SysUserService {


    SysUser getByUsername(String username);
}
