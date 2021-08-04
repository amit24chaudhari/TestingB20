package World;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Hello {
public WebDriver driver;
	
	Properties pro=new Properties();
	
	static Logger Log=Logger.getLogger(Hello.class.getName());
	
	@BeforeSuite
	public void openBrowser() throws IOException
	{
		FileInputStream fis=new FileInputStream("H:\\cjc134\\core java\\GitPropertiesTesting\\src\\parameters.properties");
		pro.load(fis);
		
		System.out.println("open Browser");
		
		System.out.println("URL=="+pro.getProperty("url"));
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amit\\Desktop\\cjc134batch\\chrome\\chromedriver.exe");
		   driver=new ChromeDriver();
		   
		   System.out.println("open browser Success fully");
		
		
	}
	@BeforeTest
	public void enterUrl()
	{
		System.out.println("Enter Url");
		
		driver.get(pro.getProperty("url"));
	}
	
	@Test
	public void loginTest()
	{
		//System.out.println("Login data");
		
		
		driver.findElement(By.name("Gender")).click();
		
		
        driver.findElement(By.name("FirstName")).sendKeys(pro.getProperty("firstname"));
		
		driver.findElement(By.name("LastName")).sendKeys(pro.getProperty("lastname"));
		
        driver.findElement(By.name("Email")).sendKeys(pro.getProperty("email"));
		
       
		driver.findElement(By.name("Password")).sendKeys(pro.getProperty("password"));
		
		driver.findElement(By.name("ConfirmPassword")).sendKeys(pro.getProperty("confirmpassword"));
		
		driver.findElement(By.name("register-button")).click();
		
		Log.debug("DEBU");
		Log.info("INFO");
		Log.warn("WARN");
		Log.error("Error");
		Log.fatal("FATAL");
		
		System.out.println("Hello");
		
	}
	


}


