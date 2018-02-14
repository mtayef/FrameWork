package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage
{
	WebDriver driver;
	@FindBy(how = How.ID, using = "txtUsername")WebElement userName;
	@FindBy(how = How.ID, using = "txtPassword")WebElement password;
	@FindBy(how = How.ID, using = "btnLogin")WebElement loginButton;
	
	public void enterUserName(String username) 
	{
		userName.sendKeys(username);
	}
	public void enterPassword(String pass) 
	{
		password.sendKeys(pass);
	}
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	public void loginToApplication(String username,String pass) 
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
	}
}
