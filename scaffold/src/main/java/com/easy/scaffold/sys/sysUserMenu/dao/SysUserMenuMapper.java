package com.easy.scaffold.sys.sysUserMenu.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.scaffold.sys.sysUserMenu.entity.SysUserMenu;

import java.util.List;

/**
 * <p>
 * 用户菜单表 Mapper 接口
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
public interface SysUserMenuMapper extends BaseMapper<SysUserMenu> {

    List<SysUserMenu> findByUserId(String userId);
}
