package my.practice.working;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Assignment_13_ExcelSheet2 {
	
	String userName = "";
	String password = "";

public static void main(String[] args) throws IOException {
		
//	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");		
	Assignment_13_ExcelSheet2 objBussPro = new Assignment_13_ExcelSheet2();
	objBussPro.ReadExcel();
//	objBussPro.LoginToMantic("http://localhost:8080/mantisbt/login_page.php", "Administrator", "root");

}	

public void ReadExcel() throws IOException {
	
	FileInputStream fileInput = new FileInputStream("C:\\Users\\dhakarem\\Desktop\\Assig13.xlsx");
	XSSFWorkbook wB = new XSSFWorkbook(fileInput);
	XSSFSheet wS = wB.getSheet("Sheet1");
	int lastRowNum = wS.getLastRowNum();
	System.out.println( "There are total " +lastRowNum+ "Rows");
	int lastCellNum = wS.getRow(0).getLastCellNum();
	System.out.println("There are total " +lastCellNum+ "Columns");
	
	XSSFCell sC = wS.getRow(1).getCell(2);
	userName = sC.getStringCellValue();
	XSSFCell sC1 = wS.getRow(2).getCell(2);
	
	password = sC1.getStringCellValue();
	System.out.println("The value is " + sC);
	System.out.println("The value is " + sC1);

for (int i = 1; i < lastRowNum-1; i++) {
		
		XSSFCell sC2 = wS.getRow(i).getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		
		String attribute = sC2.getStringCellValue();
		System.out.println(attribute);
		
		
		if (attribute.contains("UserName1")) {
			XSSFCell sCC = wS.getRow(i).getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String userNamevalue = sCC.getStringCellValue();
			System.out.println("The user name is " + userNamevalue);
			
		}
		if (attribute.contains("Password1")) {
			XSSFCell sCC = wS.getRow(i).getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String Passwordvalue = sCC.getStringCellValue();
			System.out.println("The password is " + Passwordvalue);
				
		}
		
	
		
		
		System.out.println(i);
	}


	wB.close();
}



public void LoginToMantic(String URL, String UserName, String Password) {	
	
		
		WebDriver driver =  new FirefoxDriver();
		
		driver.get(URL);
		
		WebElement uName = driver.findElement(By.name("username"));
		uName.sendKeys(userName);
		
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys(password);
		
		WebElement button = driver.findElement(By.className("button"));
		button.click();
		
		}


}







































