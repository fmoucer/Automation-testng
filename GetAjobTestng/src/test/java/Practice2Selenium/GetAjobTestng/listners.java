package Practice2Selenium.GetAjobTestng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Commin.Utility;

public class listners extends Utility implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// we have to add the code bellow 
		this.driver=((Utility)result.getInstance()).driver;
		Date dt=new Date();
		String dates=dt.toString().replace(" ", "-").replace(":", "-");
		String localP=System.getProperty("user.dir");
		File stored=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(stored, new File(localP +"\\src\\Screenshots\\Pass\\"+dates+"Screenshots.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// we have to add the code bellow 
				this.driver=((Utility)result.getInstance()).driver;
		Date dt=new Date();
		String dates=dt.toString().replace(" ", "-").replace(":", "-");
		String localP=System.getProperty("user.dir");
		File stored=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(stored, new File(localP +"\\src\\Screenshots\\Fail\\"+dates+"Screenshots.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	

	
}
