package com.bhaskarmantralahub.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 3; // Maximum number of retries

    private int currentRetryCount = 0;

    Logger logger;

    @Override
    public boolean retry(ITestResult result) {
        logger = LoggerFactory.getLogger(result.getTestClass().getName());
        logger.info("TEST {} RE-RUN #{}", result.getMethod().getMethodName(), currentRetryCount);
        if (currentRetryCount < MAX_RETRY_COUNT) {
            currentRetryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry the test
    }
}

