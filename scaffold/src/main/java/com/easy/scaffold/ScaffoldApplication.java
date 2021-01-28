package com.easy.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.easy.scaffold.sys.*.dao")
@EnableScheduling
public class ScaffoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaffoldApplication.class, args);
	}

    /**
     * 解决不能注入session注册表问题
     */
    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}



