package com.easy.scaffold.sys.sysUserAuthority.controller;


import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.sys.sysAuthority.service.ISysAuthorityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/sysAuthority/")
public class SysAuthorityController {
    @Autowired
    private ISysAuthorityService sysAuthorityService;

    @GetMapping("authority")
    public ModelAndView authority(){
        return new ModelAndView("sys/authority/authority");
    }

    @PostMapping("page")
    public Result<PageInfo> page(Integer page, Integer rows){
        Page<Object> pages = PageHelper.startPage(page, rows);
        return Result.of(new PageInfo<>(sysAuthorityService.list()));
    }
}
