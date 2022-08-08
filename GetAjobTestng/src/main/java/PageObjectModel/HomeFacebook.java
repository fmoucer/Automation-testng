package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFacebook {
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='email']")WebElement email;
	@FindBy(xpath = "//*[@id='pass']")WebElement Password;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")WebElement LogIn;
	 public HomeFacebook (WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	public void EmailEnter(String emails) {
		 email.sendKeys(emails);
		 
	 }
	 public void PasswordEnter(String Passwords) {
		 Password.sendKeys(Passwords);
	 }
	 public void LogInClick() {
		 LogIn.click();
	 }

}
