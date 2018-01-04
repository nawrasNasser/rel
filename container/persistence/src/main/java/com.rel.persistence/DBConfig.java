package com.rel.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableJpaRepositories(basePackages ={"com.rel.persistence.repo"})
@EntityScan(basePackages ={ "com.rel.persistence.model"})
@PropertySource(ignoreResourceNotFound=false,value="classpath:db.properties")
@EnableTransactionManagement
public class DBConfig {

}
