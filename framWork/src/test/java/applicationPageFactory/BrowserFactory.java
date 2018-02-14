package applicationPageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	
	public static WebDriver startApplication(String browser,String url) 
	{
		WebDriver driver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		if (browser.equalsIgnoreCase("Chrome")) 
		{
			
			System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");
			driver=new ChromeDriver(cap);
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Browser/geckodriver.exe");
			driver=new FirefoxDriver(cap);
		} 
		else if(browser.equalsIgnoreCase("IE"))
		{
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			System.setProperty("webdriver.ie.driver", "./Browser/IEDriverServer.exe");
			driver=new InternetExplorerDriver(cap);
		}
		else
		{
			System.err.println("ERROR: Sorry this test only support Chrome, Firefox and IE");
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
}
