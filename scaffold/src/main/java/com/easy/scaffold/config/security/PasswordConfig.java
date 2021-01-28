package com.easy.scaffold.config.security;

import com.easy.scaffold.util.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author:Zhangchi
 * @date:2021-01-20 下午5:08
 **/
@Component
public class PasswordConfig implements PasswordEncoder {

    /**
     * charSequence是用户输入的密码，password是存库的密码
     * @param charSequence
     * @return
     */
    @Override
    public String encode(CharSequence charSequence) {
        return MD5Util.getMD5(charSequence.toString());
    }


    @Override
    public boolean matches(CharSequence charSequence, String password) {
        return password.contentEquals(encode(charSequence));
    }
}
