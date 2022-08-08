package Practice2Selenium.GetAjobTestng;

import org.testng.annotations.Test;

import Commin.Utility;

import org.testng.annotations.DataProvider;

public class DataProviding extends Utility {
  @Test(dataProvider = "provided")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] provided() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
