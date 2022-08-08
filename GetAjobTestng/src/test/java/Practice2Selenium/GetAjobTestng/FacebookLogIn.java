package Practice2Selenium.GetAjobTestng;

import org.testng.annotations.Test;

import Commin.Utility;
import PageObjectModel.HomeFacebook;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class FacebookLogIn extends Utility {
  @Test(dataProvider = "Provided")
  public void f(String n, String s) throws InterruptedException, IOException {
	HomeFacebook obj1=new HomeFacebook(driver);  
	obj1.EmailEnter(n);
	Thread.sleep(2000);
	obj1.PasswordEnter(s);
	Thread.sleep(2000);
	obj1.LogInClick();
	Thread.sleep(2000);
	shots();
  }

  @DataProvider
  public Object[][] Provided() {
    return new Object[][] {
      new Object[] { "ljhadvljknd@", "dvsdgsd654" },
      new Object[] { "kjdgvkjd@", "bsvbsv565196" },
      new Object[] {"53425vd544dsv@","5dv35yrg3534sv"}
    };
  }
}
