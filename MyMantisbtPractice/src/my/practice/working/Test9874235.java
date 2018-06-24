package my.practice.working;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test9874235 {
	
	public static void main(String[] args) throws IOException {
	
//	String pathName = "C:\\Users\\dhakarem\\Desktop";
//	String fileName = "Assig13.xlsx";
//	String sheetName = "Sheet1";
	
		Test9874235.readExcel("C:\\Users\\dhakarem\\Desktop", "Assig13.xlsx", "Sheet1");		
	}
	
public static void readExcel(String pathName, String fileName, String sheetName) throws IOException {
		
		File file = new File(pathName+"\\"+fileName);
		
		FileInputStream fileInputstream = new FileInputStream(file);
		
		XSSFWorkbook workBook = new XSSFWorkbook(fileInputstream);
		
		XSSFSheet sheet = workBook.getSheet(sheetName);
		
		int rowCnt = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		for (int rowNum = 0; rowNum < rowCnt+1; rowNum++) {
			
			Row row = sheet.getRow(rowNum);
			
			Row newRow = sheet.createRow(rowCnt+1);
			
			for (int i = 0; i < row.getLastCellNum(); i++) {
				
				String[] writeValue = {"TC4", "admin", "rrot"};
				
				Cell cell = newRow.createCell(i);
				cell.setCellValue(writeValue[i]);
			}
//			for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
//				
//				String cellValue = row.getCell(cellNum).getStringCellValue();
//						
//				System.out.print(cellValue+"||");
//			}
//			System.out.println("\n");
		}		
		//Close input stream

		fileInputstream.close();

	    //Create an object of FileOutputStream class to create write data in excel file

	    FileOutputStream outputStream = new FileOutputStream(file);

	    //write data in the excel file

	    workBook.write(outputStream);

	    //close output stream

	    outputStream.close();
		
		workBook.close();
		
		
	}
}
