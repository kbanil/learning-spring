package com.example.concert;

import com.example.OutsidePerformance;
import com.example.OutsiderAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by anil on 3/10/17.
 */
@Configuration
@ComponentScan(basePackageClasses = Audience.class)
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public GateKeeperAspect gateKeeper() {
        return new GateKeeperAspect();
    }

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Performance goodStagePerformance() {
        return new GoodStagePerformace();
    }

    @Bean
    public Performance badStagePerformance() {
        return new BadStagePerformance();
    }

    @Bean
    public Performance outsidePerformance() {
        return new OutsidePerformance();
    }

    @Bean
    public OutsiderAspect outsiderAspect() {
        return new OutsiderAspect();
    }
}
