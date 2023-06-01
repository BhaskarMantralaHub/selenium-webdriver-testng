package com.bhaskarmantralahub;


import com.bhaskarmantralahub.services.LoginPageService;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestBase
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Inside Test1");
        LoginPageService loginPageService = new LoginPageService();
        loginPageService.retrievePasswordByEmail("Hello@gmail.com");
    }
}
