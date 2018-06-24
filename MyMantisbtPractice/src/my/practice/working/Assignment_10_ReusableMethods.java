package my.practice.working;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_10_ReusableMethods {

public static void main(String[] args) {
		
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
	Assignment_10_ReusableMethods objBussPro = new Assignment_10_ReusableMethods();
	objBussPro.LoginToMantic("http://localhost:8080/mantisbt/login_page.php", "Administrator", "root");
//	objBussPro.getSeverityNumbers("open", "tweak");
	objBussPro.gettablesize();


}	

WebDriver driver =  new FirefoxDriver();
WebDriverWait Wait = new WebDriverWait(driver, 5);
	
public void LoginToMantic(String URL, String UserName, String Password) {	
		
		driver.get(URL);
		
		WebElement uName = driver.findElement(By.name("username"));
		uName.sendKeys(UserName);
		
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys(Password);
		
		WebElement button = driver.findElement(By.className("button"));
		button.click();
		
		}
public void gettablesize() {
	
	WebElement tabSummary = driver.findElement(By.partialLinkText("Summary"));
	tabSummary.click();
	System.out.println(driver.findElement(By.xpath("//td[contains(text(),  'By Severity')]")).getText());
	System.out.println(driver.findElement(By.xpath("//td[contains(text(),  'By Severity')]/ancestor:: tr[1]")).getText());
	System.out.println(driver.findElement(By.xpath("//td[contains(text(),  'By Severity')]/Parent :: tr/Parent :: tbody/")).getText());
	System.out.println(driver.findElement(By.xpath("//td[contains(text(),  'By Severity')]/Parent :: tr/Parent :: tbody/Parent :: table")).getText());
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
		driver.findElement(By.name("report_stay")).click();	
		driver.findElement(By.className("button")).click();
		
		
		String newissueID = getIssueID();
		int newIssueidInt = Integer.parseInt(newissueID);
		String newIssueidString = String.format("%0"+"7"+"d", newIssueidInt);
		System.out.println("New Issue " +newIssueidString + " Is created");
	}

public String getIssueID() {
		String lnkTxt = driver.findElement(By.partialLinkText("Submit")).getText();
		String IssueID = "";
		
		Pattern pattern = Pattern.compile("([0-9]+)");
		Matcher matcher = pattern.matcher(lnkTxt);
		if (matcher.find()) {
			IssueID = matcher.group(1);	
	}
		return IssueID;
	}

public void getSeverityNumbers(String option, String type) {
	
	WebElement tabSummary = driver.findElement(By.partialLinkText("Summary"));
	tabSummary.click();
	
//	"//table//tr//td[contains(text(), 'By Severity')]//following-sibling::td[contains(text(),'closed')]"
	

	int cntSeverity = 0;
	
	WebElement cellSeverity = driver.findElement(By.xpath("//table//tr//td[contains(text(), 'By Severity')]"));
	
	List<WebElement> optionSeverity = cellSeverity.findElements(By.xpath(".//following-sibling::td"));	
	
	for (int i = cntSeverity; i < optionSeverity.size(); i++) {
		
		WebElement oneSeverity = optionSeverity.get(i);
		
		if (oneSeverity.getText().contains(option)) {
			System.out.println("Your option is " + oneSeverity.getText());
			break;
		}
		cntSeverity++;
	}
	System.out.println("And it is abailable at index" + cntSeverity);
	
	WebElement typeSeverity = driver.findElement(By.xpath("//table//tr//td[contains(text(), '"+type+"')]"));
	List<WebElement> onetypeSeverity = typeSeverity.findElements(By.xpath(".//following-sibling::td"));
	WebElement totalIssue = onetypeSeverity.get(cntSeverity);
	String issueNum = totalIssue.getText();

	System.out.println("There are total " + issueNum + " issues in " +option+ " State.");
}

public void LogOut() {
	driver.findElement(By.partialLinkText("Logout")).click();
	driver.close();
}
}















































