package com.easy.scaffold.sys.sysUserAuthority.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.scaffold.sys.sysUserAuthority.dao.SysUserAuthorityMapper;
import com.easy.scaffold.sys.sysUserAuthority.entity.SysUserAuthority;
import com.easy.scaffold.sys.sysUserAuthority.service.ISysUserAuthorityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
@Service
public class SysUserAuthorityServiceImpl extends ServiceImpl<SysUserAuthorityMapper, SysUserAuthority> implements ISysUserAuthorityService {

    @Resource
    private SysUserAuthorityMapper sysUserAuthorityMapper;

    @Override
    public List<SysUserAuthority> findByUserId(String userId) {
        return sysUserAuthorityMapper.findByUserId(userId);
    }
}
