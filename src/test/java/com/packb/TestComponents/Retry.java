package com.packb.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int Count=0;
    int maxTry=1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(Count<maxTry){
            Count++;
            return true;
        }
        return false;

    }
}
