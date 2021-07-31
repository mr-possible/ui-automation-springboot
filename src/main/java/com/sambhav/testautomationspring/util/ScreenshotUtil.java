package com.sambhav.testautomationspring.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenshotUtil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path screenshotPath;

    public void takeScreenshot() throws IOException {
        Long timestamp = System.currentTimeMillis();
        File screenshot = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(screenshot, this.screenshotPath.resolve("snap_" + timestamp + ".png").toFile());
    }
}
