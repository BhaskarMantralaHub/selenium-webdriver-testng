package com.bhaskarmantralahub.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadWebDriver {

    private static WebDriver driver;

    private LoadWebDriver() {
        //private constructor to avoid class object instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-popup-blocking");

            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            options.addArguments("--window-size=1920,1080");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--disable-crash-reporter");
            options.addArguments("--disable-extensions");
//            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--disable-logging");
//            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--log-level=3");

            Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
            return driver;
        }
        return driver;
    }

}
