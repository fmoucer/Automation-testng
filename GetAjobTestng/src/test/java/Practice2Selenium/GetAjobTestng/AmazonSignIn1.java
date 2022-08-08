package Practice2Selenium.GetAjobTestng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Commin.Utility;
import PageObjectModel.CreateAccount;
import PageObjectModel.Home;
import PageObjectModel.SignIn;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;

public class AmazonSignIn1 extends Utility {
	
  @Test (priority = 1 )
  public void f() throws InterruptedException {
	  driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
  @Test (priority = 2)
  public void TextVerification() throws InterruptedException, IOException {
	  Home obj1=new Home(driver);
	  obj1.SignToClick();
	  shots();
	  Thread.sleep(3000);
	  SignIn obj2=new SignIn(driver);
	  obj2.EmailEnter();
	  shots();
	  obj2.ContinueClick();  
	  String errorIt= obj2.text();
		 System.out.println(errorIt);
		 SoftAssert soft=new SoftAssert();
		 soft.assertEquals(errorIt, "We cannot find an account with that email address");
		 soft.assertAll();
  }
  


}

