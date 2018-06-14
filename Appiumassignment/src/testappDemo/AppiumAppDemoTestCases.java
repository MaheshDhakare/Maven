package testappDemo;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import testChromeAppiumDriver.ScriptforWebBrowser;

public class AppiumAppDemoTestCases
{

	ScriptforWebBrowser browser = new ScriptforWebBrowser();
	AppDemos_reusableMethods reuMthod = new AppDemos_reusableMethods();

@AfterMethod
public void setViewsActivity() {
		reuMthod.getViewsActivity();
		System.out.println();
		System.out.println("------------------------TestCaseEnd-------------------------");
		System.out.println();
}
@Test
public void Exercise01_Verify_navigate_By_3_Activities() throws InterruptedException {
	
	System.err.println("===== Exercise01_Verify_navigate_By_3_Activities =====");
	System.out.println();
	
	String activity_A = "App";
	String activity_B = "Action Bar";
	String activity_C = "Display Options";
			
	reuMthod.openappDemo();
	System.out.println("Opened AppDemo successfully");
	
	if (reuMthod.returnactivity(activity_A)) {
		
		reuMthod.clickOnactivity(activity_A);
		System.out.println("Opened '"+activity_A+"' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity(activity_B)) {
			
			reuMthod.clickOnactivity(activity_B);
			System.out.println("Opened '"+activity_B+"' activity successfully");			
			Thread.sleep(2000);	
			
			if (reuMthod.returnactivity(activity_C)) {
				
				reuMthod.clickOnactivity(activity_C);
				System.out.println("Opened '"+activity_C+"' activity successfully");			
					
			} else {
				System.out.println("Unable to find '"+activity_C+"' activity");
			}
			
		} else {
			System.out.println("Unable to find '"+activity_B+"' activity");
		}
		
	} else {
		System.out.println("Unable to find '"+activity_A+"' activity");
	}
	
	
}
@Test
public void Exercise02_Verify_scroll_activity_and_print_activity_list() throws InterruptedException {
	
	System.err.println("===== Exercise02_Verify_scroll_activity_and_print_activity_list =====");
	System.out.println();
	
	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
					System.out.println("Below is the list of items available under Views activity");
					
					System.out.println();
					reuMthod.getListofActivity();
				
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
	
	
}
@Test
public void Exercise03_Verify_On_Off_Button_after_and_before_toggle() throws InterruptedException {
		
	System.err.println("===== Exercise03_Verify_On_Off_Button_after_and_before_toggle =====");
	System.out.println();
	
		if (reuMthod.returnactivity("Views")) {
			
			reuMthod.clickOnactivity("Views");
			System.out.println("Opened 'Views' activity successfully");
			Thread.sleep(2000);
			
			if (reuMthod.returnactivity("Buttons")) {
				
				reuMthod.clickOnactivity("Buttons");
				System.out.println("Opened 'Buttons' activity successfully");
				
				Thread.sleep(2000);
				
				if (reuMthod.checkOnOffButton()) {
					
					WebElement onOffButton = reuMthod.findOnOffButton();
					System.out.println("Before toggle the value is " + "'"+onOffButton.getText()+"'");
					Thread.sleep(1000);
					onOffButton.click();
					Thread.sleep(1000);
					System.out.println("After toggle the value is " + "'"+onOffButton.getText()+"'");
				}
			
			} else {
				System.out.println("Unable to find Buttons activity");
			}
			
		} else {
			System.out.println("Unable to find Views activity");
		}
		
		
}
@Test
public void Exercise04_Verify_views_controls_lighttheme() throws InterruptedException {

	System.err.println("===== Exercise04_Verify_views_controls_lighttheme =====");
	System.out.println();

	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Controls")) {
			
			reuMthod.clickOnactivity("Controls");
			System.out.println("Opened 'Controls' activity successfully");			
			Thread.sleep(2000);
			
			if (reuMthod.returnactivity("1. Light Theme")) {
				
				reuMthod.clickOnactivity("1. Light Theme");
				System.out.println("Opened 'LightTheme' activity successfully");
				Thread.sleep(2000);
				
				if (reuMthod.checkTextbox()) {
					
					reuMthod.enterText("Testing");
					System.out.println("Enter text successfully");
					
					if (reuMthod.checkCheckBoxbutton()) {
						
						
						reuMthod.clickOncheckBox("Checkbox 1");
						System.out.println("Clicked checkBox 1 successfully");
						Thread.sleep(1000);
						reuMthod.clickOncheckBox("Checkbox 1");
						System.out.println("checkBox 1 uncheck successfully");
						
						reuMthod.clickOncheckBox("Checkbox 2");
						System.out.println("Clicked checkBox 2 successfully");
						
						if (reuMthod.checkRadiobutton()) {
							
							reuMthod.clickOnradioButton("RadioButton 1");
							System.out.println("Clicked RadioButton 1 successfully");
							
							reuMthod.clickOnradioButton("RadioButton 2");
							System.out.println("Clicked RadioButton 2 successfully");
							
							if (reuMthod.checkStarcheckBoxEle()) {
								
								reuMthod.checkStarcheckBox("Star");
								System.out.println("Clicked Star button successfully");
															
								
							} else {
								System.out.println("Unable to find Star button");
							}
							
						} else {
							System.out.println("Unable to find RadioButtons");
						}
						
					} else {
						System.out.println("Unable to find checkBoxes");
					}
					
				} else {
					System.out.println("Unable to find 'TextBox' field");
				}
			} else {
				System.out.println("Unable to find '1. Light Theme' activity");
			}		
			
		} else {
			System.out.println("Unable to find 'Controls' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
}
@Test
public void Exercise05_Verify_Views_expandableList_customAdapter() throws InterruptedException {

	System.err.println("===== Exercise05_Verify_Views_expandableList_customAdapter =====");
	System.out.println();
	
	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Expandable Lists")) {
			
			reuMthod.clickOnactivity("Expandable Lists");
			System.out.println("Opened 'Expandable Lists' activity successfully");			
			Thread.sleep(2000);	
			
			if (reuMthod.returnactivity("1. Custom Adapter")) {
				
				reuMthod.clickOnactivity("1. Custom Adapter");
				System.out.println("Opened 'Custom Adapter' activity successfully");			
				Thread.sleep(2000);
				System.out.println("Below is the list of People Name's");

				reuMthod.getListfromTextViewforPeoplenew();
							
				
			} else {
				System.out.println("Unable to find 'Custom Adapter' activity");
			}
			
		} else {
			System.out.println("Unable to find 'Expandable Lists' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
	
	
}
@Test
public void Exercise06_Verify_views_spinner() throws InterruptedException {
	
	System.err.println("===== Exercise06_Verify_views_spinner =====");
	System.out.println();
	
	By spinner = By.id("com.example.android.apis:id/spinner1");
	By colorElement = By.className("android.widget.CheckedTextView");
	String colur = "green";


	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Spinner")) {
			
			reuMthod.clickOnactivity("Spinner");
			System.out.println("Opened 'Spinner' activity successfully");
			
			Thread.sleep(2000);
			
			if (reuMthod.checkElementstatus(spinner)) {
				
				WebElement spinnerEle = reuMthod.getWebelement(spinner);

				Thread.sleep(1000);
				spinnerEle.click();
				Thread.sleep(1000);
				System.out.println("Below is list of color available");
				reuMthod.printListof(colorElement);
				Thread.sleep(1000);
				reuMthod.clickOn(colur,colorElement );
				System.out.println("Selecting " + colur + " color");
				Thread.sleep(1000);
				
				if (reuMthod.returnactivity(colur)) {
					System.out.println(colur + " is selected successfully");
				} else {
					System.out.println(colur + " is not selected successfully");
				}
		}
			
		} else {
			System.out.println("Unable to find 'Buttons' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
	
}
@Test
public void Exercise07_Verify_views_rotatingButton() throws InterruptedException {
	
	System.err.println("===== Exercise07_Verify_views_rotatingButton =====");
	System.out.println();
	
	By seekBarTX = By.id("translationX");
	By seekBarTY = By.id("translationY");
	By seekBarSX = By.id("scaleX");
	By seekBarSY = By.id("scaleY");

	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Rotating Button")) {
			
			reuMthod.clickOnactivity("Rotating Button");
			System.out.println("Opened 'Rotating Button' activity successfully");
			System.out.println();
			
			Thread.sleep(2000);
//assignment 7.a			
			System.out.println("Below are the values of 'Rotating Button' before moving seekbar values:");			
			reuMthod.rotatingBtnvalues_getSize();
			reuMthod.rotatingBtnvalues_XandY();
			reuMthod.rotatingBtnvalues_HightandWidth();
			System.out.println();
			
//assignment 7.b			
			reuMthod.moveSeekbar(seekBarTX, "150");			
			System.out.println("Below are the values of 'Rotating Button' after moving seekbar TX:");
			reuMthod.rotatingBtnvalues_XandY();
			System.out.println();
			
//assignment 7.c			
			reuMthod.moveSeekbar(seekBarTY, "150");			
			System.out.println("Below are the values of 'Rotating Button' after moving seekbar TY:");
			reuMthod.rotatingBtnvalues_XandY();
			System.out.println();
			
//assignment 7.d			
			reuMthod.moveSeekbar(seekBarSX, "25");				
			System.out.println("Below are the values of 'Rotating Button' after moving seekbar SX:");
			reuMthod.rotatingBtnvalues_HightandWidth();
			System.out.println();
			
//assignment 7.e			
			reuMthod.moveSeekbar(seekBarSY, "25");			
			System.out.println("Below are the values of 'Rotating Button' after moving seekbar SY:");
			reuMthod.rotatingBtnvalues_HightandWidth();
			
		} else {
			System.out.println("Unable to find 'RotatingButton' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
	
}
@Test
public void Exercise08_Verify_layouts_scrollView_Long() throws InterruptedException {
	
	System.err.println("===== Exercise08_Verify_layouts_scrollView_Long =====");
	System.out.println();
	
	By buttons = By.className("android.widget.Button");

	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Layouts")) {
			
			reuMthod.clickOnactivity("Layouts");
			System.out.println("Opened 'Layouts' activity successfully");			
			Thread.sleep(2000);	
			
			if (reuMthod.returnactivity("ScrollView")) {
				
				reuMthod.clickOnactivity("ScrollView");
				System.out.println("Opened 'ScrollView' activity successfully");			
				Thread.sleep(2000);
				
				if (reuMthod.returnactivity("2. Long")) {
					
					reuMthod.clickOnactivity("2. Long");
					System.out.println("Opened 'Long' activity successfully");			
					Thread.sleep(2000);
					
					System.out.println("Below is the list of buttons available under long activity");
					
					reuMthod.printListwithSwapenew(buttons);
			
				} else {
					System.out.println("Unable to find 'Long' activity");
				}
			} else {
				System.out.println("Unable to find 'ScrollView' activity");
			}
			
		} else {
			System.out.println("Unable to find 'Layouts' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
	
	
}
@Test
public void Exercise09_Verify_views_textClock() throws InterruptedException {

	System.err.println("===== Exercise09_Verify_views_textClock =====");
	System.out.println();
	
	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Text")) {
			
			reuMthod.clickOnactivity("Text");
			System.out.println("Opened 'Text' activity successfully");
			
			Thread.sleep(2000);
		
			
			if (reuMthod.returnactivity("TextClock")) {
				
				reuMthod.clickOnactivity("TextClock");
				System.out.println("Opened 'TextClock' activity successfully");
				Thread.sleep(1000);
				reuMthod.printListofTextView("TextClock");

			} else {
				System.out.println("Unable to find 'TextClock' activity");
			}
			
		} else {
			System.out.println("Unable to find 'Text' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
}
@Test
public void Exercise10_Verify_views_visibility() throws InterruptedException {

	System.err.println("===== Exercise10_Verify_views_visibility =====");
	System.out.println();
	
	if (reuMthod.returnactivity("Views")) {
		
		reuMthod.clickOnactivity("Views");
		System.out.println("Opened 'Views' activity successfully");
		Thread.sleep(2000);
		
		if (reuMthod.returnactivity("Visibility")) {
			
			reuMthod.clickOnactivity("Visibility");
			System.out.println("Opened 'Visibility' activity successfully");
			System.out.println("------------------------------------------------------------------");
			Thread.sleep(2000);
			
			if (reuMthod.checkbutton("INVIS")) {
				
				reuMthod.clickOnbutton("INVIS");
//assignment 10.a			
				List<WebElement> listOftextView = reuMthod.getListOftextView();
				int Cnt = 0;				
					if (reuMthod.verifyIFvalueIspresentInArray(listOftextView, "View B")) {						
						Cnt++;						
					}
					if (Cnt == 0) {
					System.out.println("View B is invisible after clicking on INVIS button");
					
				}else {					
					System.out.println("Failed to get the expected result, View B should not be available after clicking on INVIS button");
				}
				System.out.println("------------------------------------------------------------------");
				Thread.sleep(2000);
//assignment 10.b					
				reuMthod.clickOnbutton("VIS");
				Thread.sleep(2000);
				List<WebElement> listOftextView2 = reuMthod.getListOftextView();
				int Cnt2 = 0;				
					if (reuMthod.verifyIFvalueIspresentInArray(listOftextView2, "View B")) {
							Cnt2++;						
					}
					if (Cnt2 == 0) {
						System.out.println("Failed to get the expected result, View B should be available after clicking on VIS button");
						
					}else {					
						System.out.println("View B is visible after clicking on VIS button");
					}
				System.out.println("------------------------------------------------------------------");
				Thread.sleep(2000);
//assignment 10.c			
				reuMthod.clickOnbutton("GONE");
				Thread.sleep(2000);
				List<WebElement> listOftextView1 = reuMthod.getListOftextView();
				int Cnt1 = 0;
				
					if (reuMthod.verifyIFvalueIspresentInArray(listOftextView1, "View B")) {
						Cnt1++;	
					}
					if (Cnt1 == 0) {
						System.out.println("View B value is gone after clicking on GONE button");
						
					}else {					
						System.out.println("Failed to get the expected result, View B should not be available after clicking on GONE button");
					}
				System.out.println("------------------------------------------------------------------");
				Thread.sleep(2000);	
//assignment 10.d					
				reuMthod.clickOnbutton("VIS");
				Thread.sleep(2000);
				List<WebElement> listOftextView3 = reuMthod.getListOftextView();
				int Cnt3 = 0;				
					if (reuMthod.verifyIFvalueIspresentInArray(listOftextView3, "View B")) {
							Cnt3++;						
					}
					if (Cnt3 == 0) {
						System.out.println("Failed to get the expected result, View B should be available after clicking on VIS button");
						
					}else {					
						System.out.println("View B is visible after clicking on VIS button");
					}

			} else {
				System.out.println("Unable to find 'VIS' button");
			}
		} else {
			System.out.println("Unable to find 'Visibility' activity");
		}
		
	} else {
		System.out.println("Unable to find 'Views' activity");
	}
}

}