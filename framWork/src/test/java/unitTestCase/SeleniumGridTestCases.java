package unitTestCase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


@Test
public class SeleniumGridTestCases 
{
	public void testBrowser() throws InterruptedException, MalformedURLException 
	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL url = new URL("http://10.0.0.246:4444/grid/register/");
		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("https://www.google.com/");
		System.out.println("Title before "+driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		Thread.sleep(3000);
		driver.quit();
	}
	
}