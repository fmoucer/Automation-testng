package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@placeholder='First and last name']")WebElement Name;
	@FindBy(xpath = "//*[@id='ap_email']")WebElement Phone;
	@FindBy(xpath = "//*[@id='ap_password']")WebElement Password;
	@FindBy(xpath = "//*[@id='ap_password_check']")WebElement PasswordCheck;
	@FindBy(xpath = "//*[@id='continue']") WebElement Continue;
	
	
	public CreateAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public void FullName() {
	Name.sendKeys("jhgsdfyg");
}
public void PhoneOrEmail() {
	Phone.sendKeys("0210000000");
}
public void Password1() {
	Password.sendKeys("54afcadcef534");
}
public void ReenterPassword() {
	PasswordCheck.sendKeys("54afcadcef534");
}
public void continueButton() {
	Continue.click();
}
}
