package com.easy.scaffold.sys.sysUserMenu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.scaffold.sys.sysUserMenu.dao.SysUserMenuMapper;
import com.easy.scaffold.sys.sysUserMenu.entity.SysUserMenu;
import com.easy.scaffold.sys.sysUserMenu.service.ISysUserMenuService;
import com.easy.scaffold.util.DateUtil;
import com.easy.scaffold.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户菜单表 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
@Service
public class SysUserMenuServiceImpl extends ServiceImpl<SysUserMenuMapper, SysUserMenu> implements ISysUserMenuService {

    @Resource
    SysUserMenuMapper sysUserMenuMapper;
    @Override
    public boolean saveAllByUserId(String userId, String menuIdList) {

        List<SysUserMenu> usermenus = sysUserMenuMapper.findByUserId(userId);
        for (SysUserMenu userMenu : usermenus){
            sysUserMenuMapper.deleteById(userMenu.getUserMenuId());
        }

        //再保存新的
        for (String menuId : menuIdList.split(",")) {
            SysUserMenu sysUserMenuVo = new SysUserMenu();
            sysUserMenuVo.setUserId(userId);
            sysUserMenuVo.setMenuId(menuId);
            sysUserMenuVo.setUserMenuId(UUIDUtil.getUUID());
            sysUserMenuVo.setCreateTime(DateUtil.asLocalDateTime(new Date()));
            sysUserMenuVo.setUpdateTime(DateUtil.asLocalDateTime(new Date()));
            sysUserMenuMapper.insert(sysUserMenuVo);
        }
        return false;
    }
}
