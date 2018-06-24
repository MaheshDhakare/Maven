package keyword.driven.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LibMantisKeywords {
	
	WebDriver driver;
	
	public void OpenBroswer(String TestValue) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
		driver = new FirefoxDriver();
		
	}
	
	
	public void OpenURL(String TestValue) {
		
		driver.get(TestValue);
		
	}
	
	public void enterText(WebElement webelement, String TestValue) {
		
//		System.out.println("1  " +webelement + " 2 "+ TestValue);
		webelement.sendKeys(TestValue);
		
	}	
	
	public WebElement createOnject(String LocType, String locValue) {
		
		WebElement we = null;
		
		switch (LocType) {
		case "id":
			we = driver.findElement(By.id(locValue));
			break;
			
		case "xpath":
			we = driver.findElement(By.xpath(locValue));
			break;
		default:
			break;
		}
		return we;
		
	}

}
