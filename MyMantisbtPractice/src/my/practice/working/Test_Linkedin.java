package my.practice.working;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Linkedin {
static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com");
		Thread.sleep(3000);
		driver.findElement(By.id("login-email")).sendKeys("maheshdhakare28@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("login-password")).sendKeys("Antolin@9987");
		Thread.sleep(3000);
		driver.findElement(By.id("login-submit")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Notifications")).click();
		Thread.sleep(3000);
		
		List<WebElement> ListOfsayCongrats = driver.findElements(By.xpath("//div[@data-control-name = 'cta_display']/descendant::button/span[1]"));
		
		int Cnt = ListOfsayCongrats.size();
		for (WebElement webElement : ListOfsayCongrats) {
			System.out.println(webElement.getText());
		}
		System.out.println(Cnt);
		for (int i = 0; i < 100; i++) {
			
			if (ListOfsayCongrats.get(i).getText().contains("Say congrats")) {
				
				Thread.sleep(3000);
				ListOfsayCongrats.get(i).click();
				Thread.sleep(3000);
				WebElement messageSendbutton = driver.findElement(By.xpath("//div[@class = 'ml4 msg-overlay-conversation-bubble msg-overlay-conversation-bubble--default-inactive msg-overlay-conversation-bubble--is-active msg-overlay-conversation-bubble--petite ember-view']/descendant::button[@class = 'msg-form__send-button button-tertiary-small']"));
				messageSendbutton.click();
				Thread.sleep(4000);
				WebElement messageClosebutton = driver.findElement(By.xpath("//div[@class = 'ml4 msg-overlay-conversation-bubble msg-overlay-conversation-bubble--default-inactive msg-overlay-conversation-bubble--is-active msg-overlay-conversation-bubble--petite ember-view']/descendant::button[@class = 'msg-overlay-bubble-header__control js-msg-close']"));
				messageClosebutton.click();
				Thread.sleep(3000);
				System.out.println("Say Congrats Done");
			} else {

			}
		}
//	
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name = 'passwd']")).sendKeys("Password1005");
//		Thread.sleep(3000);
//		driver.findElement(By.id("idSIButton9")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("idBtn_Back")).click();
			
		
	}
//public void sayCongrats() throws InterruptedException {
//	
//	List<WebElement> ListOfsayCongrats = driver.findElements(By.xpath("//span[contains(text(), 'Say congrats')]/ancestor::button"));
//	int Cnt = ListOfsayCongrats.size();
//	for (int i = 0; i < Cnt; i++) {
//		Thread.sleep(3000);
//		WebElement messageSendbutton = driver.findElement(By.xpath("//div[@class = 'ml4 msg-overlay-conversation-bubble msg-overlay-conversation-bubble--default-inactive msg-overlay-conversation-bubble--petite ember-view']/descendant::button[@class = 'msg-form__send-button button-tertiary-small']"));
//		messageSendbutton.click();
//		Thread.sleep(3000);
//		WebElement messageClosebutton = driver.findElement(By.xpath("//div[@class = 'ml4 msg-overlay-conversation-bubble msg-overlay-conversation-bubble--default-inactive msg-overlay-conversation-bubble--petite ember-view']/descendant::button[@class = 'msg-overlay-bubble-header__control js-msg-close']"));
//		messageClosebutton.click();
//	}
//
//}

}
