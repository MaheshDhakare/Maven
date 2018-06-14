package guru99Bank_Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class Login_Page {
  
WebDriver driver;


String BaseURL = "http://www.demo.guru99.com/V4/";

By validateTitle = By.xpath("//h2[contains(text(), 'Guru99 Bank')]");
By UserName = By.xpath("//input[@name = 'uid']");
By Password = By.xpath("//input[@name = 'password']");
By loginButton = By.xpath("//input[@name = 'btnLogin']");

	
@Test
 public void TestLogin() {
	  
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
	  
	  driver = new FirefoxDriver();
	  
	  driver.get(BaseURL);	  
  
	  CommanMethods obj = new CommanMethods(driver);
	  
	if (obj.findElement(validateTitle).isDisplayed()) {
		
		if (obj.findElement(UserName).isDisplayed()) {
			obj.findElement(UserName).sendKeys("mngr133685");
			System.out.println(">> UserName entered correctly");
			
			if (obj.findElement(Password).isDisplayed()) {
				obj.findElement(Password).sendKeys("syjAnyv");
				System.out.println(">> Password entered correctly");
				
				if (obj.findElement(loginButton).isDisplayed()) {
					obj.findElement(loginButton).click();;
					System.out.println("Successfully cliked on login button");

				} else {
					System.out.println("Unable to find login button");
				}
				
			} else {
				System.out.println("Unable to find Password webelement");
			}			
			
		} else {
			System.out.println("Unable to find UserName webelement");
		}
		
	} else {
		System.err.println("Unable to open correct URL");
	}
	  
  }
}
