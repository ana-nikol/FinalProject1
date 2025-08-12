package org.example.utils;

public class Utils {
    public static void logInfo(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().info(message);
        }
        System.out.println(message);

    }

    public static void logFail(String message) {
        if (ExtentReportManager.getTest() != null)
            ExtentReportManager.getTest().fail(message);


    }
    //  System.out.println(message);

    public static void logPass(String message) {
        if (ExtentReportManager.getTest() != null)
            ExtentReportManager.getTest().pass(message);


    }
}
