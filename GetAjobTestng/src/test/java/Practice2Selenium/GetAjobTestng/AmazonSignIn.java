package Practice2Selenium.GetAjobTestng;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import PageObjectModel.CreateAccount;
import PageObjectModel.Home;
import PageObjectModel.SignIn;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSignIn {
	public WebDriver driver;
 @Test (priority = 2, dependsOnMethods ="VerificationOfText" )
  public void f() throws InterruptedException {
	  Home obj1=new Home(driver);
	  obj1.SignToClick();
	  Thread.sleep(3000);
	  SignIn obj2=new SignIn(driver);
	  obj2.EmailEnter();
	  obj2.ContinueClick();
	 obj2.CreateAccountClick();
	  CreateAccount obj3=new CreateAccount(driver);
	  obj3.FullName();
	  obj3.PhoneOrEmail();
	  obj3.Password1();
	  obj3.ReenterPassword();
	  Thread.sleep(3000);
	  obj3.continueButton();
  }	  
@Test (priority = 1)
public void VerificationOfText() throws InterruptedException {
	Home obj1=new Home(driver);
	  obj1.SignToClick();
	  Thread.sleep(3000);
	  SignIn obj2=new SignIn(driver);
	  obj2.EmailEnter();
	  obj2.ContinueClick();	
	 String errorIt= obj2.text();
	 System.out.println(errorIt);
	 SoftAssert soft=new SoftAssert();
	 soft.assertEquals(errorIt, "We cannot find an account with that email address");
	 soft.assertAll();
	 //Thread.sleep(3000);
	 //driver.quit();
	 //Assert.assertEquals(errorIt, "We cannot find an account with that email address");
	
	
}
	  
 
@BeforeMethod
  public void beforeMethod() {
	
	browsers("edge", "https://www.amazon.com");	
		
  }

 @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(6000);
	  driver.quit();
  }
public void browsers(String browser, String Website) {
if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.navigate().to(Website);
	driver.manage().window().maximize();
	
}else if (browser.equalsIgnoreCase("edge")) {
	System.setProperty("webdriver.edge.driver","C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\Drivers\\msedgedriver.exe" );
	driver=new EdgeDriver();
	driver.navigate().to(Website);
	driver.manage().window().maximize();
	
}
/*else if (browser.equalsIgnoreCase("opera")) {
	System.setProperty("webdriver.opera.driver", "C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\Drivers\\operadriver.exe");
	driver=new OperaDriver();
}	else if (browser.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\Drivers\\geckodriver.exe");
	driver=new FirefoxDriver();
}*/else {System.out.println("the driver Name is not correct");}
}
}



