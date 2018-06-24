package com.test.awc;

import java.util.Random;

import org.openqa.selenium.By;

public class AWCCreateItem {
	
private ReusableMethods objReusable;
	
public AWCCreateItem(ReusableMethods objReuse) {
	objReusable = objReuse;
}
	By homeFolder = By.xpath("//div[@class = 'homefolder_light icon']");
	By autFolder = By.xpath("//div[@id='gwt-debug-PrimaryWorkArea']/descendant::h3[@title = 'AUTSelenium']");
	By createIcon = By.xpath("//div[@title = 'Create']");
	By filterTextBox = By.xpath("//input[@class='aw-create-filterTextBox']");
	By folderIcon = By.xpath("//div[contains(text(), 'Folder')]");	
	By itemIcon = By.xpath("//div[contains(text(), 'Item')]");
	By itemName = By.xpath("//div[contains(text(), 'Name: ')]/ancestor::div[@class = 'propertyLabelTopContainer']/following-sibling::div[@class = 'aw-widgets-propertyLabelTopValueContainer']/textarea");
	By itemID = By.xpath("//div[contains(text(), 'ID: ')]/ancestor::div[@class = 'propertyLabelTopContainer']/following-sibling::div[@class = 'aw-widgets-propertyLabelTopValueContainer']/textarea");
	By itemCreateIcon = By.xpath("//div[@class = 'aw-layout-panelFooter']/descendant::button[contains(text(), 'Create')]");
	//By verifyItemCreate = By.xpath("//div[@id='gwt-debug-PrimaryWorkArea']/descendant::h3[@title = '"+test+"']");
	By cmdOpen = By.xpath("//div[@title='Open']");
	
	By notifyMsg = By.xpath("/span[@class = 'noty_text']");
	By autFolderOpen = By.xpath("//div[@id='gwt-debug-PrimaryWorkArea']/descendant::h3[@title = 'AUTSelenium']/ancestor::div[@class='aw-widgets-cellListCellContent']/following-sibling::div[@id='commandList']/a[@id='showObjectCommand']");
	
	
	
	public boolean checkFolder(By locator) {
		
		try {
			if(!objReusable.checkElementDisplayed(locator)) {
				System.out.println("Folder is not available!!");
				
				if(objReusable.checkElementDisplayed(createIcon)){
					objReusable.click(createIcon);
					System.out.println("Add button clicked for creating new folder.");
					
					if(objReusable.checkElementDisplayed(folderIcon)) {
						
						objReusable.click(folderIcon);
						System.out.println("Clicked on folder create Icon");
						
						if(objReusable.checkElementDisplayed(itemName)) {
							objReusable.setText(itemName, "AUTSelenium");
							
							if(objReusable.checkElementDisplayed(itemCreateIcon)) {
								objReusable.click(itemCreateIcon);
								System.out.println("Create AUTSelenium folder successfully.");
								return true;
							}
							else {
								System.err.println("Unable to create Folder ");
								return false;
							}
						}
						else {
							System.err.println("Unable to Enter Folder name");
							return false;
						}
						
						
					}
					else
					{
						System.err.println("Unable to find Folder Icon");
						return false;
					}
					
					
				}
				else {
					System.err.println("Unable to find create icon.");
					return false;
				}
				
			}
			else
			{
				return true;
			}
			
		} catch (Exception e) {
			
			return false;
		}
		
	}
			
	public String createItem(String itemType) {
		
		try {
						
			Random ran = new Random();
		  	  int i = ran.nextInt(1000);
		  	  //System.out.println(i);
		  	  String test = "Testing" + i;
			//String title = objReusable.getCurrentUrl();
			//System.out.println(title);
			
			
			if(objReusable.checkElementDisplayed(homeFolder)){
				
				objReusable.click(homeFolder);
				System.out.println("> Clicked on Home Folder successfully");
				
					if(checkFolder(autFolder)) {
						objReusable.click(autFolder);
						objReusable.click(autFolderOpen);
						System.out.println("> Opened Automation Folder successfully");
										
				
					if(objReusable.checkElementDisplayed(createIcon)) {
						objReusable.click(createIcon);
						System.out.println("> Clicked on Add button successfully");
					
					if(objReusable.checkElementDisplayed(itemIcon)) {
						
						objReusable.click(itemIcon);
						System.out.println("> Clicked on Itemtype Item successfully ");
						
							if(objReusable.checkElementDisplayed(itemID)) {
								objReusable.setText(itemID, test);
								System.out.println("> Item ID '" + test + "' Entered successfully");
												
									if(objReusable.checkElementDisplayed(itemName)) {	
										objReusable.setText(itemName, "DemoTest" + i);
										System.out.println("> Item name 'DemoTest' Entered successfully");						
										
											if(objReusable.checkElementDisplayed(itemCreateIcon)) {
												objReusable.click(itemCreateIcon);
												System.out.println("> created item# '" + test + "' successfully");

												return test;
								
												}
												else {
												System.err.println("Unable to click on Create button");
												}
									}									
									else {
											System.err.println("Unable to Enter on Item name");
									}
							}
							else {
								System.err.println("Unable to Enter on Item ID");
							}
							}
					else {
						System.err.println("Unable to click on Item button");
					}
					}
					else {
						System.err.println("Unable to click on Add button");
					}
			}
					else {
						System.err.println("Unable to traverse to Automation folder.");
					}
				}				
				else {
					System.err.println("Unable to traverse to Home folder.");
					
				}
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("Unable to create Item" + itemType);
			return null;
		}
		
		
		
		
		
		
		
	}
	
	

}
