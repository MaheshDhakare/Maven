package com.application.mantisbt.PartB;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_ELATE {

	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		
		driver = new FirefoxDriver();
//		 driver.manage().window().maximize();
//		driver.get("https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwjtgaXxvuzaAhXLhHAKHS3uCGwYABAAGgJzYg&ohost=www.google.co.in&cid=CAESEeD2Fkr68XDH-fWiygTiJ0Ta&sig=AOD64_14jTzuC_9fMMU6YDtq-a9drL4-9w&q=&ved=0ahUKEwjTrJ7xvuzaAhUHSI8KHaDfB_kQ0QwIJg&adurl=");
//		WebElement element = driver.findElement(By.xpath("//nav[@id='main-navigation']//a[contains(text(), 'Homes for Sale')]"));
//		element.click();
		driver.manage().window().maximize();
		
		driver.navigate().to("http://www.moneycontrol.com/india/stockpricequote/computers-software-medium-small/vakrangee/VS");
		driver.findElement(By.xpath("//a[@href = 'http://mmb.moneycontrol.com/stock-message-forum/vakrangee/comments/13264']")).click();
		
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		
		int handlesSize = windowHandles.size();
		System.out.println("Total "+handlesSize + " are available");
		WebDriver webDriver = driver.switchTo().window(windowHandles.get(1));
		String title = webDriver.getTitle();
		System.out.println(title);
		WebElement button = driver.findElement(By.xpath("//img[@title='Bearish']"));
		System.out.println(button.getText());
		button.click();
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn_submit']"));
		System.out.println(element.getText());
		element.click();
		driver.close();

	}

}
