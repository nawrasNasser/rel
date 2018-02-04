package com.rel.front;


import com.rel.front.conf.SecurityConfig;
import com.rel.front.conf.WebMvcConfigurer;
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
@Import({DBConfig.class, WebMvcConfigurer.class,SecurityConfig.class})
public class MainApp extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        new SpringApplication(MainApp.class).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApp.class);
    }
}
