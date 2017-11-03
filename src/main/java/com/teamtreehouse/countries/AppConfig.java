package com.teamtreehouse.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Trang on 11/02/2017.
 */
@EnableAutoConfiguration
@ComponentScan
public class AppConfig {

    public static void main(String[] args){
        SpringApplication.run(AppConfig.class, args);
    }
}
