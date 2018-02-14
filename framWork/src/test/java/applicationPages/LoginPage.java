package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper.Utility;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(how = How.ID, using = "txtUsername")WebElement userName;
	@FindBy(how = How.ID, using = "txtPassword")WebElement password;
	@FindBy(how = How.ID, using = "btnLogin")WebElement loginButton;
	
	public void enterUserName(String username) 
	{
		Utility.waitForWebElement(driver, userName, 1).sendKeys(username);
	}
	public void enterPassword(String pass) 
	{
		Utility.waitForWebElement(driver, password, 1).sendKeys(pass);
	}
	public void clickOnLoginButton() 
	{
		Utility.waitForWebElement(driver, loginButton, 2).click();
	}
	public void loginToApplication(String username,String pass) 
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
	}
}
