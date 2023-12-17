package com.sambhav.testautomationspring.page;

import com.sambhav.testautomationspring.config.WebDriverWaitConfig;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWaitConfig webDriverWaitConfig;

    @PostConstruct
    private void init() {
        System.out.println("Initialising page object => " + this.getClass().getSimpleName());
        PageFactory.initElements(this.driver, this);
    }

    @PreDestroy
    private void tearDown() {
        System.out.println("Closing => " + this.getClass().getSimpleName());
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public abstract boolean isAt();
}
