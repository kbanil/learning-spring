package com.example.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

/**
 * Created by anil on 3/6/17.
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer cdPlayer() {
        CDPlayer cdPlayer = new CDPlayer(sgtPeppers());
        return cdPlayer;
    }

    @Bean
    @Profile("dev")
    public DataSource dataSourceForDev() {
        return new EmbeddedDatabaseBuilder().build();
    }
}
