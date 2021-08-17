package org.joguzmandev.demo.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("OnTestStart " + result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("OnTestFailure " + result.getMethod());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout " + result.getName());
    }
}
