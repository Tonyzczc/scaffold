package com.easy.scaffold.config.init;

import com.easy.scaffold.sys.sysSetting.entity.SysSetting;
import com.easy.scaffold.sys.sysSetting.service.ISysSettingService;
import com.easy.scaffold.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author:Zhangchi
 * @date:2021-01-20 下午4:25
 **/
@Component
public class SysInit {

    @Autowired
    private ISysSettingService sysSettingService;

    @Bean
    public ApplicationRunner applicationRunner(){
        return applicationArguments->{
            try {
                //系统启动时获取数据库数据，设置到公用静态集合sysSettingMap
                SysSetting sysSetting = sysSettingService.getById(1);
                SysSettingUtil.setSysSettingMap(sysSetting);
            }catch (Exception e) {
            }
        };
    }
}
