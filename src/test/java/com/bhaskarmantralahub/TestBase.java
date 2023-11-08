package com.bhaskarmantralahub;

import com.bhaskarmantralahub.config.LoadWebDriver;
import com.bhaskarmantralahub.config.LogAppender;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected WebDriver driver;

    @BeforeSuite
    protected void launchBrowser() {
//        System.out.println("Inside Launch browser");
        driver = LoadWebDriver.getDriver();
//        driver.get("https://the-internet.herokuapp.com/forgot_password");
    }

    @BeforeTest
    protected void logs() {
//        LogAppender.saveSystemLogsToFile();
    }

    @AfterSuite
    protected void quitBrowser()
    {
        System.out.println("Inside Quit browser");
        LogAppender.closeStream();
        driver.quit();
    }
}
