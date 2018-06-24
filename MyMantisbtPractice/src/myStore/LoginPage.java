package myStore;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginPage {

	static WebDriver driver;
	static String appURL = "http://192.168.161.43:8080/application";
	static String appURL1 = "http://www.google.com";
	static By MyAccount = By.xpath("//div[@id = 'top-links']/descendant::a[@title = 'My Account']");
	static By Register = By.xpath("//div[@id = 'top-links']/descendant::a[contains(text(),'Register')]");
	static By Login = By.xpath("//div[@id = 'top-links']/descendant::a[contains(text(),'Login')]");
	
	static By usersFirstName = By.xpath("//input[@id='input-firstname']");
	static By usersLastName = By.xpath("//input[@id='input-lastname']");
	static By usersEmail = By.xpath("//input[@id='input-email']");
	static By usersTelephone = By.xpath("//input[@id='input-telephone']");
	static By usersPassword = By.xpath("//input[@id='input-password']");
	static By usersConfirm = By.xpath("//input[@id='input-confirm']");
	static By agreeCheckbox = By.xpath("//input[@name='agree']");
	static By continueButton = By.xpath("//input[@value='Continue']");	
	static By accountConfirmation = By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]");
	static By confirmationContinueButton = By.xpath("//a[contains(text(), 'Continue')]");
	static By confirmationLogout = By.xpath("//div[@id = 'top-links']/descendant::a[contains(text(),'Logout')]");
	
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL1);
		int num = 1;
		driver.findElement(By.xpath("//input[@title = 'Search']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@value = 'Google Search']")).click();
		List<WebElement> findLinksfromPage = findLinksfromPage();
		
		for (WebElement webElement : findLinksfromPage) {
			
			if (!webElement.getText().isEmpty()) {
				
				System.out.println(num + ">> " + webElement.getText());
			
				num++;
			}
		}
		
		
		
//		clickOn(MyAccount);
//		clickOn(Register);
//		enterText(usersFirstName, "User1");
//		enterText(usersLastName, "User11");
//		enterText(usersEmail, "test33@test.com");
//		enterText(usersTelephone, "12345");
//		enterText(usersPassword, "Password@123");
//		enterText(usersConfirm, "Password@123");
//		clickOn(agreeCheckbox);
//		clickOn(continueButton);
//		Boolean ele = visibleEle(accountConfirmation);
//		
//		if (ele) {
//			System.out.println("User is created successfully");
//		} else {
//			System.out.println("User creation un-successfully");
//		}
//		
//		clickOn(MyAccount);
//		Boolean ele1 = visibleEle(confirmationLogout);
//		
//		if (ele1) {
//			System.out.println("मोबाईलमध्ये रेकॉर्ड झाला 'मृत्यू', असा 'वेडेपणा' कुणीही करु नका");
//		} else {
//			System.out.println("मोबाईलमध्ये रेकॉर्ड झाला 'मृत्यू'");
//		}
//		
//		clickOn(MyAccount);
		
		
	}
	public static void clickOn(By element) {
	driver.findElement(element).click();
}
	
public static List<WebElement> findLinksfromPage() {

	List<WebElement> links = null;
	
	
		try {
			links = driver.findElements(By.xpath("//div[@id = 'rcnt']/descendant::h3[@class = 'r']"));
			
			
		} catch (Exception e) {
			System.out.println("No links found with the tang name");
		}
		return links;
		
}
	public static void enterText(By element, String text) {
	driver.findElement(element).sendKeys(text);
}
	public static Boolean verifyEle(By element, String value) {
	
		Boolean flg = false;
	
	WebElement webElement = driver.findElement(element);
		
	if (webElement.getText().contains(value)) {
		
		flg = true;
	}
	
	return  flg;	
}
	public static Boolean visibleEle(By element) {
		
		Boolean flg = false;
			
			WebElement webElement = driver.findElement(element);
				
			if (webElement.isDisplayed()) {
				
				flg = true;
			}
			
			return  flg;
		
	}
}
