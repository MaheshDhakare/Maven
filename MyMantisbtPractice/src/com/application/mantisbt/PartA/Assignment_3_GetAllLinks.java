package com.application.mantisbt.PartA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_3_GetAllLinks {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
	Assignment_3_GetAllLinks objMantis = new Assignment_3_GetAllLinks();
	objMantis.LoginToMantic("http://localhost:8080/mantisbt/login_page.php");	
		
	}
	
WebDriver driver =  new FirefoxDriver();
public void LoginToMantic(String URL) {	
		
	driver.get(URL);
		
		List<WebElement> allLinksList = driver.findElements(By.tagName("a"));
		System.out.println("Total numbers are "+ allLinksList.size());
		System.out.println("And below is the List");
		
		for (int i = 0; i < allLinksList.size(); i++) {
			
			String links = allLinksList.get(i).getText();
			System.out.println(links);
		}

}
}
