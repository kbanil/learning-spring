package com.example.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by anil on 3/10/17.
 */
@Aspect
public class GateKeeperAspect {

    @Pointcut("execution(* com.example.concert.Performance.perform(..))")
    public void performance() {

    }

    @Before("performance()")
    public void openDoor() {
        System.out.println("Opening doors");
    }
}
