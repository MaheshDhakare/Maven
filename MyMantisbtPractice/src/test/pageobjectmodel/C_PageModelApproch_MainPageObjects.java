package test.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_PageModelApproch_MainPageObjects {
	
	WebDriver driver;

	@FindBy(partialLinkText = "Report Issue")
	WebElement ReportIssueTab;

	
	public C_PageModelApproch_MainPageObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void nevigateToReportIssueTab() {

		A_GeneralMethods generialMethods = new A_GeneralMethods();
		
		generialMethods.clickOn(ReportIssueTab);
	
	}

}
