package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserhelper {
	
	   static WebDriver driver = null;
	public static WebDriver InvokeBrowser(String sBrowserType, String url ) {
		  

		switch (sBrowserType.toLowerCase()) {
		case "chrome":

			// Set path for Chrome Driver executable
			System.setProperty("webdriver.chrome.driver", "D:/Selenium/lib/chromedriver.exe");

			driver = new ChromeDriver();

			break;

		case "ie":

			// Set path for IE Driver executable
			System.setProperty("webdriver.ie.driver", "D:/Selenium/lib/IEDriverServer.exe");

			// Launch InternetDriverServer
			driver = new InternetExplorerDriver();

			break;

		case "firefox":

			// Set path for firefox Driver executable
			System.setProperty("webdriver.gecko.driver", "D:/Selenium/lib/geckodriver.exe");

			driver = new FirefoxDriver();

		}
		
		driver.manage().window().maximize();
		driver.get(url);
	

	return driver;
	}
	
}
