package com.easy.scaffold.config.security;

import com.easy.scaffold.sys.sysAuthority.service.ISysAuthorityService;
import com.easy.scaffold.sys.sysUser.entity.SysUser;
import com.easy.scaffold.sys.sysUser.service.ISysUserService;
import com.easy.scaffold.sys.sysUserAuthority.entity.SysUserAuthority;
import com.easy.scaffold.sys.sysUserAuthority.service.ISysUserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author:Zhangchi
 * @date:2021-01-20 下午4:51
 **/
@Component
public class UserConfig implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysUserAuthorityService sysUserAuthorityService;

    @Autowired
    private ISysAuthorityService sysAuthorityService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /**
         * 查询用户
         */
        SysUser loginUser = sysUserService.getUserByLoginName(userName);

        if(loginUser == null || StringUtils.isEmpty(loginUser.getUserId())){
            return null;
        }
        //用户权限
        List<SysUserAuthority> serAuthorityList = sysUserAuthorityService.findByUserId(loginUser.getUserId());
        StringBuilder authorityList = new StringBuilder();
        for (int i = 0; i < serAuthorityList.size(); i++) {
            SysUserAuthority sysUserAuthorityVo = serAuthorityList.get(i);
            authorityList.append(sysAuthorityService.getById( sysUserAuthorityVo.getAuthorityId()).getAuthorityName());
            if (i != serAuthorityList.size() - 1) {
                authorityList.append(",");
            }
        }

        //封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new User(loginUser.getLoginName(), loginUser.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorityList.toString()));
    }
}
