package com.test.awc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AwcPilot {
	//WebDriver driver;
	//String awcUrl = "http://swtc003:7003/awc/";	
	ReusableMethods objReuse = new ReusableMethods();
	
	AWCLoginPage objLogin = new AWCLoginPage(objReuse);
	AWCCreateItem objCreate = new AWCCreateItem(objReuse);
	AWCHomePage objHome = new AWCHomePage(objReuse);
	
@Test
public void AWC_loginCheck() {
		
		try {
			objLogin.loginAWC();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

}
@Test
public void AWC_createItemtypeItem() {
	
	try {		
		objLogin.loginAWC();
		objCreate.createItem("item");
	
	} catch (Exception e) {		
		e.printStackTrace();
	}

}	
@Test
public void AWC_initiateTCMReleaseworkflowOnitem() {
	
	try {
		String itemID;
		objLogin.loginAWC();
		itemID = objCreate.createItem("item");
		objHome.initiateWorkflow(itemID);

	} catch (Exception e) {		
		e.printStackTrace();
	}

}	
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  objHome.signOut();
	  objReuse.tearDownEnvironment();
  }

}
