package com.application.mantisbt.PartA;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment_7_MainFunction {
	

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
	
	String option_category_id = "[All Projects] General";
	String option_reproducibility = "sometimes";
	String option_severity = "major";
	String option_priority = "urgent";
	String option_handler_id = "administrator";
	String summary = "Assignment Testing Summary - CHECK SUMMARY";
	String description = "Assignment Testing Description CHECK DESCRIPTION";
	
	Select selectCategory  = new Select(driver.findElement(By.name("category_id")));
	selectCategory.selectByVisibleText(option_category_id);
	
	Select selectReproducibility = new Select(driver.findElement(By.name("reproducibility")));
	selectReproducibility.selectByVisibleText(option_reproducibility);
	
	Select selectSeverity = new Select(driver.findElement(By.name("severity")));
	selectSeverity.selectByVisibleText(option_severity);
	
	Select selectPriority = new Select(driver.findElement(By.name("priority")));
	selectPriority.selectByVisibleText(option_priority);
	
	Select selectAssignTo = new Select(driver.findElement(By.name("handler_id")));
	selectAssignTo.selectByVisibleText(option_handler_id);
	
	driver.findElement(By.name("summary")).sendKeys(summary);
	
	driver.findElement(By.name("description")).sendKeys(description);
	
	driver.findElement(By.name("view_state")).click();
	
	driver.findElement(By.className("button")).click();
	
	System.out.println("New Issue Is created");
	
System.out.println("===================================================================");		
//==========Code to get the Issue ID=============================================================================================================
	
	String lnkTxt = driver.findElement(By.partialLinkText("Submit")).getText();
	String IssueID = "";
	
	Pattern pattern = Pattern.compile("([0-9]+)");
	Matcher matcher = pattern.matcher(lnkTxt);
	if (matcher.find()) {
		IssueID = matcher.group(1);
	
		System.out.println("Issue ID is " + IssueID);
	}
System.out.println("===================================================================");		
//=================Required Field On View Issue table================================================================================	

	WebElement viewIssLink = driver.findElement(By.partialLinkText("View I"));
	viewIssLink.click();
	
	WebElement table = driver.findElement(By.id("buglist"));
	System.out.println("You are in buglist table");
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	System.out.println("tr");
	
			
	for (int rowCnt = 3; rowCnt < rows.size()-1; rowCnt++) {
		
		WebElement row = rows.get(rowCnt);
		List<WebElement> columns = row.findElements(By.tagName("td"));
		String viewIssueID = columns.get(3).getText();
		
		if (viewIssueID.contains(IssueID)) {
			System.out.println("The Issue Id is " + viewIssueID);

			String cloCategory = columns.get(6).getText();			
			System.out.println("Category is "+ "'" +cloCategory+ "'");
			
			String cloSeverity = columns.get(7).getText();
			System.out.println("Severity is "+ "'" + cloSeverity+ "'");
			
			String cloStatus = columns.get(8).getText();
			System.out.println("Status is "+ "'" +cloStatus+ "'");
			
			String cloSummary = columns.get(10).getText();
			System.out.println("Summary is "+ "'" + cloSummary+ "'");
			columns.get(3).click();
			break;
		}
	}
System.out.println("===================================================================");	
//====================To verify the required fields========================================================================================
	
	String comCategory = driver.findElement(By.xpath("//td[contains(text(), '"+option_category_id+"')]")).getText();

	if (comCategory.contains(option_category_id)) {
		System.out.println("Category ID is "+ "'" +comCategory+ "'" +" and saved correctly");		
	} else {
		System.out.println("Category ID saved incorrectly");
	}
	
String comSeverity = driver.findElement(By.xpath("//td[contains(text(), '"+option_severity+"')]")).getText();

	
	if (comSeverity.contains(option_severity)) {
		System.out.println("Severity ID is "+"'" +option_severity +"'" +" and saved correctly");		
	} else {
		System.out.println("Severity ID saved incorrectly");
	}
	
String comSummary = driver.findElement(By.xpath("//td[contains(text(), '"+summary+"')]")).getText();
	
	if (comSummary.contains(summary)) {
		System.out.println("Summary is "+"'" +comSummary +"'" +" and saved correctly");		
	} else {
		System.out.println("Summary saved incorrectly");
	}
	
String comdescription = driver.findElement(By.xpath("//td[contains(text(), '"+description+"')]")).getText();
	
	if (comdescription.contains(description)) {
		System.out.println("Description is "+"'" +comdescription +"'" +" and saved correctly");		
	} else {
		System.out.println("Description saved incorrectly");
	}
	
System.out.println("===================================================================");		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}


