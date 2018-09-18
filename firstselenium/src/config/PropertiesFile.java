package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import SeleniumAutomation.Automation;

public class PropertiesFile {

	static Properties prop = new Properties();
	
	
	public static void main(String args[]) {
		readPropertiesFile();
		//writePropertiesFile();
		//readPropertiesFile();

	}
	//To read content from properties file
	public static void readPropertiesFile() {

		
		try {
			InputStream input = new FileInputStream("C:\\Users\\dnagesha\\eclipse-workspace\\firstselenium\\src\\config\\config.properties");
			prop.load(input);
			Automation.browser = prop.getProperty("browser");
			System.out.println(Automation.browser);
			
		}

		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
		//To write content into the properties file(it add result=pass in properties file)
		public static void writePropertiesFile() {
			
			try {
				OutputStream output = new FileOutputStream("C:\\Users\\dnagesha\\eclipse-workspace\\firstselenium\\src\\config\\config.properties");
				//prop.setProperty("browser", "firefox");
				prop.setProperty("Result", "Pass");
				prop.store(output, "helo");
				
			} 
			
			
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}

	
}
