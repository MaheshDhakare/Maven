package test.pageobjectmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AA_PageObjectModel_TestCases {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		
		driver = new FirefoxDriver();	}

	@Test
	public void test() {

		B_PageModelApproch_LoginPage LoginPageObjects = new B_PageModelApproch_LoginPage(driver);
		C_PageModelApproch_MainPageObjects MainPageObjects = new C_PageModelApproch_MainPageObjects(driver);
		D_PageModelApproch_ReportIssueTab ReportIssue = new D_PageModelApproch_ReportIssueTab(driver);
		
		LoginPageObjects.Login();
		MainPageObjects.nevigateToReportIssueTab();	
		ReportIssue.createReportIssue();
		String issueIDInViewIssue = ReportIssue.getIssueIDInViewIssue();
		System.out.println(issueIDInViewIssue);
	}

	@After
	public void tearDown() throws Exception {
		
//		A_GeneralMethods generialMethods = new A_GeneralMethods();
//		
//		generialMethods.closeTheBrowser(driver);
		
	}
	
}
