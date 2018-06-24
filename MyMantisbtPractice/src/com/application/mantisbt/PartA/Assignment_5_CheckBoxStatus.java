package com.application.mantisbt.PartA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Assignment_5_CheckBoxStatus {
	

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
	
//========Check CheckBox Status==============================================================================
		
	WebElement reportIsstab = driver.findElement(By.partialLinkText("Report I"));
	reportIsstab.click();

	boolean status = driver.findElement(By.name("report_stay")).isSelected();
	
	if (status) {
		System.out.println("Status CheckBox is already selected");
	} else {
		System.out.println("CheckBox was not selected, thats why selecting Now");
		driver.findElement(By.name("report_stay")).click();
	}

}

}
