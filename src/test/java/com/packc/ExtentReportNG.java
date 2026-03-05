package com.packc;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    public static ExtentReports getReportObject(){
        String Path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index.html";
        ExtentSparkReporter Reporting=new ExtentSparkReporter(Path);
        Reporting.config().setReportName("Web Automation Results");
        Reporting.config().setDocumentTitle("Test Results");
        ExtentReports Reportss=new ExtentReports();
        Reportss.attachReporter(Reporting);
        Reportss.setSystemInfo("Tester","Suraj");
        return Reportss;
    }
}
