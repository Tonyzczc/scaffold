package com.easy.scaffold.sys.sysUser.controller;

import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.sys.sysUser.entity.SysUser;
import com.easy.scaffold.sys.sysUser.service.ISysUserService;
import com.easy.scaffold.util.SysSettingUtil;
import com.easy.scaffold.util.UUIDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:Zhangchi
 * @date:2021-01-20 上午10:53
 **/
@RestController
@RequestMapping("/sys/sysUser/")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("user")
    public ModelAndView user(){
        return new ModelAndView("sys/user/user","initPassword", SysSettingUtil.getSysSetting().getUserInitPassword());
    }

    @PostMapping("save")
    public Result<Boolean> save(SysUser sysUser){
        if(StringUtils.isNotBlank(sysUser.getUserId())){
            return Result.of(sysUserService.updateById(sysUser));
        }
        sysUser.setUserId(UUIDUtil.getUUID());
        return Result.of(sysUserService.save(sysUser));
    }

    @PostMapping("page")
    public Result<PageInfo> page(Integer page, Integer rows){
        Page<SysUser> pages = PageHelper.startPage(page, rows);
        return Result.of(new PageInfo(sysUserService.list()));
    }
}
