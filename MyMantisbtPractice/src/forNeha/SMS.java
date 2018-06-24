package forNeha;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SMS {
	
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	static int rowNum = 2;
	static By another = By.id("sm1");
	static By num = By.xpath("//input[@placeholder =  'Enter Mobile Number or Name']");
	static By textarea = By.xpath("//textarea[@id =  'sendSMSMsg']");
	static By sendnow = By.xpath("//input[@id =  'btnsendsms']");
	

public static void main(String[] args) throws IOException, InterruptedException {
	

	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");

	All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();

	objBussPro.ReadExcel("C:\\Users\\dhakarem\\Documents\\MyStuff\\Training Setup\\SMSList.xlsx", "sms");
	
	objBussPro.LoginToMantis("http://www.160by2.com/Logout", "9011603678", "Password@123");
	
	int rowcnt = objBussPro.getRowcnt();
	System.out.println(rowcnt);
	
	Thread.sleep(1000);
	for (int i = 1; i < rowcnt; i++) {
		
		Thread.sleep(2000);
		objBussPro.switchToframe();
		WebElement num11 = objBussPro.getWebElement(num);
		num11.clear();
		num11.clear();
		num11.clear();
		num11.sendKeys("9011603678");
		
		WebElement textarea11 = objBussPro.getWebElement(textarea);
		textarea11.sendKeys("Hello");
		WebElement sendnow11 = objBussPro.getWebElement(sendnow);
		sendnow11.click();
		WebElement another11 = objBussPro.getWebElement(another);
		another11.click();
		String messValue = objBussPro.getCellvalue(0, 1);
		WebElement textarea1 = objBussPro.getWebElement(textarea);
		textarea1.sendKeys(messValue);

		String cellvalue = objBussPro.getNumricCellvalue(i, 0);
		
		if (cellvalue.equals(null)) {
			break;
		}
		WebElement num1 = objBussPro.getWebElement(num);
		num1.clear();
		num1.clear();
		num1.clear();
		num1.sendKeys(cellvalue);
		Thread.sleep(2000);
		WebElement sendnow1 = objBussPro.getWebElement(sendnow);
		sendnow1.click();
		objBussPro.setCellvalue(i, 2, "Sent");
		WebElement another1 = objBussPro.getWebElement(another);
		another1.click();
		
	}
	
	

}	
}
