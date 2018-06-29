package applicationTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import applicationPageFactory.DataProviderFactory;
import applicationPages.LoginPage;
import applicationPages.UserPage;
import helper.BaseClass;
//import helper.BaseClassCloud;

public class AddUser extends BaseClass
{
	
	@Test
	public void addUser() 
	{
		logger= report.startTest("This test is adding a user");
		
		LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		
		UserPage user = PageFactory.initElements(driver, UserPage.class);
		
		login.enterUserName(DataProviderFactory.getExcel().getStringData("Login", 0, 0));
		
		login.enterPassword(DataProviderFactory.getExcel().getStringData("Login", 0, 1));
		
		login.clickOnLoginButton();
		
		user.addUser("test");
		//logger.log(LogStatus.PASS, "User is able to login");
		
		//checking history		
	}
}
