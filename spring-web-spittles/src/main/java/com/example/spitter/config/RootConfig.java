package com.example.spitter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by anil on 3/12/17.
 */
@Configuration
@ComponentScan(basePackages = "{com.example.spitter}",excludeFilters = {
        @Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
}
