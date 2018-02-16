package unitTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class HeadlessBrowserTest 
{
	public void testBrowser() throws InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
		System.out.println("Title before "+driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		System.out.println("Title after "+driver.getTitle());
	}

}
