package my.practice.working;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_sqspopup {
static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
		driver = new FirefoxDriver();
		driver.get("http://portal.office.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name = 'loginfmt']")).sendKeys("mahesh.dhakare@sqs.com");
		Thread.sleep(3000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(3000);
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name = 'passwd']")).sendKeys("Password1005");
		Thread.sleep(3000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("idBtn_Back")).click();
			
		
	}
}
