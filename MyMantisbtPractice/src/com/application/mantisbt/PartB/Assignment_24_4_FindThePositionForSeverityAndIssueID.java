package com.application.mantisbt.PartB;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;





public class Assignment_24_4_FindThePositionForSeverityAndIssueID {
	
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	static int rowNum = 2;
	WebElement table;


public static void main(String[] args) throws IOException, InterruptedException {
	
	System.out.println("===================Assignment_24_4_FindThePositionForSeverityAndIssueID=================== ");
		
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
	
	All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();

	objBussPro.ReadExcel("C:\\Users\\dhakarem\\Desktop\\Eclipse_Workspace\\Assig13.xlsx", "Test");
	
for (int rowNum = 1; rowNum < 2; rowNum++) {
	
	String userName = objBussPro.getCellvalue(rowNum, 1);
	String password = objBussPro.getCellvalue(rowNum, 2);
	
	if ((userName != null) && (password != null)){

		objBussPro.LoginToMantis("http://localhost:8080/mantisbt/login_page.php", userName, password);		
		
		if (objBussPro.validedWebElement(objBussPro.logoutButton)) {
			
			System.out.println("==========================================================");
			System.out.println("Login to Mantis successful");
			System.out.println("==========================================================");
			
			if (objBussPro.validedWebElement(objBussPro.reportIsstab)) {
				
					objBussPro.clickOn(objBussPro.viewIsstab);
					System.out.println("Successfully clicked on View Issue tab");
					System.out.println("==========================================================");
					
					if (objBussPro.validedWebElement(objBussPro.viewIssueTabValidation)) {						
						
						objBussPro.getCellFromTheViewIssueTableUsingValueTwoValues("Severity", "ID", "minor");
											
						System.out.println("==========================================================");
												
							if (objBussPro.validedWebElement(objBussPro.logoutButton)) {
										
									objBussPro.clickOn(objBussPro.logoutButton);
										
										if (objBussPro.validedWebElement(objBussPro.loginButton)) {
											
											System.out.println("Successfully logout from Mantis");
											System.out.println("==========================================================");
											objBussPro.closeBrowser();
											objBussPro.setCellvalue(rowNum, 12, "Passed");
											System.out.println("Successfully closed the browser");
											System.out.println("==========================================================");
											
										} else
										{
											System.out.println("Unable to close browser");
											objBussPro.setCellvalue(rowNum, 12, "Failed");
											objBussPro.setCellvalue(rowNum, 13, "Unable to close browser");
										}
									} else
									{
										
										System.out.println("Unable to find 'Logout button'");
										objBussPro.setCellvalue(rowNum, 12, "Failed");
										objBussPro.setCellvalue(rowNum, 13, "Unable to find 'Logout button'");
										objBussPro.closeBrowser();
									}
								}else
					{
						System.out.println("Unable to find Viewng Issues cell value");
						objBussPro.setCellvalue(rowNum, 13, "Unable to find Vewing Issues cell value");
						objBussPro.setCellvalue(rowNum, 12, "Failed");
						objBussPro.closeBrowser();
					}
					}
				else
			{
				System.out.println("Unable to find 'Report Issue' link");
				objBussPro.setCellvalue(rowNum, 12, "Failed");
				objBussPro.setCellvalue(rowNum, 13, "Unable to find 'Report Issue' link");
				objBussPro.closeBrowser();
			}

		
		} else {
			
			
			System.out.println("Unable to Login to Mantis");
			objBussPro.setCellvalue(rowNum, 12, "Failed");
			objBussPro.setCellvalue(rowNum, 13, "Unable to Login to Mantis");
			objBussPro.closeBrowser();
		}
		
	} else {

		System.out.println("Username or Password is missing");
		objBussPro.setCellvalue(rowNum, 12, "Failed");
		objBussPro.setCellvalue(rowNum, 13, "Username or Password is missing");
	
		
	}
	
System.out.println("::::::::::::::::::::::::::::Test Case Ends::::::::::::::::::::::::::::");

}	
}
}		







































