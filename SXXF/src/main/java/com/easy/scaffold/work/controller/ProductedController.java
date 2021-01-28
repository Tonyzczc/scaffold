package com.easy.scaffold.work.controller;


import com.easy.scaffold.common.pojo.Result;
import com.easy.scaffold.util.DateUtil;
import com.easy.scaffold.util.SecurityUtil;
import com.easy.scaffold.work.entity.Producted;
import com.easy.scaffold.work.service.IProductedService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * <p>
 * 成产批次表 前端控制器
 * </p>
 *
 * @author ZhangChi
 * @since 2021-01-22
 */
@Controller
@RequestMapping("/work/produced")
public class ProductedController {

    @Autowired
    private IProductedService productedService;

    @GetMapping("")
    public ModelAndView user(){
        return new ModelAndView("work/producted");
    }


    @RequestMapping("selectWorkId")
    @ResponseBody
    public Result selectWorkId(String workid){

        return Result.of(productedService.selectWorkId(workid));
    }

    @RequestMapping("save")
    @ResponseBody
    public Result save(Producted producted){
        User loginUser = SecurityUtil.getLoginUser();
        producted.setUpdateuser(loginUser.getUsername());
        producted.setUpdatedate(DateUtil.asLocalDateTime(new Date()));
        producted.setCreateuser(loginUser.getUsername());
        producted.setCreatedate(DateUtil.asLocalDateTime(new Date()));
        producted.setId(null);
        return Result.of(productedService.save(producted));
    }






}

