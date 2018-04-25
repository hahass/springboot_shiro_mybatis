package com.xwtech.model.user;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUser  {
    private static final long serialVersionUID = 5898441540965086534L;

    /**
     * 用户ID
     */
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String salt;

    private String endTime;

    /**
     * 拥有的角色列表
     */
    private List<SysRole> roleList;

    private String locked;

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解

}
