package com.easy.scaffold.util;


import com.easy.scaffold.sys.sysSetting.entity.SysSetting;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统设置工具类
 * 系统启动时获取数据库数据，设置到公用静态集合sysSettingMap
 * 更新系统设置时同步更新公用静态集合sysSettingMap
 */
public class SysSettingUtil {

    /**
     * 使用线程安全的ConcurrentHashMap来存储系统设置
     */
    private static ConcurrentHashMap<String, SysSetting> sysSettingMap = new ConcurrentHashMap<>();

    /**
     * 从公用静态集合sysSettingMap获取系统设置
     * @return
     */
    public static SysSetting getSysSetting(){
        return sysSettingMap.get("sysSetting");
    }

    /**
     * 更新公用静态集合sysSettingMap
     * @param sysSetting
     */
    public static void setSysSettingMap(SysSetting sysSetting){
        if(sysSettingMap.isEmpty()){
            sysSettingMap.put("sysSetting",sysSetting);
        }else{
            sysSettingMap.replace("sysSetting",sysSetting);
        }
    }
}
