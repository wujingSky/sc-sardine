package com.hd123.sardine.turbine;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableTurbineStream
public class SardineTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(SardineTurbineApplication.class, args);
    }

    @Configuration
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
            http.logout().logoutUrl("/logout");
            http.csrf().disable();

            http.authorizeRequests()
                    .antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**")
                    .permitAll();
            http.authorizeRequests().antMatchers("/**").authenticated();
            http.httpBasic();
        }
    }
}
