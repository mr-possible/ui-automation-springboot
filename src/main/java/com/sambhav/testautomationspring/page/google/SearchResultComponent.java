package com.sambhav.testautomationspring.page.google;

import com.sambhav.testautomationspring.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResultComponent extends Base {

    @FindBy(xpath = "//div[@class='MUFPAc']/div")
    private List<WebElement> searchResultPageCategories;

    public void getCategoryName() {
        this.searchResultPageCategories
                .stream()
                .filter(e -> e.isEnabled() && e.isDisplayed())
                .forEach((e) -> System.out.println(e.getText()));
    }

    @Override
    public boolean isAt() {
        return this.webDriverWaitConfig.getWebDriverWait(this.driver).until((d) -> !this.searchResultPageCategories.isEmpty());
    }
}
