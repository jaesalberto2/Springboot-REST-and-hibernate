package com.alberto.springcoredemo.config;

import com.alberto.springcoredemo.common.Coach;
import com.alberto.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // define bean for our sad
    @Bean("acuatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
