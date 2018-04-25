package com.xwtech.service.user;

import com.xwtech.model.user.SysUser;

public interface SysUserService {
    SysUser selectByUserName(String name);
}
