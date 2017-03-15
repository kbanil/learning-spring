package com.example.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by anil on 3/7/17.
 */
@Configuration
public class MagicConditionConfig {

    @Bean
    @Conditional(MagicCondition.class)
    @Profile("dev,prod")
    public Object someObject() {
        return new Object();
    }
}
