package com.pozhenskii.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; //не трогаем
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class}; //ApplicationConfig
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //despatcer - "/"
    }
}
