package com.application.mantisbt.PartA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_11_WIthXpath {

public static void main(String[] args) {
		
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
	Assignment_11_WIthXpath objBussPro = new Assignment_11_WIthXpath();
	objBussPro.LoginToMantis("http://localhost:8080/mantisbt/login_page.php", "Administrator", "root");
	objBussPro.reportCreation();
	objBussPro.LogOut();
}	

WebDriver driver =  new FirefoxDriver();
	
public void LoginToMantis(String URL, String UserName, String Password) {	
		
		driver.get(URL);
		
		WebElement uName = driver.findElement(By.xpath("//input[@name = 'username']"));
		uName.sendKeys(UserName);
		
		WebElement pass = driver.findElement(By.xpath("//input[@name = 'password']"));
		pass.sendKeys(Password);
		
		WebElement button = driver.findElement(By.xpath("//input[@class = 'button']"));
		button.click();
	}

public void reportCreation() {
	
		WebElement reportIsstab = driver.findElement(By.partialLinkText("Report I"));
		reportIsstab.click();
		
		String option_category_id = "[All Projects] General";
		String option_reproducibility = "sometimes";
		String option_severity = "major";
		String option_priority = "urgent";
		String option_handler_id = "administrator";
		String summary = "Assignment Testing Summary";
		String description = "Assignment Testing Description";
		
		Select selectCategory  = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
		selectCategory.selectByVisibleText(option_category_id);
		
		Select selectReproducibility = new Select(driver.findElement(By.xpath("//select[@name='reproducibility']")));
		selectReproducibility.selectByVisibleText(option_reproducibility);
		
		Select selectSeverity = new Select(driver.findElement(By.xpath("//select[@name='severity']")));
		selectSeverity.selectByVisibleText(option_severity);
		
		Select selectPriority = new Select(driver.findElement(By.xpath("//select[@name='priority']")));
		selectPriority.selectByVisibleText(option_priority);
		
		Select selectAssignTo = new Select(driver.findElement(By.xpath("//select[@name='handler_id']")));
		selectAssignTo.selectByVisibleText(option_handler_id);
		
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys(summary);		
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);		
		driver.findElement(By.xpath("//input[@name='report_stay']")).click();		
		driver.findElement(By.xpath("//input[@class='button']")).click();
		
		String newissueID = getIssueID();
		int newIssueidInt = Integer.parseInt(newissueID);
		String newIssueidString = String.format("%0"+"7"+"d", newIssueidInt);
		System.out.println("New Issue " +newIssueidString + " Is created");
	}

public String getIssueID() {
		String lnkTxt = driver.findElement(By.xpath("//a[contains(text(), 'Submitted')]")).getText();
		String IssueID = "";
		
		Pattern pattern = Pattern.compile("([0-9]+)");
		Matcher matcher = pattern.matcher(lnkTxt);
		if (matcher.find()) {
			IssueID = matcher.group(1);	
	}
		return IssueID;
	}

public void LogOut() {
	driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
	driver.close();
}
}