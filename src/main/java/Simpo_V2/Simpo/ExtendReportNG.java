package Simpo_V2.Simpo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNG {
    static ExtentReports extent;

    public static  ExtentReports getReporterObject(){
        String path = System.getProperty("user.dir")+"\\Results\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Simpo Regression Test Report");
        reporter.config().setDocumentTitle("Simpo Regression Test Report");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Noman Sial");

        return extent;

    }

}
