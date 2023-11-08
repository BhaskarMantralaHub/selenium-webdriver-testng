package com.bhaskarmantralahub;


import com.bhaskarmantralahub.config.LoadWebDriver;
import com.bhaskarmantralahub.services.LoginPageService;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

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
        PageB pageB = new PageB();
        pageB.clickOn();
        await("Page header is not correct")
                .pollInterval(3, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(() -> driver.getCurrentUrl().contains("Bhaskar"));
        System.out.println(driver.getCurrentUrl());
    }
}
