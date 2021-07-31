package com.sambhav.testautomationspring.page.google;

import com.sambhav.testautomationspring.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResultComponent searchResultComponent;

    @Value("${application.url}")
    private String appURL;

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResultComponent getSearchResultComponent() {
        return searchResultComponent;
    }

    public void goTo() {
        this.driver.get(appURL);
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
