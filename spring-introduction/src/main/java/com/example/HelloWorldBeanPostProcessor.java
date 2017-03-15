package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by anil on 3/4/17.
 */
public class HelloWorldBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("Step 6: Call postProcessBeforeInitialization from BeanPostProcessor");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("Step 8: Call postProcessAfterInitialization from BeanPostProcessor");
        return o;
    }
}
