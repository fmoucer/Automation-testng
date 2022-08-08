package Commin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;

public class Utility {
	public WebDriver driver;
@Parameters({"browser","WebSite"})
  @BeforeMethod

	  public void beforeMethod(String browser, String WebSite) {
	  String localPath=System.getProperty("user.dir");
		System.out.println(localPath);
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", localPath+"\\src\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.navigate().to(WebSite);
			driver.manage().window().maximize();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\Drivers\\msedgedriver.exe");
			driver= new EdgeDriver();
			driver.navigate().to(WebSite);
			driver.manage().window().maximize();
		}else {
			System.setProperty("webdriver.opera.driver", "C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\Drivers\\operadriver.exe");
			driver= new OperaDriver();
			driver.navigate().to(WebSite);
			driver.manage().window().maximize();
		}
			  
		  }
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }
 
  public void shots() throws IOException {
		Date dt=new Date();
		String dates=dt.toString().replace(" ", "-").replace(":", "-");
		String localP=System.getProperty("user.dir");
		File stored=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(stored, new File(localP +"\\src\\Screenshots\\"+dates+"Screenshots.jpg"));
	
	}	
  }
