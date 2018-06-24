package com.application.session2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


// DDA = DataDrivenApproch_Excel.

public class DDA {
	

	public void readTestExecution(String filePath,  String TEFileName, String TCFileName) {
		
		
		File TCfile = new File(filePath+"\\"+TEFileName);
		FileInputStream inputStrem = null;
		XSSFWorkbook TEworkbook = null;
		String TEsheetName= "TestCases";
		try {			
			
			inputStrem = new FileInputStream(TCfile);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Unable to " + TCfile);
		}
		
		try {
			TEworkbook = new XSSFWorkbook(inputStrem);
		} catch (IOException e) {
			System.out.println("Unable to " + inputStrem);
		}
		
		XSSFSheet TEsheet = TEworkbook.getSheet(TEsheetName);
		
		int rowNum = TEsheet.getLastRowNum();
		
		for (int i = 0; i <= rowNum; i++) {
			
			XSSFRow TErow = TEsheet.getRow(i);
			
			XSSFCell cell = TErow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			String cellValue = cell.getStringCellValue();
			
			if (cellValue.equals("Yes"))
			{				
				System.out.println(TErow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK));
				readTestCase(filePath, TCFileName);
			} else
			{

			}
		}		
		
	}
	
	public void readTestCase(String filePath,  String TCFileName) {
		String TEsheetName= "ReportIssue";
		String BusinessPro = null;
		int Data_ID = 0;
		File TCfile = new File(filePath+"\\"+TCFileName);
		FileInputStream inputStrem = null;
		XSSFWorkbook TCworkbook = null;
		try {			
			
			inputStrem = new FileInputStream(TCfile);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Unable to " + TCfile);
		}
		
		try {
			TCworkbook = new XSSFWorkbook(inputStrem);
		} catch (IOException e) {
			System.out.println("Unable to " + inputStrem);
		}
		
		XSSFSheet TCsheet = TCworkbook.getSheet(TEsheetName);
		
		int rowNum = TCsheet.getLastRowNum();
		
		for (int i = 1; i <= rowNum; i++) {
			
			XSSFRow TCrow = TCsheet.getRow(i);	
			
			
			XSSFCell cell1 = TCrow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			XSSFCell cell2 = TCrow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			if (cell1.getStringCellValue().equals(TEsheetName))
			
			{
				
				BusinessPro = cell1.getStringCellValue();
				Data_ID = ((int)cell2.getNumericCellValue());
				
				callBusinessProcess(BusinessPro, Data_ID);
				
			} else {
	//			System.out.println("Failed");
			}
			
		}			
//		callBusinessProcess("C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\DataDrivenApproch", "TestData.xlsx", BusinessPro, Data_ID);
		}
		
	public void callBusinessProcess(String BusinessPro, int Data_ID) {
		
			
			File TDfile = new File("C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\DataDrivenApproch"+"\\"+"TestData.xlsx");
			
			switch (BusinessPro) {
			case "ReportIssue":
				
				Login(TDfile, Data_ID, BusinessPro);

				break;

			default:
				break;
			}
				

			}	
	
	
	
	public Sheet getSheetName (File TDfile, String sheetName) throws IOException {
		
		FileInputStream inputStrem = new FileInputStream(TDfile);
		XSSFWorkbook TDworkbook ;
		TDworkbook = new XSSFWorkbook(inputStrem);
		Sheet TDSheet = TDworkbook.getSheet(sheetName);
		return TDSheet;
		
		
		
	}
	public void Login (File TDfile, int Data_ID, String BusinessPro) {
 				
		FileInputStream inputStrem = null;
		XSSFWorkbook TDworkbook = null;

		try {			
			
			
			inputStrem = new FileInputStream(TDfile);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Unable to " + TDfile);
		}
		
		try {
			TDworkbook = new XSSFWorkbook(inputStrem);
		} catch (IOException e) {
			System.out.println("Unable to " + inputStrem);
		}
		
		System.out.println(BusinessPro);
		System.out.println(Data_ID);
		
		XSSFSheet TDsheet = TDworkbook.getSheet(BusinessPro);
		
		int rowNum = TDsheet.getLastRowNum();
		
		for (int i = 1; i <= rowNum; i++) {
			
			XSSFRow TDrow = TDsheet.getRow(i);
			
			XSSFCell cell0 = TDrow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			int numericCellValue = ((int) cell0.getNumericCellValue());
			
			if (numericCellValue == Data_ID) {
				
				XSSFCell cell1 = TDrow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				XSSFCell cell2 = TDrow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				
				String UN = cell1.getStringCellValue();
				String PWD = cell2.getStringCellValue();
				
				System.out.println("The UserName is - "+UN + " and the Password - " + PWD);
				
			} else {

			}			
			
		}
				
	
}
	
	public static void main(String[] args) {
		String BusinessPro = null;
		int Data_ID = 0;
		DDA obj = new DDA();
		obj.readTestExecution("C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\DataDrivenApproch", "TestExecution.xlsx", "TestCases.xlsx");
//		obj.readTestCase("C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\DataDrivenApproch", "TestCases.xlsx");
//		obj.callBusinessProcess("C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\DataDrivenApproch", "TestData.xlsx", BusinessPro, Data_ID);
	}

}
