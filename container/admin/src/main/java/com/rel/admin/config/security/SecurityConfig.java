package com.rel.admin.config.security;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final static String LOGIN_URL ="api/auth/login";

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/**","/assets/**",
            "*.html","/index.html","/*.html" ,"/home.html", "/login.html", "/","/*.css","/*.js","/*.png");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests().antMatchers("/api/auth/login","/index.html", "/home.html",
            "http://localhost:4200/api/auth/login",
            "/login.html", "/","/*.css","/*.js","/*.png").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin().loginPage("http://localhost:4200/login")
            .usernameParameter("username").passwordParameter("password")
            .loginProcessingUrl("/api/auth/login")
            .successForwardUrl("/")
            .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .permitAll().logoutSuccessUrl("/");
    }


    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.getSessionCookieConfig().setPath("/");
            }
        };

    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
         return new AuthProvider();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
