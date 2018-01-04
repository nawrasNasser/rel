package com.app.config;


import com.app.config.security.SecurityConfig;
import com.rel.persistence.DBConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityConfig.class, DBConfig.class})
public class MainConfig {
}
