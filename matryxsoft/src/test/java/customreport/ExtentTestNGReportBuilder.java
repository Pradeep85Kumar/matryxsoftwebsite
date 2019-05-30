package customreport;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentTestNGReportBuilder {

	private static ExtentReports extent;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal logger = new ThreadLocal();

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}
	
    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
         ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
            logger.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
           ((ExtentTest) logger.get()).fail(result.getThrowable());
      else if (result.getStatus() == ITestResult.SKIP)
       ((ExtentTest) logger.get()).skip(result.getThrowable());
            else
      ((ExtentTest) logger.get()).pass("Test passed");

        extent.flush();
    }
}