package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by anil on 3/3/17.
 */
public class HelloWorldBean
        implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean, ApplicationContextAware {

    private String name;

    public HelloWorldBean() {
        System.out.println("Step 1: Create bean");
    }

    public void sayHello() {
        System.out.println("Step 9: Bean ready for use");
        System.out.println("Hello " + name);
    }

    public void setName(String name) {
        System.out.println("Step 2: Populate references");
        this.name = name;
    }

    public void setBeanName(String s) {
        System.out.println("Step 3: Call setBeanName from BeanNameAware");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Step 4: Call setBeanFactory from BeanFactoryAware");
    }

    public void destroy() throws Exception {
        System.out.println("Step 10a: Call destroy from DisposableBean");
    }

    public void customDestroyMethod() {
        System.out.println("Step 10b: Call custom destroy method defined in context file");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Step 7a: Call afterPropertiesSet from InitializingBean");
    }

    public void customInitMethod() {
        System.out.println("Step 7b: Call custom init-method defined in context file");
    }

/*
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("Step 6: Call postProcessBeforeInitialization from BeanPostProcessor");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("Step 8: Call postProcessAfterInitialization from BeanPostProcessor");
        return o;
    }
*/

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Step 5: Call setApplicationContextAware from ApplicationContextAware");
    }

    @PostConstruct
    public void anotherInitialize() {
        System.out.println("Step ??: Call @PostConstruct");
    }

    @PreDestroy
    public void anotherDestroy() {
        System.out.println("Step ??: Call @PreDestroy");
    }
}
