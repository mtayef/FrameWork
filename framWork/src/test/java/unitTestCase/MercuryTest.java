package unitTestCase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class MercuryTest {
	
	@Test
	public void mercuryGridTest() throws InterruptedException, MalformedURLException 
	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL url = new URL("http://10.0.0.246:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");		
		driver.findElement(By.name("login")).click();		
		Thread.sleep(3000);
		driver.quit();
	}
}
