package com.easy.scaffold.config.security;

import com.easy.scaffold.sys.sysAuthority.entity.SysAuthority;
import com.easy.scaffold.sys.sysAuthority.service.ISysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Zhangchi
 * @date:2021-01-20 下午5:10
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CaptchaFilterConfig captchaFilterConfig;

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private PasswordConfig passwordConfig;

    @Autowired
    private LoginFailureHandlerConfig loginFailureHandlerConfig;

    @Autowired
    private LoginSuccessHandlerConfig loginSuccessHandlerConfig;

    @Autowired
    private MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    @Autowired
    private ISysAuthorityService sysAuthorityService;


    /**
     * 用户认证处理 、 密码处理
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userConfig)
                .passwordEncoder(passwordConfig);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();
        http
                //登录处理
                .addFilterBefore(captchaFilterConfig, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginProcessingUrl("/login")
                //未登录时默认跳转页面
                .loginPage("/loginPage")
                .failureHandler(loginFailureHandlerConfig)
                .successHandler(loginSuccessHandlerConfig)
                .permitAll()
                .and();

        http
                //定制url访问权限，动态权限读取，参考：https://www.jianshu.com/p/0a06496e75ea
                .addFilterAfter(dynamicallyUrlInterceptor(), FilterSecurityInterceptor.class)
                .authorizeRequests()

                //无需权限访问
                .antMatchers("/favicon.ico","/common/**", "/webjars/**", "/getVerifyCodeImage","/error/*").permitAll()

                //其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();
    }


    /**
     * 配置filter
     * @return
     */
    @Bean
    public DynamicallyUrlInterceptor dynamicallyUrlInterceptor(){
        //首次获取
        List<SysAuthority> authorityVoList = sysAuthorityService.list();
        myFilterInvocationSecurityMetadataSource.setRequestMap(authorityVoList);
        //初始化拦截器并添加数据源
        DynamicallyUrlInterceptor interceptor = new DynamicallyUrlInterceptor();
        interceptor.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);

        //配置RoleVoter决策
        List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<>();
        decisionVoters.add(new RoleVoter());

        //设置认证决策管理器
        interceptor.setAccessDecisionManager(new MyAccessDecisionManager(decisionVoters));
        return interceptor;
    }

}
