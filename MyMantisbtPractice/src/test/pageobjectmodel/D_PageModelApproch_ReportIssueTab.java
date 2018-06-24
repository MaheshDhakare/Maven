package test.pageobjectmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D_PageModelApproch_ReportIssueTab {
	
	WebDriver driver;

	@FindBy(xpath = "//select[@name='reproducibility']")
	WebElement selectReproducibility;
	
	@FindBy(xpath = "//select[@name='severity']")
	WebElement selectSeverity;
	
	@FindBy(xpath = "//select[@name='priority']")
	WebElement selectPriority;
	
	@FindBy(xpath = "//select[@name='category_id']")	
	WebElement selectCategory;
	
	@FindBy(xpath = "//select[@name='handler_id']")
	WebElement selectAssignTo;
	
	@FindBy(xpath = "//input[@name='summary']")
	WebElement  summary;
	
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;
	
	@FindBy(xpath = "//input[@name='report_stay']")
	WebElement reportStay_Button;
	
	@FindBy(xpath = "//input[@name='view_state']")
	WebElement viewStatus_Button;
	
	@FindBy(xpath = "//input[@value='Submit Report']")
	WebElement submitReportButton;
	
	@FindBy(xpath = "//a[contains(text(), 'View Submitted Issue')]")
	WebElement viewSubmittedIssueLink;	

	
	public D_PageModelApproch_ReportIssueTab(WebDriver driver) {	
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void createReportIssue() {

		A_GeneralMethods generialMethods = new A_GeneralMethods();
		generialMethods.selectDropdown(selectCategory, "[All Projects] General");
		generialMethods.selectDropdown(selectReproducibility, "always");
		generialMethods.selectDropdown(selectSeverity, "major");
		generialMethods.selectDropdown(selectPriority, "urgent");
		generialMethods.setText(summary, "Test Summary");
		generialMethods.setText(description, "Test description");
		generialMethods.clickOn(viewStatus_Button);
		generialMethods.clickOn(reportStay_Button);
		generialMethods.clickOn(submitReportButton);		
	
	
	}
	

public String getIssueIDInViewIssue() {
		
		String issueID = null;
				
			try {
				String lnkTxt = viewSubmittedIssueLink.getText();
				
				
				Pattern pattern = Pattern.compile("([0-9]+)");
				Matcher matcher = pattern.matcher(lnkTxt);
				if (matcher.find()) {
					issueID = matcher.group(1);	
				}
				
				int newIssueidInt = Integer.parseInt(issueID);
				issueID = String.format("%0"+"7"+"d", newIssueidInt);
				
			} catch (NumberFormatException e)
			{
				System.out.println("Unable to get Issue ID");
			}
		
		return issueID;
	}
}
