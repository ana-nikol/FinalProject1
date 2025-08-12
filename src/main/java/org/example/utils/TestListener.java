package org.example.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportManager.createTest(testName);
        Utils.logInfo("Test started" + testName);
        //  ExtentTest test = ExtentReportManager.createTest(testName);
        //     test.info("Test Started"); es shevadaro leqcias tu ar damchirdeba cavshli
        //  System.out.println("Test Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Utils.logPass("Test Passed");
        //  ExtentReportManager.getTest().pass("Test Passed");
        // System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Utils.logFail("error:"+ result.getThrowable());
        //  ExtentReportManager.getTest().fail("Test Failed: " + result.getThrowable());

        //  System.out.println("Test Failed: " + result.getName());
        //    Utils.takeScreenshot(result.getName()); // Screenshot logic
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //   ExtentReportManager.getTest().skip("Test Skipped: " + result.getThrowable());
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        ExtentReportManager.flushReports();
    }
}
