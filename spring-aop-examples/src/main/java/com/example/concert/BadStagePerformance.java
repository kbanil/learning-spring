package com.example.concert;

/**
 * Created by anil on 3/10/17.
 */
public class BadStagePerformance implements Performance {
    public void perform() {
        System.out.println("Bad stage performance");
        throw new RuntimeException("Bad Performance");
    }
}
