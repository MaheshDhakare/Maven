package forNeha;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SMS2 {
	
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	static int rowNum = 2;
	static By another = By.id("sm1");
	
	static By UN = By.xpath("//input[@placeholder =  'Enter Mobile Number or Name']");
	static By PASS = By.xpath("//textarea[@id =  'sendSMSMsg']");
	static By CLICK = By.xpath("//input[@id =  'btnsendsms']");
	

public static void main(String[] args) throws IOException, InterruptedException {
	

	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");

	All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();
	
	objBussPro.getURL("https://psa.sqs.com/");
	Thread.sleep(3000);
	Alert acceptAlert = objBussPro.acceptAlert();
	acceptAlert.authenticateUsing(new UserAndPassword("Dhakarem", "Password1005"));
//	acceptAlert.sendKeys("Dhakarem");
//	acceptAlert.sendKeys(Keys.chord(Keys.TAB));
//    acceptAlert.sendKeys("Password1005");


//	objBussPro.acceptAlert();

}	
}
