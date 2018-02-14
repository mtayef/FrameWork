package applicationPages;

import java.util.List;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper.Utility;

public class UserPage {

	WebDriver driver;
	public UserPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(how = How.XPATH, using = "//b[text()='Admin']")WebElement admin;
	@FindBy(how = How.XPATH, using = "//a[text()='User Management']")WebElement userManagment;
	@FindBy(how = How.ID, using = "menu_admin_viewSystemUsers")WebElement user;
	@FindBy(how = How.ID, using = "btnAdd")WebElement addButton;
	@FindBy(how = How.XPATH, using = "//*[@id='systemUser_userName']")WebElement username;
	@FindBy(how = How.ID, using = "systemUser_employeeName_empName")WebElement employee;
	
	public void addUser(String name) 
	{
		Actions act = new Actions(driver);
		act.moveToElement(Utility.waitForWebElement(driver, admin, 20)).perform();
		act.moveToElement(Utility.waitForWebElement(driver, userManagment, 20)).perform();
		act.moveToElement(Utility.waitForWebElement(driver, user, 20)).click().build().perform();
		Utility.waitForWebElement(driver, addButton, 20).click();
		Utility.waitForWebElement(driver, username, 20).sendKeys(name);
		Utility.waitForWebElement(driver, employee, 20).sendKeys("a");
		
		 List<WebElement> list=driver.findElements(By.xpath("//div[@class='ac_results']//li"));	
		 
		 for (WebElement element : list) {
			String text = element.getAttribute("innerHTML");
			if(text.contains("Robert")) 
			{
				element.click();
				break;
			}
			
		 } 
}
	
	
}
