package com.example.spitter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by anil on 3/11/17.
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
