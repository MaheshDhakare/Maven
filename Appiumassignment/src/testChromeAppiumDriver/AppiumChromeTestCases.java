package testChromeAppiumDriver;

import io.appium.java_client.AppiumDriver;

import java.util.List;


import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class AppiumChromeTestCases {
	
	static AppiumDriver driver;
	ScriptforWebBrowser browser = new ScriptforWebBrowser();
	
@Test
public void Exercise11_Scripts_for_webBrowser_chrome() throws InterruptedException {

	System.out.println();
	String searchWord = "Testing";		
	
		browser.openChromebrowser();
		System.out.println("Open Chrome browser successfully");
		browser.navigateTourl("http://www.google.com");
		System.out.println("Open google.com successfully");
		Thread.sleep(3000);
		
		browser.searchText(searchWord);
		browser.clickOnsearch();
		System.out.println("Typed " +searchWord+ " in searchBox and clicked on search button successfully");
		int num = 1;
		List<WebElement> linksfromPage = browser.findLinksfromPage();
		
		System.out.println("Below are the links available after searching " +"'"+ searchWord +"'"+ " word.");
		System.out.println();
		for (WebElement link : linksfromPage) {

			System.out.println(num + "> " + link.getText());
		
			num++;
		}
		browser.quitBrowser();
		System.out.println("===================================End======================================");
		}
}
