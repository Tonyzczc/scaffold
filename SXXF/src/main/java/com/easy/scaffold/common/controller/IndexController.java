package com.easy.scaffold.common.controller;

import com.easy.scaffold.sys.sysMenu.entity.SysMenu;
import com.easy.scaffold.sys.sysMenu.service.ISysMenuService;
import com.easy.scaffold.sys.sysUser.entity.SysUser;
import com.easy.scaffold.sys.sysUser.service.ISysUserService;
import com.easy.scaffold.sys.sysUserMenu.service.ISysUserMenuService;
import com.easy.scaffold.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author:Zhangchi
 * @date:2021-01-20 下午4:22
 **/
@Slf4j
@Controller
@RequestMapping("/")
@Configuration
public class IndexController {


    @Autowired
    private ISysUserService sysUserService;
//
//    @Autowired
//    private SysSettingService sysSettingService;

    @Autowired
    private ISysUserMenuService sysUserMenuService;

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;


    /**
     * 跳转登录页面
     */
    @GetMapping("loginPage")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");

        //系统信息
        modelAndView.addObject("sys", SysSettingUtil.getSysSetting());

//        //后端公钥
//        String publicKey = RsaUtil.getPublicKey();
//        log.info("后端公钥：" + publicKey);
//        modelAndView.addObject("publicKey", publicKey);

        return modelAndView;
    }


    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");

        //系统信息
        modelAndView.addObject("sys", SysSettingUtil.getSysSetting());

        //登录用户
        SysUser sysUserVo = sysUserService.getUserByLoginName(SecurityUtil.getLoginUser().getUsername());
        sysUserVo.setPassword(null);
        modelAndView.addObject( "loginUser", sysUserVo);
//
        //登录用户系统菜单
        java.util.List<SysMenu> menuVoList = sysMenuService.findByUserId(sysUserVo.getUserId());
        modelAndView.addObject("menuList",menuVoList);

//        //后端公钥
//        String publicKey = RsaUtil.getPublicKey();
//        log.info("后端公钥：" + publicKey);
//        modelAndView.addObject("publicKey", publicKey);

        return modelAndView;
    }

    /**
     * 跳转首页
     */
    @GetMapping("")
    public void index1(HttpServletResponse response){
        //内部重定向
        try {
            response.sendRedirect("/index");
        } catch (IOException e) {
            //输出到日志文件中
            log.error(ErrorUtil.errorInfoToString(e));
        }
    }


    /**
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
     */
    @RequestMapping("getVerifyCodeImage")
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.getOutputStream();
        String verifyCode = VerifyCodeImageUtil.generateTextCode(VerifyCodeImageUtil.TYPE_NUM_UPPER, 4, null);

        //将验证码放到HttpSession里面
        request.getSession().setAttribute("verifyCode", verifyCode);
        log.info("本次生成的验证码为：" + verifyCode + ",已存放到HttpSession中");

        //设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeImageUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);

        //写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }


    /**
     * 跳转实时系统硬件监控
     */
    @GetMapping("monitor")
    public ModelAndView monitor() {
        return new ModelAndView("monitor.html","port",port);
    }

    /**
     * 跳转实时日志
     */
    @GetMapping("logging")
    public ModelAndView logging() {
        return new ModelAndView("logging.html","port",port);
    }

}
