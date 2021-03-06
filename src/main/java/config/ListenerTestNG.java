package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.util.List;

public class ListenerTestNG implements ITestListener {
    Logger logger = LoggerFactory.getLogger(ListenerTestNG.class);


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("LTNG : Start test getStatus--->" +result.getStatus());
        logger.info("LTNG : Start test getTestName--->" +result.getTestName());
        logger.info("LTNG : Start test getTestClass--->" +result.getTestClass());
        logger.info("LTNG : Start test getName--->" +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("LTNG : Start test getTestName--->" +result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("LTNG : Start test getTestName--->" +result.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("LTNG : Start test getTestName--->" +result.getTestName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("LTNG : Error -->" +result.getThrowable().getMessage());
        logger.info("LTNG : Error -->" +result.getThrowable().getStackTrace().toString());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("LTNG : on Start --->" +context.getOutputDirectory());
        logger.info("LTNG : on Start --->" +context.getName());


    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }


}
