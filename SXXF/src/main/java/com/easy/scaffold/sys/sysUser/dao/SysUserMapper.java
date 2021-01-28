package com.easy.scaffold.sys.sysUser.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.scaffold.sys.sysUser.entity.SysUser;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 用户登录查询
     * @param loginName
     * @return
     */
    SysUser selUserByLoginName(String loginName);
}
