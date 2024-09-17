package com.chenJ.valet.security.custom;

import com.chenJ.valet.model.entity.system.SysUserDo;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class CustomUser extends User {

    /**
     * 我们自己的用户实体对象，要调取用户信息时直接获取这个实体对象。（这里我就不写get/set方法了）
     */
    private SysUserDo sysUser;

    public CustomUser(SysUserDo sysUser) {
        super(sysUser.getUsername(), sysUser.getPassword(), new ArrayList<>());
        this.sysUser = sysUser;
    }

    public SysUserDo getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUserDo sysUser) {
        this.sysUser = sysUser;
    }

}

