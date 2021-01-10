package com.pozhenskii.spring.rest.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //времено храню пароли в проекте! Исправлю на DB!
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        //создаём юзеров
        auth.inMemoryAuthentication()
                .withUser(userBuilder
                        .username("oleg")
                        .password("oleg")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder
                        .username("elena")
                        .password("elena")
                        .roles("HR"))
                .withUser(userBuilder
                        .username("dasha")
                        .password("dasha")
                        .roles("MANAGER", "HR"));
    }
}
