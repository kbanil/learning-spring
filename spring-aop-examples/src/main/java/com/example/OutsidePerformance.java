package com.example;

import com.example.concert.Performance;

/**
 * Created by anil on 3/10/17.
 */
public class OutsidePerformance implements Performance {
    public void perform() {
        System.out.println("Outside performance");
    }
}
