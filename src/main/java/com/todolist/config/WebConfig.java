package com.todolist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Register beans for spring mvc
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.todolist")
public class WebConfig {
}
