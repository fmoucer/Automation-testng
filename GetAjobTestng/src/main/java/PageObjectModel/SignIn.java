package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
public WebDriver driver;
	@FindBy(name = "email") WebElement Email;
	@FindBy(id= "continue") WebElement Continue;
	@FindBy(id = "createAccountSubmit") WebElement Create;
	@FindBy(xpath ="//*[contains(text(),'We cannot find an account ')]")WebElement Error;
	
	public SignIn (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		public void EmailEnter() {
			Email.sendKeys("frgfgfs@ghahsk.com");
			
		}
		public void ContinueClick() {
			Continue.click();
			
		}
		
		public void CreateAccountClick() {
			Create.click();
		}
		public String text() {
		String errorof=Error.getText();
		return errorof;
		
			
		}
	}


	
	
	
	

