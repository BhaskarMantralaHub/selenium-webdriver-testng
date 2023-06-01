package com.bhaskarmantralahub.pageobjects;

import com.bhaskarmantralahub.config.LoadWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    public BasePage() {
        this.driver = LoadWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
}
