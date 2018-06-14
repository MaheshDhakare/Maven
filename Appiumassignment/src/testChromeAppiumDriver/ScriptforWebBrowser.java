package testChromeAppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Position;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScriptforWebBrowser {

	@SuppressWarnings("rawtypes")
	
	static AppiumDriver driver;
//	By searchBox = By.xpath("//input[@type = 'search']");
	By allLinks = By.xpath("//div[@role = 'heading']");
	
//===============================================================================================================================	
	@SuppressWarnings("rawtypes")
	public void openChromebrowser() {
		
		DesiredCapabilities Capabilites = new DesiredCapabilities();
		
		Capabilites.setCapability("device", "Android");
		Capabilites.setCapability("deviceName", "emulator-5554");
		Capabilites.setCapability("automationName", "UiAutomator2");
		Capabilites.setCapability("platformName", "Android");
		Capabilites.setCapability("browserName", "Chrome");
		Capabilites.setCapability("platformName", "Android");
			
		try {
			driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), Capabilites);
			
		} catch (MalformedURLException e) {

			System.out.println("Unable to set appium driver");
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//===============================================================================================================================	
	public void navigateTourl(String Url) {

		driver.get(Url);
		
	}

//===============================================================================================================================	
	public void searchText(String searchWord) {

		driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys(searchWord);
		driver.findElement(By.xpath("//button[@aria-label='Google Search']")).click();
		

	}
//===============================================================================================================================
	public void clickOnsearch() {

		driver.findElement(By.xpath("//button[@aria-label='Google Search']")).click();
	
	}
//===============================================================================================================================	
	@SuppressWarnings("unchecked")
	public List<WebElement> findLinksfromPage() {

	List<WebElement> links = null;
	
	
		try {
			links = driver.findElements(allLinks);
			
			
		} catch (Exception e) {
			
			System.out.println("No links found with the tang name given");
		}
		return links;
		
	}
//===============================================================================================================================
	public void quitBrowser() {
		driver.quit();
		
	}
}
