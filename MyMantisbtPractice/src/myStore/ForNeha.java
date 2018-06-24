package myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ForNeha {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		driver.get("http://www.160by2.com/Logout");
		
	}

}
