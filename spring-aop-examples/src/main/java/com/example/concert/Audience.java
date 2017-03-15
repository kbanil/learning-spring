package com.example.concert;

import org.aspectj.lang.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anil on 3/10/17.
 */
@Aspect
public class Audience {

    @Pointcut("execution(* com.example.concert.Performance.perform(..))")
    public void performance() {

    }

    @Before("performance()")
    public void silencePhones() {
        System.out.println("Silencing phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("Clap clap");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Give me my money back");
    }
}
