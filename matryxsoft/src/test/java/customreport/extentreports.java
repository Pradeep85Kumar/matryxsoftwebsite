package customreport;

import java.io.IOException;

import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentreports {
	@Test

	public void loginTest() throws IOException {

		// start reporters

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./CustomReports/customreport1.html");

		// create ExtentReports and attach reporter(s)

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest logger = extent.createTest("MyFirstTest", "Sample description");

		// log(Status, details)
		logger.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		logger.info("This step shows usage of info(details)");

		
		// test with snapshot
		// test.addScreenCaptureFromPath("screenshot.png");

		// calling flush writes everything to the log file
		extent.flush();
		
		// creates a toggle for the given test, adds all log events under it
		ExtentTest logger2 = extent.createTest("MySecondTest", "Sample description");

		// log(Status, details)
		logger2.log(Status.FAIL, "This step shows usage of log(status, details)");

		// info(details)
		logger2.info("This step shows usage of info(details)");
		
		// log with snapshot
		 logger2.fail("Failed because of some issues",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\USER\\Desktop\\screenshot.png").build());
		
		 logger2.pass("Passed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\USER\\Desktop\\screenshot.png").build());
		extent.flush();
		
		System.out.println("Test report");
	}

}