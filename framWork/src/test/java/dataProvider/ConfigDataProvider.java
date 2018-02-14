package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() 
	{
		try {
			pro = new Properties();
			pro.load(new FileInputStream(new File(System.getProperty
					("user.dir")+"/Configuration/config.properties")));
		} catch (Exception e) 
		{
			System.err.println("ERROR: Unable to upload the file "+e.getMessage());
		}
	}
	
	public String getTestURL() 
	{
		String data = pro.getProperty("testURL");
		return data;
	}
	public String getUATURL() 
	{
		String data = pro.getProperty("UATurl");
		return data;
	}
	public String getProdURL() 
	{
		String data = pro.getProperty("ProdURL");
		return data;
	}
	public String getValue(String key) 
	{
		String data = pro.getProperty(key);
		return data;
	}
}
