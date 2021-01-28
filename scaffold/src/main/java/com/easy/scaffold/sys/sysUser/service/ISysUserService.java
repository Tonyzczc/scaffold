package com.easy.scaffold.sys.sysUser.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.scaffold.sys.sysUser.entity.SysUser;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface ISysUserService extends IService<SysUser> {

    SysUser getUserByLoginName(String loginName);
}
