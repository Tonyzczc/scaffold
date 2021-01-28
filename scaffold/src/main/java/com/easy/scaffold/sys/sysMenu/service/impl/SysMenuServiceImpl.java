package com.easy.scaffold.sys.sysMenu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.scaffold.sys.sysMenu.dao.SysMenuMapper;
import com.easy.scaffold.sys.sysMenu.entity.SysMenu;
import com.easy.scaffold.sys.sysMenu.service.ISysMenuService;
import com.easy.scaffold.sys.sysUserMenu.dao.SysUserMenuMapper;
import com.easy.scaffold.sys.sysUserMenu.entity.SysUserMenu;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author ZhangChi
 * @since 2020-11-23
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Resource
    private SysUserMenuMapper sysUserMenuMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> findByUserId(String userId) {
        List<SysMenu> menuVoList = new ArrayList<>();
        List<SysUserMenu> userMenu = sysUserMenuMapper.findByUserId(userId);
        userMenu.forEach((sysUserMenuVo) -> {
            SysMenu sysMenu = sysMenuMapper.selectById(sysUserMenuVo.getMenuId());
            if(StringUtils.isEmpty(sysMenu.getMenuParentId())){
                //上级节点
                menuVoList.add(sysMenu);
            }
        });
        userMenu.forEach((sysUserMenuVo) -> {
//            SysMenu sysMenuVo = sysUserMenuVo.getSysMenu();
            SysMenu sysMenuVo = sysMenuMapper.selectById(sysUserMenuVo.getMenuId());
            if(!StringUtils.isEmpty(sysMenuVo.getMenuParentId())){
                //子节点
                menuVoList.forEach((sysMenuVoP) -> {
                    if(sysMenuVoP.getMenuId().equals(sysMenuVo.getMenuParentId())){
                        sysMenuVoP.getChildren().add(sysMenuVo);
                    }
                });
            }
        });
        return menuVoList;
    }

    @Override
    public List<SysMenu> listByTier(SysMenu sysMenu) {
        List<SysMenu> menuVoList = new ArrayList<>();
        List<SysMenu> sysMenuVoList =sysMenuMapper.selectList(null);
        sysMenuVoList.forEach((sysMenuVo) -> {
            if(StringUtils.isEmpty(sysMenuVo.getMenuParentId())){
                //上级节点
                menuVoList.add(sysMenuVo);
            }
        });
        sysMenuVoList.forEach((sysMenuVo) -> {
            if(!StringUtils.isEmpty(sysMenuVo.getMenuParentId())){
                //子节点
                menuVoList.forEach((sysMenuVoP) -> {
                    if(sysMenuVoP.getMenuId().equals(sysMenuVo.getMenuParentId())){
                        sysMenuVoP.getChildren().add(sysMenuVo);
                    }
                });
            }
        });
        return menuVoList;
    }
}
