package applicationTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import applicationPageFactory.DataProviderFactory;
import applicationPages.LoginPage;
import helper.BaseClass;

public class ApplicationLogin2 extends BaseClass
{
	
	@Test
	public void loginToApp() 
	{
		logger= report.startTest("Logging in to the Application");
		LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		login.enterUserName(DataProviderFactory.getExcel().getStringData("Login", 0, 0));
		login.enterPassword(DataProviderFactory.getExcel().getStringData("Login", 0, 1));
		login.clickOnLoginButton();
		//logger.log(LogStatus.PASS, "User is able to login");
	}
}
