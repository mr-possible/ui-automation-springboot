package com.sambhav.testautomationspring.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class DriverFactory {

    @Bean
    public WebDriver getDriver(String param) {
        if (param.equals("chrome")) {
            return new ChromeDriver();
        } else if (param.equals("firefox")) {
            return new FirefoxDriver();
        } else {
            return null;
        }
    }
}
