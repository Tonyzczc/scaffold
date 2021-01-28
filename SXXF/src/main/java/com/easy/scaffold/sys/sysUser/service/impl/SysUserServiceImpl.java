package com.easy.scaffold.sys.sysUser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.scaffold.sys.sysUser.dao.SysUserMapper;
import com.easy.scaffold.sys.sysUser.entity.SysUser;
import com.easy.scaffold.sys.sysUser.service.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByLoginName(String loginName){
        return sysUserMapper.selUserByLoginName(loginName);
    }
}
