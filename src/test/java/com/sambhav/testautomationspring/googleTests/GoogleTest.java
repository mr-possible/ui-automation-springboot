package com.sambhav.testautomationspring.googleTests;

import com.sambhav.testautomationspring.SpringBaseTestNGTest;
import com.sambhav.testautomationspring.page.google.GooglePage;
import com.sambhav.testautomationspring.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy   // if someone wants it, then only it will be created. if you comment "this.screenshotUtil.takeScreenshot();", then
            // screenshotutil will not be autowired
    @Autowired
    private ScreenshotUtil screenshotUtil;

    @Test
    public void googleTest() throws InterruptedException, IOException {
        this.googlePage.goTo(); //launch the site
        Assert.assertTrue(this.googlePage.isAt());
        this.screenshotUtil.takeScreenshot();
        Thread.sleep(2000);
        this.googlePage.getSearchComponent().search("environment ");
        Thread.sleep(4000);
        this.screenshotUtil.takeScreenshot();
        this.googlePage.getSearchResultComponent().getCategoryName();
    }
}
