package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by anil on 3/3/17.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorldBean bean = context.getBean("helloWorld",HelloWorldBean.class);
        bean.sayHello();
        System.out.println("Bean Definitions are --------->");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
