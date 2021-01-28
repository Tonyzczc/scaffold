package com.easy.scaffold.sys.sysUserAuthority.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.scaffold.sys.sysUserAuthority.entity.SysUserAuthority;

import java.util.List;

/**
 * <p>
 * 用户权限表 服务类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface ISysUserAuthorityService extends IService<SysUserAuthority> {


    List<SysUserAuthority> findByUserId(String userId);
}
