package keyword.driven.framework;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;


public class KeywordDriven 
{
	LibMantisKeywords MyLib = new LibMantisKeywords();
public void readTestPlan(String filePath,String ExPlFileName,String TCFileName,String sheetName, String BisunessPro) throws IOException
	{
		File RPfile =    new File(filePath+"\\"+ExPlFileName);
		File TCfile =    new File(filePath+"\\"+TCFileName);
    	KeywordDriven objMantis = new KeywordDriven();
    	FileInputStream inputStream = new FileInputStream(RPfile);
    
    String fileExtensionName = ExPlFileName.substring(ExPlFileName.indexOf("."));	
    Workbook RPWorkbook = null;
    if(fileExtensionName.equals(".xlsx")){
    	RPWorkbook = new XSSFWorkbook(inputStream);
    }
    else if(fileExtensionName.equals(".xls")){
        RPWorkbook = new HSSFWorkbook(inputStream);
    }
    Sheet RPSheet = RPWorkbook.getSheet(sheetName);
    int rowCount = RPSheet.getLastRowNum();

    String strTR;
    for (int i = 1; i <= rowCount; i++) 
    {
    	Row row = RPSheet.getRow(i);        	
        	Cell cell0 = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
        	Cell cell1 = row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
        	Cell cell2 = row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
        	String strTestCase = cell1.getStringCellValue();
        	String strExecution = cell2.getStringCellValue();
        	if (strExecution.equals("Yes")) {
				System.out.println("Executing "+strTestCase);
				readTestCase(TCfile, strTestCase,BisunessPro);
			}
    	
    }
	}
	

public void readTestCase(File TCFile,String sheetName, String BusinessPro) throws IOException{

	KeywordDriven objMantis = new KeywordDriven();	
 
	FileInputStream inputStream = new FileInputStream(TCFile);

	Workbook TCWorkbook;
	TCWorkbook = new XSSFWorkbook(inputStream);

Sheet TCSheet = TCWorkbook.getSheet(sheetName);
int rowCount = TCSheet.getLastRowNum();

for (int i = 1; i <= rowCount; i++) 
{
	Row row = TCSheet.getRow(i);        	
    	
    	Cell cell1 = row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
    	Cell cell2 = row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
    	
    	if (cell1.getStringCellValue().equals(BusinessPro))
			
		{
			
    		String strBusProc = cell1.getStringCellValue();
    		int strDataID =  ((int)cell2.getNumericCellValue());
    		System.out.println(strBusProc+" "+strDataID);
    		callBusinessProcess(strBusProc );    	
}
}
}

public void callBusinessProcess(String strBusProc) throws IOException {
	LibMantisKeywords objLib = new LibMantisKeywords();
	String filePath = "C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\KeywordDrivenApproch";
	String KWFileName = "Keyordsdriven.xlsx";
			
	File KWfile =    new File(filePath+"\\"+KWFileName);
	
	Sheet kWSheet = getSheetObject(strBusProc, KWfile);
	
	int rowNum = kWSheet.getLastRowNum();
	
	for (int i = 1; i < rowNum; i++) {
		
		Row kwRow = kWSheet.getRow(i);
		
		Cell cell1 = kwRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Cell cell2 = kwRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Cell cell3 = kwRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Cell cell4 = kwRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		
		String Actions = cell1.getStringCellValue();
		String LocatorType = cell2.getStringCellValue();
		String LocatorValue = cell3.getStringCellValue();
		String DataValue = cell4.getStringCellValue();		
		
		
		System.out.println("   "+Actions+"   "+LocatorType+"   "+LocatorValue+"   "+DataValue);
		
		callAction(Actions, LocatorType, LocatorValue, DataValue);
		
		
	}
	
	}

public void callAction(String Actions, String LocatorType, String LocatorValue,  String DataValue) {
	
//	System.out.println(""+Actions+LocatorType+LocatorValue+DataValue);
//	System.out.println("=========0===========");
	
	WebElement webElement = null;	
	if (!LocatorType.isEmpty() && !LocatorValue.isEmpty()) {
		
		webElement = MyLib.createOnject(LocatorType, LocatorValue);

	}
	
	switch (Actions) {
	
	case "OpenBrowser":
		MyLib.OpenBroswer(DataValue);		
		System.out.println("Broswer Opened Successfully");
		System.out.println("=====================================");
		
		break;
		
	case "GetURL":
		MyLib.OpenURL(DataValue);		
		System.out.println("URL Opened Successfully");
		System.out.println("=====================================");
		
		break;
		
	case "EnterText":
		
		MyLib.enterText(webElement, DataValue);
		System.out.println("Text Entered Opened Successfully");
		System.out.println("=====================================");
			
		
		break;
		
	default:
		break;
	}
	
	
	
}


public Sheet getSheetObject(String sheetName, File TDFile ) throws IOException {
	
	FileInputStream inputStream = new FileInputStream(TDFile);
	Workbook TDWorkbook;
	TDWorkbook = new XSSFWorkbook(inputStream);
	Sheet TDSheet = TDWorkbook.getSheet(sheetName);
	return TDSheet;
	
}	    
//Main function is calling readExcel function to read data from excel file
public static void main(String...strings) throws IOException{
	    KeywordDriven objExcelFile = new KeywordDriven();
	     objExcelFile.readTestPlan("C:\\Users\\dhakarem\\Desktop\\Assignment_Module_1_MaheshDhakare\\KeywordDrivenApproch", "TestExecution.xlsx","TestCases.xlsx" ,"TestCases", "Login");
}	
	    
	    
	
}

