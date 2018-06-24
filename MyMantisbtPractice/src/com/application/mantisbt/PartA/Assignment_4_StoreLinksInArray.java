package com.application.mantisbt.PartA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_4_StoreLinksInArray {

	public static void main(String[] args) {
	
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
	Assignment_4_StoreLinksInArray objMantis = new Assignment_4_StoreLinksInArray();
	objMantis.LoginToMantic("http://localhost:8080/mantisbt/login_page.php");	
		
	}
	
WebDriver driver =  new FirefoxDriver();
public void LoginToMantic(String URL) {	
		
		driver.get(URL);
		
		List<WebElement> allLinksList = driver.findElements(By.tagName("a"));
		System.out.println("Total numbers are "+ allLinksList.size());
		System.out.println("And below is the List");
		
		int nCnt = 0;
		String arry[] = new String[allLinksList.size()];
		
		for (int i = 0; i < allLinksList.size(); i++) {
			
			WebElement link = allLinksList.get(i);
			link.getText();
			arry[nCnt] = link.getText();
			nCnt++;
		}
		for (String webElement : arry) {
			System.out.println(webElement);
		}
	}

}
