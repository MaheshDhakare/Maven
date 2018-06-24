package test.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_PageModelApproch_LoginPage {
	
	WebDriver driver;
	WebElement username;
	WebElement password;
	
	@FindBy(xpath = "//*[@value = 'Login']")
	WebElement SubmitButton;

	
	public B_PageModelApproch_LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Login() {
		
		String URL = "http://localhost:8080/mantisbt/login_page.php";
		driver.get(URL);
		username.sendKeys("administrator");
		password.sendKeys("root");
		SubmitButton.click();
	}

}
