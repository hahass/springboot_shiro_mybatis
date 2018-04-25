package com.xwtech.entity.user;

import com.xwtech.model.user.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    SysUser selectUserByName(String username);
}
