package com.easy.scaffold.sys.sysUserAuthority.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.scaffold.sys.sysUserAuthority.entity.SysUserAuthority;

import java.util.List;

/**
 * <p>
 * 用户权限表 Mapper 接口
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface SysUserAuthorityMapper extends BaseMapper<SysUserAuthority> {


    /**
     * 用户权限查询
     * @param userId
     * @return
     */
    List<SysUserAuthority> findByUserId(String userId);
}
