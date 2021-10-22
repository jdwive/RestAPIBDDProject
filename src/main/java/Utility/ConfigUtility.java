package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
	public Properties prop;
	public FileInputStream fis;
	public ConfigUtility() {
		try {
			prop = new Properties();
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\DataFiles\\config.properties");
			//fis = new FileInputStream("E:\\Workspace\\RestAPILearningProject\\src\\test\\resources\\config.properties");
			prop.load(fis);
			}
			catch(IOException e) {
				System.out.println(e);
			}
	}
	public String readData(String key) {
		String value= prop.getProperty(key);
		System.out.println(value);
		return value;
		
	}
	
	

}
