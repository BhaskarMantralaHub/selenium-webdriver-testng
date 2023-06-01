package com.bhaskarmantralahub.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#email")
    protected WebElement emailInput;

    @FindBy(css = "#form_submit")
    protected WebElement retrievePasswordButton;
}
