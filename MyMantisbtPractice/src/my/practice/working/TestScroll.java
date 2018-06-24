package my.practice.working;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScroll {
static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//input[@title = 'Search']"));
		element.sendKeys("Testing");
		element.sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

	}

}
