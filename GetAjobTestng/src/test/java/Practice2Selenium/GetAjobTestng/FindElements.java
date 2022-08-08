package Practice2Selenium.GetAjobTestng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Commin.Utility;
import PageObjectModel.HomeFacebook;

public class FindElements extends Utility{
  @Test
  public void f() {
	  
	  
 List<WebElement> it= driver.findElements(By.tagName("a"));
 System.out.println(it.size());
 
 for(WebElement text:it) {
	 System.out.println(text.getText());
 }
		 }
  // the test below is to get data from proproties file
  @Test
  public void ProppertiesOfMethod() throws InterruptedException, IOException {
	  String localPath=System.getProperty("user.dir");
	  Properties pro=new Properties();
		FileInputStream sd=new FileInputStream(localPath+"\\target\\Regression.Properties");
		pro.load(sd);
	pro.getProperty("Email");
		pro.getProperty("Password");
	  HomeFacebook obj1=new HomeFacebook(driver);  
		obj1.EmailEnter(pro.getProperty("Email"));
		Thread.sleep(2000);
		obj1.PasswordEnter(pro.getProperty("Password"));
		Thread.sleep(2000);
		obj1.LogInClick();
		Thread.sleep(2000);
		shots();
}
  
  

  //the  bellow is to get data from excel file
 /* @Test 
  
  public void ExcelSheetData() {
	XSSFWorkbook ExcelWBook;
	XSSFSheet ExcelWSheet;
	XSSFCell Cell;
	// location of excel file
	String path ="C:\\Users\\ferha\\eclipse-workspace\\GetAjobTestng\\src\\DataFiles\\Excelsheet.xlsx";
	String SheetName="Sheet1";
	try {
	FileInputStream ExcelFile=new FileInputStream(path);
	ExcelWBook=new XSSFWorkbook(ExcelFile);
	ExcelWSheet=ExcelWBook.getSheet(SheetName);
	Cell=ExcelWSheet.getRow(1).getCell(1);
	String CellData=Cell.getStringCellValue();
	System.out.println("Cell Data" +CellData);
	
	}catch (Exception e){
		e.printStackTrace();
	}
  }*/
 
  
}