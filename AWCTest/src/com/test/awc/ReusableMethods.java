package com.test.awc;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//checkElementDisplayed(locator);
//click(locator)
//compareDropDownOptions(locator, arrOption);
//getAttribute(locator, attribute)
//getColumns(crRow)
//getConfigvalue(propertyName)
//getCurrentUrl()
//getDropDownOptions(locator)
//getProperties()
//getRows(webTable)
//getRows(webTable)
//getText(locator)
//getURL()
//isSelected(locator)
//loadEnvironmentConfiguration()

public class ReusableMethods {
	
	private  WebDriver driver;
	private  Properties config;
	WebDriverWait wait;
	JavascriptExecutor je;
	
public void scroll(WebElement element) {
	
	je = (JavascriptExecutor) driver;
	je.executeScript("arguments[0].scrollIntoView(true);",element);
}	
	public boolean loadEnvironmentConfiguration()
	{
		try
		{
			config = new Properties();
			
			FileReader configFile = new FileReader(new File(System.getProperty("user.dir")+"/src/config.properties"));
			config.load(configFile);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			System.out.println("Error loading Config File!!");
			
			return false;
		}
	}
	
	public Properties getProperties()
	{
		loadEnvironmentConfiguration();
		return config;
	}

	public String getConfigvalue(String propertyName) {
		
		try {
			String propertyValue = config.getProperty(propertyName);
			return propertyValue;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Unable to get "+ propertyName + " property from Config. file");
			return null;
		}
	}
	
public boolean setUpEnvironment() {
		
		try {
			if(loadEnvironmentConfiguration())
				{
				
				String browser = config.getProperty("browserFirefox").toLowerCase().trim();
				switch(browser) {
				case "firefoxx":
					System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe ");
//					System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox41.0\\firefox.exe ");
					driver = new FirefoxDriver();
					System.out.println("> Opened firefox successfully");
					break;
					
				default:
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_win32/chromedriver.exe");		
					ChromeOptions options = new ChromeOptions(); 
					options.setBinary(System.getProperty("user.dir") + "/browsers/Chrome/Application/chrome.exe");
					options.addArguments("start-maximized");
					driver = new ChromeDriver(options);
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("driver.pageLoadTimeout")), TimeUnit.SECONDS);
				return true;
				}
			else
			{
				return false;
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		}
	
public  boolean tearDownEnvironment()
{
	try
	{
		driver.quit();
		System.out.println("############################## Shutting down the Environment ############################## ");
//				+ "\n3"
//				+ "\n."
//				+ "\n."
//				+ "\n."
//				+ "\n2"
//				+ "\n."
//				+ "\n."
//				+ "\n1");
		
		return true;
	}catch(Exception exception){
		exception.printStackTrace();
		
		System.out.println("Failed to shut down Enviornment!!");
		return false;
	}
}

public  boolean getURL() {
	
	String URL = config.getProperty("urlAwc").trim();
	try {
		driver.get(URL);
		
		System.out.println("> URL '" + URL + "' launched successfully");
		return true;
	} catch (Exception exception) {
		exception.printStackTrace();
		System.out.println("Unable to launch URL - " + URL);
		return false;
	}
}

public  WebElement processWebElement(By locator){
	try
	{
		WebElement webElement = driver.findElement(locator);
		return webElement;
	}catch(Exception exception){
		exception.printStackTrace();
		return null;
	}
}

public  List<WebElement> processWebElements(By locator){
	try
	{
		List<WebElement> webElements = driver.findElements(locator);
		return webElements;
	}catch(Exception exception){
		exception.printStackTrace();
		return null;
	}
}
public  boolean click (By locator){
	try
	{
		WebElement webElement = driver.findElement(locator);
		webElement.click();
		return true;
	}catch(Exception exception){
		exception.printStackTrace();
		return false;
	}
}
public  boolean setText(By locator, String textToSet){
	try
	{
		WebElement webElement = driver.findElement(locator);
		webElement.clear();
		webElement.clear();
		webElement.clear();
		webElement.sendKeys(textToSet);
		return true;
	}catch(Exception exception){
		exception.printStackTrace();
		return false;
	}
}

public  String getText(By locator){
	try
	{
		WebElement webElement = driver.findElement(locator);
		return webElement.getText();
	}catch(Exception exception){
		exception.printStackTrace();
		return "";
	}
}
public  String getAttribute(By locator, String attribute){
	try
	{
		WebElement webElement = driver.findElement(locator);
		return webElement.getAttribute(attribute);
	}catch(Exception exception){
		exception.printStackTrace();
		return "";
	}
}

public  boolean checkElementDisplayed(By locator){
	try
	{
		wait = new WebDriverWait(driver, 10);
		//WebElement webElement = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		return true;
		//return webElement.isDisplayed();
		
	}catch(Exception exception){
		return false;
	}
}

public  boolean isSelected(By locator) {
	try {
		WebElement webElement = driver.findElement(locator);
		webElement.click();
		return webElement.isSelected();
	} catch (Exception exception) {
		return false;
	}
}
public boolean selDropDownOptionByIndex(By locator, int index)
{
	try
	{
		WebElement element = driver.findElement(locator);
		Select selDropDown = new Select(element);
		selDropDown.selectByIndex(index);
		return true;
	}
	catch (Exception e)
	{
		
		e.printStackTrace();
		return false;
	}
}

public  boolean selectOptionFromDropdownByText(By locator, String optionToSelect){
	try
	{
		boolean returnVal = false;
		WebElement webElement = driver.findElement(locator);
		Select weDropDown = new Select(webElement);
		List<WebElement> dropdownOptions = weDropDown.getOptions();
		for(WebElement option : dropdownOptions){
			if(option.getText().contains(optionToSelect)){
				weDropDown.selectByVisibleText(optionToSelect);
				returnVal = true;
			}
		}
		return returnVal;
	}catch(Exception exception){
		exception.printStackTrace();
		return false;
	}
}


public List<WebElement> getDropDownOptions(By locator)
{
	try
	{
		WebElement element = driver.findElement(locator);
		Select selDD = new Select(element);
		return selDD.getOptions();
	} 
	catch (Exception e) 
	{
		
		e.printStackTrace();
		return null;
	}
}

public void prntDropDownOptions(By locator) {
	int counter=1;
	
	Select lstCategory = new Select(driver.findElement(locator));
	List<WebElement> lstOptions = lstCategory.getOptions();
	System.out.println(" There are " + lstOptions.size() + " under the list ");
	for (WebElement prntOptions : lstOptions) {
		System.out.println(counter+ ". " +prntOptions.getText());
		counter++;
		
	}
	
}

public void compareDropDownOptions(By locator, String arrOption) {

	try
	{
		
		WebElement webElement = driver.findElement(locator);
		Select weDropDown = new Select(webElement);
		List<WebElement> dropdownOptions = weDropDown.getOptions();
		for(WebElement option : dropdownOptions){
			if(option.getText().contains(arrOption)){
				System.out.println("Array Value " + arrOption + " matches with drop down value "+ option.getText());
			}
			else {
				System.out.println("Array Value " + arrOption + " does'nt matches with drop down value "+ option.getText());
			}
		}
		
	}catch(Exception exception){
		exception.printStackTrace();
		
	}

	
	
	
}


public int prntDropDownIndex(By locator , String lstText) {
	int found=-1;
	Select lstCategory = new Select(driver.findElement(locator));
	List<WebElement> lstOptions = lstCategory.getOptions();
	for (int i = 0; i < lstOptions.size(); i++) {
		WebElement option = lstOptions.get(i);
		
		if(option.getText().toLowerCase().contains(lstText)) {
			System.out.println("Value found as: " + option.getText());
			found=i;
			}
		}
	return found;
}

public List<WebElement> getRows(WebElement webTable) {
	try {
		return webTable.findElements(By.tagName("tr"));
	} catch (Exception e) {
		
		e.printStackTrace();
		return null;
	}
}

/*
 * Get list of columns
 */
public List<WebElement> getColumns(WebElement crRow) {
	try {
		return crRow.findElements(By.tagName("td"));
	} catch (Exception e) {
	
		e.printStackTrace();
		return null;
	}
}
public String getCurrentUrl() {
	try {
		return driver.getCurrentUrl();
	} catch (Exception e) {
		
		return null;
	}
}

public String currentDateandTime() {
	  
	  try {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			java.util.Date date = new java.util.Date();
			String dateAndtime = dateFormat.format(date);
			return dateAndtime;
			
	} catch (Exception e) {
		
		return null;
	}
}	
public void explicitWait(Long time) {
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	
}		
public void refresh() {
	driver.navigate().refresh();
	
}	

}
