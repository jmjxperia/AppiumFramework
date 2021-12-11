package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    static ExtentReports extent;
    public static void createInstance()
    {
        String path=System.getProperty("user.dir")+"\\reports\\report.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Jathin");
    }

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
}
