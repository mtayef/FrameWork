
package helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationPageFactory.BrowserFactory;
import applicationPageFactory.DataProviderFactory;

public class BaseClassCloud 
{
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpReport() 
	{
		report = new ExtentReports(System.getProperty
				("user.dir")+"/Reports/"+Utility.getCurrentDateTime()+".html");
	}
	
	@Parameters({"Browser","OSName","version"})
	@BeforeClass
	public void startSession(String browser,String os,String version) 
	{
		driver = BrowserFactory.startApplicationOnCloud
				(browser, DataProviderFactory.getConfig().getTestURL(), os, version);
	}
	@AfterClass
	public void terminateSession() 
	{
		driver.quit();
	}
	@AfterSuite
	public void tearDownReport() 
	{
		report.close();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		if (result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.log(LogStatus.PASS, "Test passed successfully");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Utility.captureScreenShot(driver)));
		}
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			logger.log(LogStatus.FAIL, "Test Failed");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Utility.captureScreenShot(driver)));
			logger.log(LogStatus.ERROR, result.getThrowable().getMessage());
		}
		report.endTest(logger);
	}
}
