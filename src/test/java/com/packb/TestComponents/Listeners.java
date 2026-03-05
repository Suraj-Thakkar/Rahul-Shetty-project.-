package com.packb.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.packc.ExtentReportNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listeners extends BaseTest implements ITestListener {
    ExtentTest Tests;
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal();
   ExtentReports Reportss=ExtentReportNG.getReportObject();
    @Override
    public void onTestStart(ITestResult result) {
        Tests=Reportss.createTest(result.getMethod().getMethodName());
        extentTest.set(Tests);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Tests.log(Status.PASS,"Test Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String filePath=null;
        extentTest.get().fail(result.getThrowable());
        try {
                 driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            filePath=getScreenshot(result.getMethod().getMethodName(),driver);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context){
        Reportss.flush();
    }
}
