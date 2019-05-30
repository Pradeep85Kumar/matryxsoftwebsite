package Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int iCount = 1;
	int iLimit = 2;

	public boolean retry(ITestResult result) {
		if (iCount < iLimit) {
			iCount++;
			return true;
		}
		return false;
	}

}

