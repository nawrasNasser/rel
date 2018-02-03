package com.rel;

import com.rel.config.WebMvcConfigurer;
import com.rel.config.security.SecurityConfig;
import com.rel.persistence.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.*;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class,
        FreeMarkerAutoConfiguration.class,
        JmxAutoConfiguration.class,
        CacheAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@ComponentScan({
        "com.rel"
})
@Import({SecurityConfig.class, DBConfig.class,WebMvcConfigurer.class})
public class MainApp {
	public static void main(String[] args) throws Exception {
		new SpringApplication(MainApp.class).run(args);
	}
}
