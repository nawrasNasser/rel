package com.rel.admin;

import com.rel.admin.config.WebMvcConfigurer;
import com.rel.admin.config.security.SecurityConfig;
import com.rel.persistence.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({
        "com.rel"
})
@Import({SecurityConfig.class, DBConfig.class,WebMvcConfigurer.class})
public class MainApp extends SpringBootServletInitializer {
	public static void main(String[] args) throws Exception {
		new SpringApplication(MainApp.class).run(args);
	}

            @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApp.class);
    }
}
