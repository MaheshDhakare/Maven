package com.application.mantisbt.PartB;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Assignment_23_PopOnWindow {
	
	XSSFWorkbook workBook;
	XSSFSheet workSheet;

public static void main(String[] args) throws IOException, InterruptedException {
	
	System.out.println("===================Assignment_23_PopOnWindow=================== ");
		
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
	
	All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();
	
	objBussPro.switchToPopupWindow();

System.out.println("::::::::::::::::::::::::::::Test Case Ends::::::::::::::::::::::::::::");

}	
}







































