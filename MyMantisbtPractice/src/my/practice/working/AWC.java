package my.practice.working;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AWC {
  
WebDriver driver;


String awcUrl = "http://swtc003:7003/awc/";



//By validateTitle = By.xpath("//h2[contains(text(), 'Guru99 Bank')]");
//By UserName = By.xpath("//input[@name = 'uid']");
//By Password = By.xpath("//input[@name = 'password']");
//By loginButton = By.xpath("//input[@name = 'btnLogin']");

//WebElement validateTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Guru99 Bank')]"));

//WebElement UserName = driver.findElement(By.xpath("//input[@name = 'uid']"));

//WebElement Password = driver.findElement(By.xpath("//input[@name = 'password']"));

//WebElement loginButton = driver.findElement(By.xpath("//input[@name = 'btnLogin']"));

	
@Test
 public void TestLogin() throws InterruptedException {
	  
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
	  Random ran = new Random();
	  int i = ran.nextInt(100);
	  System.out.println(i);
	  String test = "Testing" + i;
	  
	  driver = new FirefoxDriver();
	  
	  driver.get(awcUrl);	 
	  
	  driver.manage().window().maximize();
		  
	  driver.findElement(By.id("gwt-debug-textBox_userName")).sendKeys("user1");
	  System.out.println("userName================================================================");
	  System.out.println("\n");
	  driver.findElement(By.id("gwt-debug-textBox_password")).sendKeys("user1");
	  System.out.println("password================================================================");
	  System.out.println("\n");
	  driver.findElement(By.id("gwt-debug-button_login")).click();
	  System.out.println("login================================================================");
	  System.out.println("\n");
	  Thread.sleep(6000);
	  String title = driver.getTitle();
	  System.out.println(title);
	  driver.findElement(By.xpath("//div[@class = 'homefolder_light icon']")).click();
	  System.out.println("home================================================================");
	  System.out.println("\n");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[@title = 'Create']")).click();
	  System.out.println("create================================================================");
	  System.out.println("\n");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//div[contains(text(), 'Item')]")).click();
	  System.out.println("item================================================================");
	  System.out.println("\n");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[contains(text(), 'Name: ')]/ancestor::div[@class = 'propertyLabelTopContainer']/following-sibling::div[@class = 'aw-widgets-propertyLabelTopValueContainer']/textarea")).sendKeys(test);
	  System.out.println("name================================================================");
	  System.out.println("\n");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class = 'aw-layout-panelFooter']/descendant::button[contains(text(), 'Create')]")).click();
	  System.out.println("createButton================================================================");
	  System.out.println("\n");
	  
	  Thread.sleep(10000);
	  WebElement findElement = driver.findElement(By.xpath("//div[@id='gwt-debug-PrimaryWorkArea']/descendant::h3[@title = '"+test+"']"));
	  
	  System.out.println(findElement.getText());
	  
	  if (findElement.isDisplayed()) {
		  
		  System.out.println("Item with name " + test +" is created successfully");
		  System.out.println("================================================================");
		  
		
	} else {
		  System.out.println("Item creation unccessfuly");
		  System.out.println("================================================================");
	}
	  driver.quit();
  }
}
