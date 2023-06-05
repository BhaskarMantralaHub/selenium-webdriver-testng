package com.bhaskarmantralahub.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    Logger logger;
    public void onTestStart(ITestResult result) {
        logger = LoggerFactory.getLogger(result.getTestClass().getName());
        logger.info(result.getName() + " execution is started");
        logger.info(result.getMethod().getMethodName() + " execution is started");
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test {} is Passed", result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        logger.info("Test {} is Failed", result.getMethod().getMethodName());
        logger.error("Test failure log: \n {} \n", getFailedResponseAsString(result));

        if (result.getMethod().getRetryAnalyzer(result) == null) {
            result.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
        }
    }

    private String getFailedResponseAsString(ITestResult result) {
        Object response = result.getThrowable(); // Assuming the response is stored as the throwable object
        // You may need to adjust this line based on how the response is stored in the ITestResult object

        if (response != null) {
            // Convert the response object to a string representation
            String responseString = response.toString();

            // Additional formatting or extraction of specific details from the responseString if needed
            // You can modify this part to format the response in a more structured manner

            return responseString;
        }

        return "No response available";
    }


    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}