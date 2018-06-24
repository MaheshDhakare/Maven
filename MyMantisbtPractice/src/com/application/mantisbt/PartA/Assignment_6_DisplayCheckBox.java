package com.application.mantisbt.PartA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Assignment_6_DisplayCheckBox {
	

public static void main(String[] args) {
		
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
	
	WebDriver driver =  new FirefoxDriver();
	
	String URL = "http://localhost:8080/mantisbt/login_page.php";
	String UserName = "administrator";
	String Password = "root";
	
//========Open URL==============================================================================		
		
	driver.get(URL);
		
	WebElement uName = driver.findElement(By.name("username"));
	uName.sendKeys(UserName);
		
	WebElement pass = driver.findElement(By.name("password"));
	pass.sendKeys(Password);
		
	WebElement button = driver.findElement(By.className("button"));
	button.click();
	
//========Report An Issue==============================================================================
		
	WebElement reportIsstab = driver.findElement(By.partialLinkText("Report I"));
	reportIsstab.click();
	
	driver.findElement(By.xpath("//label[contains(text(),'private')]")).click();
	boolean status = driver.findElement(By.name("view_state")).isSelected();
	
	if (status) {
		String selectedCheckBox = driver.findElement(By.xpath("//label[contains(text(),'public')]")).getText();
		System.out.println(selectedCheckBox + " is CheckBox is already selected");
	} else {
		System.out.println("Status CheckBox is not selected");
	
	}
}

}
