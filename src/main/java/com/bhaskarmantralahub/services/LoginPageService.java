package com.bhaskarmantralahub.services;

import com.bhaskarmantralahub.pageobjects.LoginPage;

public class LoginPageService extends LoginPage {

    public void retrievePasswordByEmail(String email) {
        this.emailInput.sendKeys(email);
        this.retrievePasswordButton.click();
    }

}
