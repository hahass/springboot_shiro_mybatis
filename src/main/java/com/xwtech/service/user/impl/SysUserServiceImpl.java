package com.xwtech.service.user.impl;

import com.xwtech.entity.user.UserMapper;
import com.xwtech.model.user.SysUser;
import com.xwtech.service.user.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public SysUser selectByUserName(String name) {
        SysUser user = userMapper.selectUserByName(name);
        return user;
    }
}
