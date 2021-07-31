package com.sambhav.testautomationspring.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class WebDriverWaitConfig {
    @Value("${timeout:30}")
    private Long timeout;

    @Bean
    public WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, this.timeout);
    }
}
