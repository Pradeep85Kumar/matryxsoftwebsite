package Utility;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import Utility.WrapperActionFunction;



public class ApplicationUtility {
	
	//Report report=new Report();
	WrapperActionFunction test=new WrapperActionFunction();
	String ScreenshotName="";
	public WebDriver driver=null;
	public BufferedWriter writer=null;
	private final static Logger LOGGER = Logger.getLogger(ApplicationUtility.class.getName());

	
	public ApplicationUtility ()
	{
		logMessage("Step Execution Failed","Exception Occurred", "Exception Occurred", "failed");
	}
	
	public ApplicationUtility (BufferedWriter writer)
    {
           this.writer=writer;
          // this.appDto=appDto;
    }

	/********************************************************************************************
	 *  
	 * @Function_Name :  ApplicationUtility
	 * @Description : Initialization the Report LocalDriverFactory and AppTestDTO
	 * @version 1.0
	 ********************************************************************************************/
////	public ApplicationUtility(Report r,LocalDriverFactory localDriverFactory,AppTestDTO appDto)
//	{
//		try{
//			//this.appDto=appDto;
//			this.writer=r.createlogfile(appDto.getTestMethodName(),appDto.getDataId());
////			this.driver =localDriverFactory.getDriver(appDto.getBrowserType(),appDto.getGridUrl());
////			this.driver =localDriverFactory.getDriver(appDto.getBrowserType(),appDto.getGridUrl(),"34");
////			this.driver =localDriverFactory.getDriver(appDto.getBrowserType(),"http://bhive-beta.cisco.com/getsession");
//			//this.driver =localDriverFactory.getDriver(appDto.getBrowserType(),"http://sdaas-gridlab.cisco.com:8080/wd/hub");
//			//this.driver =localDriverFactory.getDriver(appDto.getBrowserType());
//			this.driver = test.launchIEDriver();
//			
//
//		}
//		catch(Exception e)
//		{	e.printStackTrace();
//			LOGGER.log(Level.SEVERE, "Exception found in Initialization of ApplicationUtility class :",e);
//			logMessage("Step Execution Failed","Exception Occurred", "Exception Occurred "+e.getMessage(), "failed");
//			
//		}
//	}
	/********************************************************************************************
	 *  
	 * @Function_Name :  logMessage
	 * @Description : This method is used write the steps into html report
	 * @version 1.0
	 ********************************************************************************************/
	
	public void logMessage(String strDescr,String strExpected,String Actual,String status)
	{
		try{
			//ScreenshotName=appDto.getTestClassName()+"_"+appDto.getTestMethodName()+"-"+appDto.getDataId();
			//report.logMessage(driver,writer,ScreenshotName,strDescr,strExpected,Actual, status);
		}
		catch(Exception e){
			LOGGER.log(Level.SEVERE, "Exception found in Initialization of ApplicationUtility class for report log message :",e);
		}
	}
	
}
