package Simpo_V2.Simpo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends base implements ITestListener {
    ExtentReports extent = ExtendReportNG.getReporterObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

    public void onTestFailure(ITestResult result) {
       extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;

        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            ////////////////////////////////////////
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());

            //System.out.println("Method name is " + result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestStart(ITestResult result) {
         test = extent.createTest(result.getMethod().getMethodName());
         extentTest.set(test);
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case Pass");
    }
}
