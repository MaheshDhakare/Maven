package com.application.session2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class A_Test_Actions {
	
	WebDriver driver;


	@Before
	public void setUp() throws Exception {
		System.out.println("Up");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Down");
	}

//	@Test
	public void test() {
		
		System.out.println("passed");
	}
//	@Test
	public void TestDragAndDrop() {
	
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		
	String URL = "http://jqueryui.com//droppable";
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		
		
		System.out.println(dragElement.getText() + dropElement.getText());
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(dragElement, dropElement).build().perform();
		System.out.println("gdhgdh");
	
				
//		String element = driver.findElement(By.id(".//*[@id='droppable']/descendant::p[contains(text(), 'dropped' )]")).getText();
//		
//		if (element.contains("Dropped")) {
//			System.out.println("Dropped Successfully");
//		} else {
//			System.out.println("Dropped Unsuccessful");
//		}
		
		
		
	}
	@Test
	public void testContextClick() {
		
//		PageFactory.initElements(driver, this);
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
			
		String URL = "http://jqueryui.com//droppable";
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();

			WebElement demoElement = driver.findElement(By.xpath("//a[contains(text(), 'Download')]"));
			
			Actions builder = new Actions(driver);
			
			//builder
			//.contextClick(demoElement)
			//.sendKeys(Keys.ARROW_DOWN)
			//.sendKeys(Keys.ARROW_DOWN)
			//.sendKeys("T")
			//.sendKeys(Keys.ENTER)
			//.build()
			//.perform();
builder.moveToElement(demoElement).build().perform();
			
			
			
		}
//	@Test
	public void testClickHold() {
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
			
		String URL = "http://jqueryui.com//draggable";
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			
			driver.switchTo().frame(0);
			
			WebElement dragElement = driver.findElement(By.id("draggable"));
			
			Actions builder = new Actions(driver);
			
			builder
			.clickAndHold(dragElement)
			.moveByOffset(150, 49)
			.release()
			.build()
			.perform();

			
			
			
		}
}























































