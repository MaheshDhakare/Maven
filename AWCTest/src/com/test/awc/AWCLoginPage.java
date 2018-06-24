package com.test.awc;

import org.openqa.selenium.By;


public class AWCLoginPage {
	
	private ReusableMethods objReusable;
	
	public AWCLoginPage(ReusableMethods objReuse) {
		objReusable=objReuse;
	}
	
	By tagTeamcenter = By.xpath("//h1[contains(text(),'TEAMCENTER')]");
	By userName = By.id("gwt-debug-textBox_userName");
	By userPassword = By.id("gwt-debug-textBox_password");
	By loginButton = By.id("gwt-debug-button_login");
	By homeFolder = By.xpath("//div[contains(text(),'Home Folder')]");

public void loginAWC() {
	
	if(objReusable.setUpEnvironment()) {
		System.out.println("> Environment load successful");
		
	if (objReusable.getURL()) {
		
		if (objReusable.checkElementDisplayed(tagTeamcenter)) {
			
			System.out.println("> Launched Teamcenter successfully");
			
			if (objReusable.setText(userName, objReusable.getConfigvalue("userName"))) {
				
				System.out.println("> Entered " + objReusable.getConfigvalue("userName") + " userNamesuccessfully");
				
				if (objReusable.setText(userPassword, objReusable.getConfigvalue("userPassword"))) {
					
					System.out.println("> Entered " + objReusable.getConfigvalue("userPassword") + " userPassword successfully");
					
					if (objReusable.click(loginButton)) {
						
						System.out.println("> Clicked on login button successfully");
						
						if (objReusable.checkElementDisplayed(homeFolder)) {
							
							System.out.println("> Home Folder opened successfully");
						
						} else {
							System.err.println("unable to find "+homeFolder+" element");
						}
					
					} else {
						System.err.println("Unable to click on login button");
					}
					
				} else {					
					System.err.println("Unable to enter user password");
				}
				
			} else {				
				System.err.println("Unable to enter user name");
			}
			
		} else {			
			System.err.println("Unable to launch Teamcenter");
		}		
		
	} else {
		System.err.println("Unable to open URL");
	}
	
}
	else {
		System.err.println("Unable to load the driver");
	}
}
	

}
