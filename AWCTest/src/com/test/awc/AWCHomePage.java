package com.test.awc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AWCHomePage {
	
private ReusableMethods objReusable;

public AWCHomePage(ReusableMethods objReuse) {
	objReusable = objReuse;
}
	
	/* GE AWC
		By homeFolder = By.xpath("//div[@class = 'homefolder_light icon']");
		By moreButton = By.xpath("//div[contains(text(),'More')]"); 
		By userName = By.xpath("//a[@class = 'aw-base-small link-style-3 aw-state-userName']");
		By signOut = By.xpath("//li[contains(text(), 'Sign Out')]");
		By serviceGroup = By.xpath("//li[contains(text(), 'SERVICES.TRANSPORTATION.GE TRANSPORTATION')]");
		By userRole = By.xpath("//a[@class = 'aw-base-small link-style-3 aw-state-userRole']");
		By serviceEngineerrole = By.xpath("//li[contains(text(), 'Services Engineer')]");
		By openButton = By.xpath("//div[@class = 'aw-commands-commandBarPanel aw-commands-commandBarHorizontalRight']/descendant::button[@title= 'Open']");
		By addToButton = By.xpath("//div[@class = 'aw-commands-commandBarPanel aw-commands-commandBarHorizontalRight']/descendant::button[@title= 'Add to']");
		By addButton = By.xpath("//div[@class = 'aw-commands-nativeCommandBar aw-commands-commandBarVertical aw-commands-commandBarContainer ng-isolate-scope']/descendant::button[@id= 'Awp0ShowCreateObject']");
		By verifyAddpanel = By.xpath("//div[@title= 'Add']/ancestor::div[@class = 'aw-layout-panelTitle aw-layout-flexRow aw-layout-panelTitleContainer']");
		
		By addSearchfield = By.xpath("//input[@placeholder = 'Filter']");	
		By addNamefield = By.xpath("//input[@placeholder = 'Required']");
		By creationAddbutton  = By.xpath("//button[@class = 'aw-base-blk-button']");
		By verifyCreatedfolder = By.xpath("//div[@class = 'aw-layout-secondaryWorkarea']/descendant::div[contains(text(), 'TestAut1')]");
		By openCreatedfolder = By.xpath("//div[contains(text(), 'TestAut1')]/following-sibling::div");
	*/
	
	/*SQS AWC 
	 * */
		By homeFolder = By.xpath("//div[contains(text(),'Home Folder')]");
		//By userName = By.xpath("//a[@id = 'gwt-debug-Usernamelink']");
		By signOut = By.xpath("//li[contains(text(), 'Sign Out')]");
		By tcGroup = By.xpath("//a[contains(text(), 'Engineering')]");
		By tcRole = By.xpath("//a[contains(text(), 'Designer')]");
		
		
		By submitToworkfow = By.xpath("//div[@id = 'gwt-debug-ToolsAndInfoCommandBar']/descendant::div[@title = 'Submit to Workflow']");	
		By verifySubmittoWorkflowopened = By.xpath("//div[contains(text(),'Workflow Template')]");
		By selectWorkflowicon  = By.xpath("//select[@class = 'gwt-ListBox']");
		By submitButton = By.xpath("//button[contains(text(),'Submit')]/ancestor::div[@class =  'aw-layout-panelFooter']");
		By verifyTCMReleasestatus = By.xpath("//a[contains(text(),'TCM Released')]");
		
		By userButton = By.id("gwt-debug-Usernamelink");
		By signOutbutton = By.xpath("//li[contains(text(),'Sign Out')]");
		By tagTeamcenter = By.xpath("//h1[contains(text(),'TEAMCENTER')]");
		By listOfitems = By.xpath("//ul[@class = 'aw-widgets-cellListWidget']/li");
		
		
public List<WebElement> listOfitemCreated() {
	try {
		List<WebElement> webElements = objReusable.processWebElements(listOfitems);
		return webElements;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}		

public By selectItemtype(String itemTypename) {

		try {
			By searchItemfromList = By.xpath("//div[@title = '"+itemTypename+"']");
			
			return searchItemfromList;
			
		} catch (Exception e) {
			
			System.out.println("Unable to find the respective Item type");
			return null;
		}
}	
public void clickOnhomeFolder() {

		try {
			
			objReusable.click(homeFolder);
			
		} catch (Exception e) {
			
			System.out.println("Unable to click on More button");
		}
}
public void clickOnmreButton() {

			try {
				
				//objReusable.click(moreButton);
				
			} catch (Exception e) {
				
				System.out.println("Unable to click on More button");
			}
		
	}
public void createFolder() {
	
//	objReusable.click(addToButton);
//	objReusable.setText(addSearchfield, "Folder");
//	objReusable.click(selectItemtype("Folder"));
//	objReusable.click(creationAddbutton);
//	objReusable.checkElementDisplayed(verifyCreatedfolder);
//	objReusable.click(openCreatedfolder);
//	objReusable.click(addButton);
//	objReusable.setText(addSearchfield, "GET Service Part");
//	objReusable.click(selectItemtype("GET Service Part"));
	
	
}	
public void signOut() {

	try {
		if (objReusable.checkElementDisplayed(userButton)) {
			Thread.sleep(3000);
			objReusable.click(userButton);
			System.out.println("> Clicked on 'User1' button successfully");
			
			Thread.sleep(1000);
			if (objReusable.checkElementDisplayed(signOutbutton)) {
				
				objReusable.click(signOutbutton);
				System.out.println("> Clicked on 'sign Out' button successfully");
				
				if (objReusable.checkElementDisplayed(tagTeamcenter)) {
					
					System.out.println("> Successfully sign out from Teamcenter, hence closing the browser");
				} else {
						System.err.println("Failed to sign out from Teamcenter");
				}
			} else {
				System.err.println("Failed to Click on sign out ");

			}
			
		} else {
			System.err.println("Failed to Click on User settings button ");

		}
	} catch (Exception e) {
	
		e.printStackTrace();
	}
}

public void initiateWorkflow(String itemRevisionid ) {

By itemRevid = By.xpath("//label[contains(text(), '"+itemRevisionid+"')]");
By openIcon = By.xpath("//label[contains(text(), '"+itemRevisionid+"')]/ancestor::div[@class = 'aw-widgets-cellListCellContent']/following-sibling::div/a[@id='showObjectCommand']");


	try {
		Thread.sleep(3000);		
		
		List<WebElement> list = listOfitemCreated();
		
		for (int i = 0; i < list.size(); i++) {
			
			objReusable.scroll(list.get(i));
			
			if(list.get(i).getText().equals(itemRevisionid))
			break;
			
		}
//		System.out.println("List of items are" + list.size());

		
		if (objReusable.checkElementDisplayed(itemRevid)) {
		
			objReusable.click(itemRevid);
			
			System.out.println("> Selected "+ itemRevisionid +" item revision successfully");
			
			if (objReusable.checkElementDisplayed(openIcon)) {
				
				objReusable.click(openIcon);
				
				System.out.println("> Item# " + itemRevisionid + " opened succesfully");
			
		    if (objReusable.checkElementDisplayed(submitToworkfow)) {
				
				objReusable.click(submitToworkfow);
				
				System.out.println("> Clicked on 'Submit To Workflow' button successfully");
				Thread.sleep(2000);
				if (objReusable.checkElementDisplayed(verifySubmittoWorkflowopened)) {				
					Thread.sleep(2000);
					objReusable.selectOptionFromDropdownByText(selectWorkflowicon, "TCM Release Process");
					Thread.sleep(1000);
					System.out.println("> Selected 'TCM Release Process' template successfully");
					
					if (objReusable.checkElementDisplayed(submitButton)) {				
						Thread.sleep(1000);
						objReusable.click(submitButton);
						
						System.out.println("> Clicked on Submit Button successfull");
						
						if (objReusable.checkElementDisplayed(verifyTCMReleasestatus)) {	

							System.out.println("> TCM Release status append on item revision successfully");
						
						} else {
							System.err.println("TCM Release status is not append on item revision");
						}
					
					} else {
						System.err.println("Failed to Click on Submit Button");
					}
				
				} else {
					System.err.println("Failed to Select'TCM Release Process' template");
				}
				
			} else {
				System.err.println("Failed to Click on 'Submit To Workflow' Button");
			}
			
			}else {
				System.out.println("Failed to open item");
			}
} else {
		System.err.println("Failed to select "+ itemRevisionid +" item revision");
}
	} catch (Exception e) {
		
		System.err.println("Error");
		
	}

}	

}
