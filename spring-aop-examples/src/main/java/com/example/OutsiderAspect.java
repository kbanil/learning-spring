package com.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by anil on 3/10/17.
 */
@Aspect
public class OutsiderAspect {

    @DeclareParents(value = "com.example.* && !com.example.Outsider+ " +
            "&& !(@org.aspectj.lang.annotation.Aspect *)", defaultImpl = DefaultOutsider.class)
    public static Outsider outsider;

    @Before("execution(* com.example..*(..)) && this(outsider)")
    public void announceOutsider(Outsider outsider) {
        outsider.announce();
    }

}
