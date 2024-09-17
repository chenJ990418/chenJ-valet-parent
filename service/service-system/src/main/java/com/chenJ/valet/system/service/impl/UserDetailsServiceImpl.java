package com.chenJ.valet.system.service.impl;


//import com.chenJ.valet.model.entity.system.SysUser;
//import com.chenJ.valet.system.service.SysMenuService;
//import com.chenJ.valet.system.service.SysUserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//
//@Component
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Resource
//    private SysUserService sysUserService;
//
//    @Resource
//    private SysMenuService sysMenuService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        SysUser sysUser = sysUserService.getByUsername(username);
//        if(null == sysUser) {
//            throw new UsernameNotFoundException("用户名不存在！");
//        }
//
//        if(!"admin".equals(sysUser.getUsername()) && sysUser.getStatus().intValue() == 0) {
//            throw new RuntimeException("账号已停用");
//        }
//        List<String> userPermsList = sysMenuService.findUserPermsList(sysUser.getId());
//        sysUser.setUserPermsList(userPermsList);
//        //List<SimpleGrantedAuthority> authorities = userPermsList.stream().filter(code -> StringUtils.hasText(code.trim())).map(code -> new SimpleGrantedAuthority(code.trim())).collect(Collectors.toList());
//        return new CustomUser(sysUser);
//    }
//}