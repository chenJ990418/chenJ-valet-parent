package com.chenJ.valet.security.service;

import com.chenJ.valet.model.entity.system.SysUserDo;
import com.chenJ.valet.security.custom.CustomUser;
import com.chenJ.valet.system.client.SecurityLoginFeignClient;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SecurityLoginFeignClient securityLoginFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserDo sysUser = securityLoginFeignClient.getByUsername(username).getData();
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        if (!"admin".equals(sysUser.getUsername()) && sysUser.getStatus().intValue() == 0) {
            throw new RuntimeException("账号已停用");
        }
        List<String> userPermsList = securityLoginFeignClient.findUserPermsList(sysUser.getId()).getData();
        sysUser.setUserPermsList(userPermsList);
        return new CustomUser(sysUser);
    }
}