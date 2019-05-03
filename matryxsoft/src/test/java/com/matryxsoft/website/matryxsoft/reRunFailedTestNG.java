package com.matryxsoft.website.matryxsoft;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class reRunFailedTestNG {

	@Test
	public void reRunFailedTests() {
		TestNG runner = new TestNG();
		List<String> lsFailedTests = new ArrayList<String>();
		lsFailedTests.add("C:\\Users\\USER\\git\\matryxsoftwebsite\\matryxsoft\\test-output\\testng-failed.xml");
		runner.setTestSuites(lsFailedTests);
		runner.run();

	}

}
