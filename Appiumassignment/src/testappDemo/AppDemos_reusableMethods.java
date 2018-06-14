package testappDemo;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Position;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppDemos_reusableMethods {

	@SuppressWarnings("rawtypes")
	static AppiumDriver driver;

	By activities = By.className("android.widget.TextView");
	By onOffbuttonEle = By.className("android.widget.ToggleButton");
	By button = By.className("android.widget.Button");
	By edittext = By.className("android.widget.EditText");
	By checkBox = By.className("android.widget.CheckBox");
	By radioButton = By.className("android.widget.RadioButton");
	By starCheckbox = By.className("android.widget.CheckBox");
	By rotatingButton = By.id("rotatingButton");
	
	
public void moveSeekbar(By seekBar,String movementValue ) throws InterruptedException {
	
	WebElement seekbarTX = driver.findElement(seekBar);
		
	Thread.sleep(2000);
	
	seekbarTX.sendKeys(movementValue);
	
	Thread.sleep(2000);

}	
public void rotatingBtnvalues_XandY() throws InterruptedException {
	
WebElement rotatingBtn_XandY = driver.findElement(rotatingButton);
	
	int rotatingBtn_x = rotatingBtn_XandY.getLocation().getX();
	int rotatingBtn_y = rotatingBtn_XandY.getLocation().getY();
	
System.out.println("> The X value of Rotation Button is-"+rotatingBtn_x);
System.out.println("> The X value of Rotation Button is-"+rotatingBtn_y);

}	
public void rotatingBtnvalues_HightandWidth() throws InterruptedException {
	
WebElement rotatingBtn_HightandWidth = driver.findElement(rotatingButton);

	int rotatingBtn_width = rotatingBtn_HightandWidth.getSize().width;
	int rotatingBtn_height = rotatingBtn_HightandWidth.getSize().height;

System.out.println("> The width value of Rotation Button is-"+rotatingBtn_width);
System.out.println("> The height value of Rotation Button is-"+rotatingBtn_height);

}

public void rotatingBtnvalues_getSize() throws InterruptedException {
	
WebElement rotatingBtn_size = driver.findElement(rotatingButton);

	Dimension rotatingBtnsize = rotatingBtn_size.getSize();

	System.out.println("> The size of Rotation Button is-"+rotatingBtnsize);

}
public void enterText(String TextValue) {
		
		try {
			Thread.sleep(2000);
			List<WebElement> textBoxs = driver.findElements(edittext);
					
			for (WebElement textBox : textBoxs) {
				textBox.sendKeys(TextValue);
			}			
			
		} catch (Exception e) {
			System.out.println("Unable to find TextBox");
		}
	}
public boolean checkTextbox() {

	try {			
		WebElement textBox = driver.findElement(edittext);
		return true;
		
	} catch (Exception e) {
		
		System.out.println("Unable to find On Off button");
		return false;
	}

}
public boolean checkStarcheckBoxEle() {

	try {			
		WebElement textBox = driver.findElement(starCheckbox);
		return true;
		
	} catch (Exception e) {
		
		System.out.println("Unable to find On Off button");
		return false;
	}

}
public void checkStarcheckBox(String checkBoxValue) {
	
		try {
			Thread.sleep(2000);
			List<WebElement> elements = driver.findElements(starCheckbox);
					
			for (WebElement checkBox : elements) {
				
				if (checkBox.getText().contains(checkBoxValue)) {
					
				System.out.println("Star CheckBox checked value is "+"'"+checkBox.getAttribute("checked")+"'");
				
				checkBox.click();
				
				System.out.println("After clicking Star CheckBox checked value is "+"'"+checkBox.getAttribute("checked")+"'");
				
				}
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}	
public WebElement getWebelement(By webElement) {

		WebElement element = null ;

		try {			
			element = driver.findElement(webElement);
			return element;
			
		} catch (Exception e) {
			
			System.out.println("Unable to find On Off button");
			return null;
		}
	}
public boolean checkElementstatus(By webElement) {

	try {			
		driver.findElement(webElement);
		return true;
		
	} catch (Exception e) {
		
		System.out.println("Unable to find "+webElement);
		return false;
	}

}
public WebElement findOnOffButton() {

	WebElement element = null ;

	try {			
		element = driver.findElement(onOffbuttonEle);
		return element;
		
	} catch (Exception e) {
		
		System.out.println("Unable to find On Off button");
		return null;
	}


}
public boolean checkOnOffButton() {

	try {			
		WebElement onOffbutton = driver.findElement(onOffbuttonEle);
		return true;
		
	} catch (Exception e) {
		
		System.out.println("Unable to find On Off button");
		return false;
	}

}	
public boolean checkbutton(String buttonName) {

	try {			
		List<WebElement> findElementsByClassName = driver.findElements(button);
		
		for (WebElement webElement : findElementsByClassName) {
			if (webElement.getText().contains(buttonName)) {
				return true;
				
			}
		}	
		return true;
	}
		catch (Exception e) {
		
		System.out.println("Unable to find On Off button");
		return false;
	}
	}
public boolean checkRadiobutton() {

		try {			
			WebElement onOffbutton = driver.findElement(radioButton);
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Unable to find On Off button");
			return false;
		}

}public boolean checkCheckBoxbutton() {

	try {			
		WebElement onOffbutton = driver.findElement(checkBox);
		return true;
		
	} catch (Exception e) {
		
		System.out.println("Unable to find On Off button");
		return false;
	}

}
public void clickOncheckBox(String checkBoxname) {
	try {
		Thread.sleep(2000);
		List<WebElement> listOfbuttons = driver.findElements(checkBox);
		
		for (WebElement button : listOfbuttons) {
			
			if (button.getText().contains(checkBoxname)) {				
				button.click();		
			}
		}		
	} catch (Exception e) {
		
		System.out.println("Unable to find "+checkBoxname+" button");
	}
}
public void clickOnradioButton(String radioButtonname) {
	try {
		Thread.sleep(2000);
		List<WebElement> listOfbuttons = driver.findElements(radioButton);
		
		for (WebElement button : listOfbuttons) {
			
			if (button.getText().contains(radioButtonname)) {				
				button.click();	
				
			}
		}		
	} catch (Exception e) {
		
		System.out.println("Unable to find "+radioButtonname+" button");
	}
}
public boolean verifyIFvalueIspresentInArray(String[] elements, String verificationValue) {

	boolean flg = false;
	try {
		
		int size23 = elements.length;
		
		for (int i = 0; i <size23; i++) {
			if (elements[i].equals(verificationValue)) {
				flg = true;
			} else {
				//Do Nothing
			}
		}
return flg;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return flg;
	}	

}

public boolean verifyIFvalueIspresentInArray(List<WebElement> elements, String verificationValue) {

	boolean flg = false;
	try {
		
		int size23 = elements.size();
		
		for (int i = 0; i <size23; i++) {
			if (elements.get(i).getText().contains(verificationValue)) {
				flg = true;
			} else {
				//Do Nothing
			}
		}
return flg;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return flg;
	}	

}
public void clickOnbutton(String buttonName) {
		try {

			List<WebElement> listOfbuttons = driver.findElements(button);

			for (WebElement button : listOfbuttons) {

				if (button.getText().contains(buttonName)) {
					button.click();
					break;
				} else {
//					System.out.println("Unable to click on " + buttonName+ " button");
				}
			}
		} catch (Exception e) {

			System.out.println("Unable to find " + buttonName + " button");
		}
	}
public void clickOn(String valueName, By webElement) {
	try {

		List<WebElement> listOfbuttons = driver.findElements(webElement);

		for (WebElement button : listOfbuttons) {

			if (button.getText().contains(valueName)) {
				button.click();
				break;
			} 
		}
	} catch (Exception e) {

		System.out.println("Unable to find " + valueName);
	}
}
@SuppressWarnings("rawtypes")
public void openappDemo() {

		DesiredCapabilities Capabilites = new DesiredCapabilities();

		Capabilites.setCapability("device", "Android");
		Capabilites.setCapability("platformVersion", "7.1.1");
		Capabilites.setCapability("deviceName", "emulator-5554");
		Capabilites.setCapability("automationName", "UiAutomator2");
		Capabilites.setCapability("platformName", "Android");
		Capabilites.setCapability("appPackage", "com.example.android.apis");
		Capabilites.setCapability("appActivity",
				"com.example.android.apis.ApiDemos");

		try {
			driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),
					Capabilites);

		} catch (MalformedURLException e) {

			System.out.println("Unable to set appium driver");

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
public void clickOnactivity(String activityName) {
	
	boolean flgfount = false;
//	WebDriverWait wait = new WebDriverWait(driver, 5);
	while (!flgfount) {
		List<WebElement> findElementsByClassName = driver.findElements(activities);

		for (WebElement eleTextView : findElementsByClassName)
		{
			if (eleTextView.getText().equals(activityName)) {
//				wait.until(ExpectedConditions.visibilityOf(eleTextView));
				eleTextView.click();
				flgfount = true;
				break;
			}			
		}
		if (!flgfount) {
			swapePage();
		}
	}
}
public void getViewsActivity() {
	
	
	boolean flgfount = false;
	while (!flgfount) {
		driver.navigate().back();
		List<WebElement> findElementsByClassName = driver.findElements(activities);

		for (WebElement eleTextView : findElementsByClassName)
		{
			if (eleTextView.getText().equals("Views")) {
				flgfount = true;
				break;
			}			
		}
		if (!flgfount) {
			swapePage();
		}
	}

}
public void getListofActivity() {

String[] array = new String[100];
int Cnt =0;
String refNull = "null";
	boolean flgfount = false;
//	WebDriverWait wait = new WebDriverWait(driver, 5);
	while (!flgfount) {
		List<WebElement> findElementsByClassName = driver.findElements(activities);

		for (WebElement eleTextView : findElementsByClassName)
		{
			if (!eleTextView.getText().contains("API Demos")) {
				
				array[Cnt] = eleTextView.getText();
				Cnt++;
				System.out.println("> "+eleTextView.getText());
				
				if (eleTextView.getText().contains("WebView")) {
					flgfount = true;
					break;
				}
			}
			
		}
		if (!flgfount) {
			swapePage();
		}
	}
	for (int counter1 = 0; counter1 < Cnt; counter1++) {
		for (int counter2 = counter1+1; counter2 < Cnt; counter2++) {
			
			if (array[counter1].equals(array[counter2]))
			{
				array[counter2] = refNull;
			}
		}
	}	
String[] newArray = Arrays.copyOf(array, Cnt);
	 for (String string : newArray) {
		
		if (!string.equalsIgnoreCase("null")) {
			
			System.out.println("> "+string);
		}
	}

}
public void getListfromTextViewforPeople() throws InterruptedException {
	
int num = 0;	
int num1 = 0;

		List<WebElement> findElementsByClassName = driver.findElements(activities);
		
		int sizeOfvalues = findElementsByClassName.size();
		
//		System.out.println("The size is " + sizeOfvalues);
		
		String listOfTextView[] =  new String[sizeOfvalues-1];

		for (int i = 1; i < sizeOfvalues; i++) {
			listOfTextView[num] = findElementsByClassName.get(i).getText();
			num++;
			}
				for (String string1 : listOfTextView) {
//						System.out.println("First for loop"+string1);
					}
			clickOnactivity("People Names");
			Thread.sleep(5000);
			
//			System.out.println("111111111111111111");	
		List<WebElement> findElementsByClassNamenew = driver.findElements(activities);
		
//		System.out.println("111111111111111111");
		
		int sizeOfvaluesnew = findElementsByClassNamenew.size();
		
//		System.out.println("The size after click is " + sizeOfvaluesnew);
		
		String listOfTextViewnew[] =  new String[sizeOfvaluesnew-1];
		
		for (int i = 1; i < sizeOfvaluesnew; i++) {
			listOfTextViewnew[num1] = findElementsByClassNamenew.get(i).getText();
			num1++;
			}
				for (String string2 : listOfTextViewnew) {
//						System.out.println("Second for loop"+string2);
					}
//			int sizeOfvalues1 = findElementsByClassNamenew.size();	
			
			
			for (int i1 = 1; i1 < sizeOfvalues; i1++)
			
				for (int i2 = 1; i2 < sizeOfvaluesnew; i2++) {
					
					if (!(listOfTextViewnew[i1].equals(listOfTextView[i2]))) {
						System.out.println(listOfTextViewnew[i1]);
						break;
					}
				
			}

}
public void getListfromTextViewforPeoplenew() throws InterruptedException {

String[] name;
int num = 0;
String[] name1;
int num1 = 0;
			List<WebElement> findElementsByClassName = driver.findElements(activities);
			int size = findElementsByClassName.size();
			name = new String[size];
			
			for (WebElement webElement : findElementsByClassName) {
				name[num] = webElement.getText();
				num++;
//				System.out.println("1."+ webElement.getText());
			}
			Thread.sleep(2000);
			clickOnactivity("People Names");
			Thread.sleep(2000);
			List<WebElement> findElementsByClassName1 = driver.findElements(activities);
			int size1 = findElementsByClassName1.size();
			name1 = new String[size1];
			
			for (WebElement webElement : findElementsByClassName1) {
				name1[num1] = webElement.getText();
				num1++;
//				System.out.println("2."+ webElement.getText());
			}
			
			for (String nameArray : name) {
//				System.out.println("nameArray - "+nameArray);
			}
			for (String nameArray1 : name1) {
//				System.out.println("nameArray1 - "+nameArray1);
			}
			for (int i = 0; i < size1; i++) {
//				System.out.println("testfor loop");
				if (verifyIFvalueIspresentInArray(name,name1[i])) {
					//Do Nothing
					
				} else {
					System.out.println("> "+name1[i]);
				}
			}

	
}
public void printListof(By webElement) throws InterruptedException {

 try {
	List<WebElement> findElementsByClassNamenew = driver.findElements(webElement);
		
	for (WebElement webElementlist : findElementsByClassNamenew) {
		System.out.println("   > "+webElementlist.getText());
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public List<WebElement> getListOftextView() {

	 try {
		List<WebElement> findElementsByClassNamenew = driver.findElements(activities);
			
		return findElementsByClassNamenew;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return  null;
	}


}public void printListofTextView(String textValue) {

	 try {
		List<WebElement> findElementsByClassNamenew = driver.findElements(activities);
			
		for (WebElement webElementlist : findElementsByClassNamenew) {
			
			if (!webElementlist.getText().contains(textValue)) {
				
				System.out.println(" > "+webElementlist.getText());
			}
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}
public void printListwithSwapeold(By activityName) {
	
	boolean flgfount = false;
	String array[] = new String[100];
	int Cnt = 0;
	String ref = "Test";
	
	while (!flgfount) {
		
		List<WebElement> findElementsByClassName = driver.findElements(activityName);
		
		int size = findElementsByClassName.size();
		
		swapePage();
		
		if (findElementsByClassName.get(0).getText().equalsIgnoreCase(ref)) {
//			System.out.println("I am inside if condition");
			flgfount = true;
			break;
		} else {

			for (int i = 0; i < size; i++) {	
				array[Cnt] = findElementsByClassName.get(i).getText();
//				System.out.println("------" + array[Cnt]);
				Cnt++;
				}
			ref = findElementsByClassName.get(0).getText();
//			System.out.println("The respective ref value is - " + ref);
		}
	
	}
//	System.out.println(Cnt);
	int refCnt = 0;
	String refNull = "null";
	String[] newArray = Arrays.copyOf(array, Cnt);
	
	 
	 for (int counter1 = 0; counter1 < Cnt; counter1++) {
		for (int counter2 = counter1+1; counter2 < Cnt; counter2++) {
			
			if (newArray[counter1].equals(newArray[counter2]))
			{
//				System.out.println("Test-------------"+newArray[counter2]);
				newArray[counter2] = refNull;
				refCnt++;
			}
		}
	}	
	
//	 int newCnt = Cnt-refCnt;
//	 System.out.println(newCnt);
//	 String[] finalArray = Arrays.copyOf(newArray, newCnt);
	 
	 for (String string : newArray) {
		
		if (!string.contains("null")) {
			
			System.out.println(string);
		}
		
	}
//	int abc = 100;
//String  ref1 = "";	
//	for (int i = 0; i < abc; i++) {
//		for (int j = i+1; j < abc; j++) {
//			if (newArray[1] == newArray[j]) {
//				
//				ref1  = newArray[abc-1];
//				newArray[j]= newArray[abc-1];
//				newArray[j]= ref1;
//				
//				Cnt--;
//				System.out.println("---------------"+ newArray[j]);
//			}
//		}
//	}
//	String[] newArray1 = Arrays.copyOf(newArray, Cnt);
//	
//	List<String> tmpList = Arrays.asList(newArray);
//    
//    TreeSet<String> unique = new TreeSet<String>(tmpList);
//    System.out.println(unique);
//    
//    for (String string : tmpList) {
//    	
//    	System.out.println(string);
//    }
//	List<String> list = Arrays.asList(newArray);
//    Set<String> set = new HashSet<String>(list);
//
//    System.out.print("Remove duplicate result: ");
//
//    String[] result = new String[set.size()];
//    set.toArray(result);
//    for (String s : result) {
//      System.out.print(s);
//      System.out.println();
//    }
}   
public void printListwithSwapenew(By activityName) throws InterruptedException {
			
	boolean flgfount = false;
	String array[] = new String[100];
	int Cnt = 0;
	String ref = "Test";
			
while (!flgfount) {
				
				List<WebElement> findElementsByClassName = driver.findElements(activityName);
				
				int size = findElementsByClassName.size();
				Thread.sleep(2000);
				
				swapePage();
				Thread.sleep(2000);
				if (findElementsByClassName.get(0).getText().equalsIgnoreCase(ref)) {

					flgfount = true;
					break;
					
					} else {
					
						for (int i = 0; i < size; i++) {	
						array[Cnt] = findElementsByClassName.get(i).getText();

						Cnt++;
						}
					ref = findElementsByClassName.get(0).getText();
				}
			}
		

			String refNull = "null";
			String[] newArray = Arrays.copyOf(array, Cnt);
			
			 for (int counter1 = 0; counter1 < Cnt; counter1++) {
				for (int counter2 = counter1+1; counter2 < Cnt; counter2++) {
					
					if (newArray[counter1].equals(newArray[counter2]))
					{
						newArray[counter2] = refNull;
					}
				}
			}	
 
			 for (String string : newArray) {
				
				if (!string.contains("null")) {
					
					System.out.println("> "+string);
				}
			}
		}

public Boolean returnactivity(String activityName) {
	
	boolean activityEle = false;	

	boolean flgfount = false;

	while (!flgfount) {

		List<WebElement> findElementsByClassName = driver.findElements(activities);

		
		for (WebElement activity : findElementsByClassName)
		{
			
			if (activity.getText().equals(activityName)) {
				
				flgfount = true;
				
				activityEle = true;			
				
			}
			
		}
		if (!flgfount) {
			swapePage();
		}
	}
	return activityEle;
	
	
	
	}
public void swapePage() {
	
	int yStart = (int)(driver.manage().window().getSize().getHeight()* 0.99);
	int yEnd = (int)(driver.manage().window().getSize().getHeight()* 0.01);
	int xPos = (int)(driver.manage().window().getSize().getWidth()*0.5);
	
	
	TouchAction action = new TouchAction((PerformsTouchActions)driver);
	action
	.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(xPos, yStart)))
	.moveTo(PointOption.point(xPos, yEnd))
	.release()
	.perform();
	}
public void back() {
	try {
		Thread.sleep(2000);
		driver.navigate().back();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
public void waitFor(int timeInsec) {
	try {
		driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
	} catch (Exception e) {
		
	}
}
public void driverQuit() {
		try {
			driver.quit();
		} catch (Exception e) {
			
		}}
}
