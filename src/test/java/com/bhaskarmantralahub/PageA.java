package com.bhaskarmantralahub;

import com.bhaskarmantralahub.config.LoadWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PageA {

    @FindBy(css = "button.home-campaign-signup-button")
    protected WebElement element;
    protected WebDriver driver;

    public PageA() {
        driver = LoadWebDriver.getDriver();
        PageFactory.initElements(driver, this);

        driver.get("https://github.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void clickOn() {
        this.element.click();
    }
}
