package com.bhaskarmantralahub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageB extends PageA {

    @FindBy(css = "a.home-campaign-enterprise")
    public WebElement element;

    public PageB() {
        super();
    }


}
