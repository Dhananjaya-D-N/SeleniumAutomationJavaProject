package SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.PropertiesFile;

public class Automation {
	
	public static String browser;
	static WebDriver driver;
	

	public static void main(String[] args) {

	//setbrowser();
	PropertiesFile.readPropertiesFile();
	setbrowserconfig();
	runtest();
	PropertiesFile.writePropertiesFile();
	
	} 
	
	
	public static void setbrowser() {
		browser = "chrome";
	}
	
	public static void setbrowserconfig() {
		//Setting a global variable for location so we can change the project location also it will work. 
		String projectloc = System.getProperty("user.dir");
		
		
		
		if(browser.contains("firefox")){
			//System.setProperty("webdriver.firefox.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox");
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\dnagesha\\eclipse-workspace\\firstselenium\\lib\\GeckoDriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", projectloc+"\\lib\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if(browser.contains("chrome")) {
			// System.setProperty("webdriver.driver","C:\\Program Files(x86)\\Google\\Chrome\\Application\\chrome.exe");
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\dnagesha\\eclipse-workspace\\firstselenium\\lib\\chromedriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",projectloc+"\\lib\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
	}
	
	public static void runtest() {
		driver.get("http://10.109.10.40/qa/prod_uat_qa_links/ALM_links.html");
		WebElement link1 = driver.findElement(By.linkText("PP 1000"));
		link1.click();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("ashyam@flexerasoftware.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Flexera1");
		WebElement submit = driver.findElement(By.xpath("//input[@value='Log in']"));
		submit.click();
		driver.quit();
	}
}
