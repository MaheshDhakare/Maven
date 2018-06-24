package datadrivenapproch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LibMantis {
	
	public void Login(File TDFile, int dataID) throws IOException {
		String sheetName = "Login";
//		FileInputStream inputStream = new FileInputStream(TDFile);
//		Workbook TDWorkbook;
//		TDWorkbook = new XSSFWorkbook(inputStream);
//		Sheet TDSheet = TDWorkbook.getSheet(sheetName);
		KeywordDriven objMantis = new KeywordDriven();
		Sheet TDSheet = objMantis.getSheetObject(sheetName, TDFile);
	int rowCount = TDSheet.getLastRowNum();
	for (int i = 1; i <= rowCount; i++) 
	{
		Row row = TDSheet.getRow(i);        	
	    	Cell cell0 = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	    	int iDataID =  ((int)cell0.getNumericCellValue());
	    	if (iDataID==dataID) 
	    	{	    	
	    		Cell cell1 = row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	    		Cell cell2 = row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	    		String strUN = cell1.getStringCellValue();
	    		String strPWD = cell2.getStringCellValue();
	    		System.out.println(strUN+" "+strPWD);
	    		break;
	    		
	    	}

	}
		
		
	}
	
	
	public void ReportIssue() {
		
	}

}
