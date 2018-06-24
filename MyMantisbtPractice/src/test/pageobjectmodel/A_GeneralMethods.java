package test.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class A_GeneralMethods {
	
	public void clickOn(WebElement tabName) {
		
		try {
			tabName.click();
		} catch (Exception e) {
			System.out.println("Unable to find " + tabName);
		}
		
	}
	public void closeTheBrowser(WebDriver driver) {
		
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Unable to find close the browswer");
		}
		
	}
	
	public boolean selectDropdown(WebElement webelement, String value) {
		
		try {
			Select select  = new Select(webelement);
			select.selectByVisibleText(value);

			return true;
		} catch (Exception e) {
			
			System.out.println("Unable to find" + value + " in the dropdown");

			return false;
		}
	}
	
	public boolean setText(WebElement webElement, String textValue) {
		
		try {
			webElement.sendKeys(textValue);

			return true;
		} catch (Exception e) {
			System.out.println("Unable to set" + textValue + " in the filed");
			return false;
		}
	}
}
