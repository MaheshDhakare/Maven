package forNeha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class All_Com_Reuseable_Methods {

	FileInputStream fileInput;
	static By frame = By.xpath("//iframe[@id = 'by2Frame']");
	static WebDriverWait wait;
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	XSSFRow row;
	XSSFCell cell;
	WebDriver driver;
	String cellValue = "";
	String issueID = "";
	String alertURL;
	String priority = "";
	static String newIssueidString;
	By uName = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//button[contains(text(), 'Login')]");
	By reportIsstab = By.xpath("//a[contains(text(), 'Report Issue')]");
	By viewIsstab = By.xpath("//a[contains(text(), 'View Issue')]");
	By summarytab = By.xpath("//a[contains(text(), 'Summary')]");
	By selectReproducibility = By.xpath("//select[@name='reproducibility']");
	By selectSeverity = By.xpath("//select[@name='severity']");
	By selectPriority = By.xpath("//select[@name='priority']");
	By selectCategory = By.xpath("//select[@name='category_id']");
	By selectAssignTo = By.xpath("//select[@name='handler_id']");
	By summary = By.xpath("//input[@name='summary']");
	By description = By.xpath("//textarea[@name='description']");
	By reportStay_Button = By.xpath("//input[@name='report_stay']");
	By viewStatus_Button = By.xpath("//input[@name='view_state']");
	By submitButton = By.xpath("//input[@class='button']");
	By viewSubmittedIssueLink = By.xpath("//a[contains(text(), 'View Submitted Issue')]");
	By lnkTxt = By.xpath("//a[contains(text(), 'Submitted')]");
	By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");
	By verifyCurrectIssueOpened = By
			.xpath("//td[contains(text(), 'Summary')]/following-sibling::td[contains(text(), '" + issueID + "')]");
	By verifyPriority = By
			.xpath("//td[contains(text(), 'Priority')]/following-sibling::td[contains(text(), '" + priority + "')]");
	By verifySeverity = By.xpath("//td[contains(text(), 'Severity')]/following-sibling::td[1]");
	By editButton = By.xpath("//input[@value = 'Edit']");
	By backLink = By.xpath("//a[contains(text(), 'Back To Issue')]");
	By editSeverity = By.xpath("//select[@name = 'severity']");
	By updateInformationButton = By.xpath("//input[@value= 'Update Information']");
	By issueIDInSummarytable = By.xpath("//a[contains(text(), '" + issueID + "')]");
	By viewIssueTabValidation = By.xpath("//table[@id = 'buglist']/descendant::span[contains(text(), 'Viewing')]");
	By viewIssueOperation = By.xpath("//select[@name = 'action']");
	By viewIssueOkButton = By.xpath("//input[@value = 'OK']");
	By updatePriorityButton = By.xpath("//input[@value = 'Update Priority']");

	public void LoginToMantis(String URL, String UserName, String Password) {

		driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get(URL);

		if (validedWebElement(uName)) {

			driver.findElement(uName).sendKeys(UserName);

			if (validedWebElement(password)) {

				driver.findElement(password).sendKeys(Password);

				if (validedWebElement(loginButton)) {

					clickOn(loginButton);

				} else {
					System.out.println("Unable to find Login button");
				}

			} else {
				System.out.println("Unable to find Password webelement");
			}

		} else {
			System.out.println("Unable to find UserName webelement");
		}

	}
	public void getURL(String URL) {

		driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public Alert acceptAlert() {

		 Alert alert = driver.switchTo().alert();
		 return alert;

	}
	
	
	public boolean validedWebElement(By webElement) {

		try {
			driver.findElement(webElement);

			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public WebElement getWebElement(By webElement) {

		WebElement findElement = null;

		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
			WebElement findElement1 = driver.findElement(webElement);
			
			return findElement1;

		} catch (Exception e) {
			System.out.println("No such element found");
		}
		return findElement;

	}
	public void switchToframe () {


		try {
			driver.switchTo().frame(getWebElement(frame));
		

		} catch (Exception e) {
			System.out.println("No switch");
		}
		

	}
	public List<WebElement> getWebElements(By webElement) {

		List<WebElement> elements = null;

		try {
			List<WebElement> findElements = driver.findElements(webElement);
			return findElements;

		} catch (Exception e) {
			System.out.println("No such element found");
		}
		return elements;

	}

	public boolean selectDropdownFromExcel(By webElement, int rowNum, int cellNum) {

		try {
			Select select = new Select(driver.findElement(webElement));
			select.selectByVisibleText(getCellvalue(rowNum, cellNum));
		

			return true;
		} catch (Exception e) {

			System.out.println("Unable to find" + getCellvalue(rowNum, cellNum) + " in the dropdown");

			return false;
		}
	}

	public boolean selectDropdown(By webElement, String value) {

		try {
			Select select = new Select(driver.findElement(webElement));
			select.selectByVisibleText(value);

			return true;
		} catch (Exception e) {

			System.out.println("Unable to find" + value + " in the dropdown");

			return false;
		}
	}

	public boolean verifyDropdownValue(By webElement, String verificationValue) {

		boolean flg = false;

		try {
			Select select = new Select(driver.findElement(webElement));
			List<WebElement> dropdownList = select.getOptions();
			int numOfvaluesIndropdownze = dropdownList.size();

			for (int i = 0; i < numOfvaluesIndropdownze; i++) {
				String dropdownValue = dropdownList.get(i).getText().toLowerCase();

				if (dropdownValue.contains(verificationValue.toLowerCase())) {

					flg = true;
				} else {

				}
			}
			return flg;
		} catch (Exception e) {

			System.out.println("Dropdown webelement is not found");

			return flg;
		}
	}

	public boolean selectRadioButton(String radioButtonname) {

		try {

			WebElement radioButton = driver
					.findElement(By.xpath("//label[contains(text(), '" + radioButtonname + "')]"));

			System.out.println("The value of dropdown is " + radioButtonname);
			radioButton.click();

			return true;
		} catch (Exception e) {
			System.out.println("Unable to find" + radioButtonname);
			return false;
		}
	}

	public void refreash() {

		try {

			driver.navigate().refresh();

		} catch (Exception e) {

		}
	}

	public boolean setText(By webElement, int rowNum, int cellNum) {

		try {
			driver.findElement(webElement).sendKeys(getCellvalue(rowNum, cellNum).trim());

			return true;
		} catch (Exception e) {
			System.out.println("Unable to set" + getCellvalue(rowNum, cellNum) + " in the filed");
			return false;
		}
	}

	public boolean clickOn(By webElement) {

		try {
			driver.findElement(webElement).click();

			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public void getAllOptions(String dropDownvalue) {

		WebElement reportIsstab = driver.findElement(By.partialLinkText("Report I"));
		reportIsstab.click();

		Select selectdropDownvalue = new Select(driver.findElement(By.name(dropDownvalue)));
		List<WebElement> list = selectdropDownvalue.getOptions();
		System.out.println("Below are the list of option available under " + dropDownvalue+ " : ");
		for (int i = 0; i < list.size(); i++) {

			System.out.println(i + 1 + ". " + list.get(i).getText());
		}

	}

	public void LogOut() {
		driver.findElement(By.partialLinkText("Logout")).click();
		driver.close();
	}

	public void closeBrowser() {

		driver.close();
	}

	public void ReadExcel(String excelPath, String sheetName) {

		try {
			fileInput = new FileInputStream(excelPath);

			workBook = new XSSFWorkbook(fileInput);

			workSheet = workBook.getSheet(sheetName);

		} catch (FileNotFoundException e) {

			System.out.println("Mentioned file is not avaiable at desired location");
		} catch (IOException e) {

			System.out.println("Required workbook is not created");

		}
		try {
			fileInput.close();
		} catch (IOException e) {
			System.out.println("Failed closing excel file");
		}

	}

	public int getRowcnt() {
		int rowCnt = 0;

		try {
			rowCnt = workSheet.getLastRowNum() - workSheet.getFirstRowNum();

		} catch (Exception e) {

			System.out.println("Cell value is null");
		}
		return rowCnt;

	}

	public String getCellvalue(int rowNum, int cellNum) {
		String cellValue = "";

		try {
			row = workSheet.getRow(rowNum);

			cell = row.getCell(cellNum);

			cellValue = cell.getStringCellValue();
			

		} catch (Exception e) {

			// System.out.println("Cell value is null");
			cellValue = null;
		}
		return cellValue;

	}
	public String getNumricCellvalue(int rowNum, int cellNum) {
		double cellValue = 0;
		String CellValueN = null;
		

		try {
			row = workSheet.getRow(rowNum);

			cell = row.getCell(cellNum);

			cellValue = cell.getNumericCellValue();
			long x = (long)cellValue;
			CellValueN = String.valueOf(x);
			return CellValueN;

		} catch (Exception e) {

			System.out.println("Cell value is null");
			
		}
		return CellValueN;

	}
	public String[] getDropdownvalueInArray(String dropdownAttribute) {

		int totalRow = workSheet.getLastRowNum() - workSheet.getFirstRowNum();
		int totalCell = workSheet.getRow(0).getLastCellNum();
		int arryCnt = 0;

		String dropdownValue1[] = null;

		try {

			String dropdownValue[] = new String[totalCell];


			for (int rowNum = 0; rowNum < totalRow; rowNum++) {

				row = workSheet.getRow(rowNum);
				cell = row.getCell(0);
				cellValue = cell.getStringCellValue().toLowerCase();

				if (cellValue.contains(dropdownAttribute.toLowerCase())) {

					for (int cellNum = 1; cellNum < totalCell; cellNum++) {

						String value = getCellvalue(rowNum, cellNum);

						if (value != "") {

							dropdownValue[arryCnt] = value;

							if (dropdownValue[arryCnt] != null) {

								arryCnt++;
							}
						}
					}


				}

				dropdownValue1 = new String[arryCnt];
				for (int i = 0; i < arryCnt; i++) {

					dropdownValue1[i] = dropdownValue[i];
				}
			}

		} catch (Exception e) {

		}
		return dropdownValue1;
	}

	public void setCellvalue(int rowNum, int cellNum, String setValue) throws IOException {

		try {
			row = workSheet.getRow(rowNum);

			XSSFCell newCell = row.createCell(cellNum);

			newCell.setCellValue(setValue);
			
			System.out.println(setValue + " value is updated in Excel");

		} catch (Exception e) {

			System.out.println("Unable to set cell value");
		}

		File file = new File("C:\\Users\\dhakarem\\Documents\\MyStuff\\Training Setup\\SMSList_Results.xlsx");

		FileOutputStream outputStream = new FileOutputStream(file);

		workBook.write(outputStream);

		outputStream.close();

	}

	public boolean createReport(int rowNum) {

		if (validedWebElement(reportIsstab)) {
			clickOn(reportIsstab);

			if (validedWebElement(selectCategory)) {
				selectDropdownFromExcel(selectCategory, rowNum, 3);
				System.out.println("Category selected successfully");
				System.out.println("==========================================================");
				if (validedWebElement(selectReproducibility)) {

					selectDropdownFromExcel(selectReproducibility, rowNum, 4);
					System.out.println("Reproducibility selected successfully");
					System.out.println("==========================================================");
					if (validedWebElement(selectSeverity)) {

						selectDropdownFromExcel(selectSeverity, rowNum, 5);
						System.out.println("Severity selected successfully");
						System.out.println("==========================================================");
						if (validedWebElement(selectPriority)) {

							selectDropdownFromExcel(selectPriority, rowNum, 6);
							System.out.println("Priority selected successfully");
							System.out.println("==========================================================");
							if (validedWebElement(selectAssignTo)) {

								selectDropdownFromExcel(selectAssignTo, rowNum, 7);
								System.out.println("AssigTo selected successfully");
								System.out.println("==========================================================");
								if (validedWebElement(summary)) {

									setText(summary, rowNum, 8);
									System.out.println("Summary added successfully");
									System.out.println("==========================================================");
									if (validedWebElement(description)) {

										setText(description, rowNum, 9);
										System.out.println("Description added successfully");
										System.out
												.println("==========================================================");
										if (validedWebElement(viewStatus_Button)) {

											selectRadioButton(getCellvalue(rowNum, 10));
											System.out.println("View Status radio button selected successfully");
											System.out.println(
													"==========================================================");
											if (validedWebElement(reportStay_Button)) {

												clickOn(reportStay_Button);
												System.out.println("Report Stay button selected successfully");
												System.out.println(
														"==========================================================");
												if (validedWebElement(submitButton)) {

													clickOn(submitButton);

													return true;
												} else {
													System.out.println("Unable to find 'Submit Report' button");
												}

											} else {
												System.out.println("Unable to find 'reportStay' button");
											}

										} else {
											System.out.println("Unable to find 'viewStatus' button");
										}

									} else {
										System.out.println("Unable to find 'Description' Webelement");
									}

								} else {
									System.out.println("Unable to find 'summary' Webelement");
								}

							} else {
								System.out.println("Unable to find 'AssignTo' Webelement");
							}

						} else {
							System.out.println("Unable to find 'Priority' Webelement");
						}

					} else {
						System.out.println("Unable to find 'Severity' Webelement");
					}

				} else {
					System.out.println("Unable to find 'Reproducibility' Webelement");
				}
			} else {
				System.out.println("Unable to find 'Category' Webelement");
			}
		} else {
			System.out.println("Unable to find 'report Issue' Webelement");
		}
		return false;

	}

	public String getIssueID() {

		if (validedWebElement(viewSubmittedIssueLink)) {

			try {
				String lnkTxt = driver.findElement(viewSubmittedIssueLink).getText();

				Pattern pattern = Pattern.compile("([0-9]+)");
				Matcher matcher = pattern.matcher(lnkTxt);
				if (matcher.find()) {
					issueID = matcher.group(1);
				}

				int newIssueidInt = Integer.parseInt(issueID);
				newIssueidString = String.format("%0" + "7" + "d", newIssueidInt);

			} catch (NumberFormatException e) {
				System.out.println("Unable to get Issue ID");
			}
		} else {
			System.out.println("Unable to find 'View Submitted Issue Link'");
		}
		return newIssueidString;
	}

	public String getIssueIDInViewIssue() {

		if (validedWebElement(viewSubmittedIssueLink)) {

			try {
				String lnkTxt = driver.findElement(viewSubmittedIssueLink).getText();

				Pattern pattern = Pattern.compile("([0-9]+)");
				Matcher matcher = pattern.matcher(lnkTxt);
				if (matcher.find()) {
					issueID = matcher.group(1);
				}

				int newIssueidInt = Integer.parseInt(issueID);
				newIssueidString = String.format("%0" + "7" + "d", newIssueidInt);

			} catch (NumberFormatException e) {
				System.out.println("Unable to get Issue ID");
			}
		} else {
			System.out.println("Unable to find 'View Submitted Issue Link'");
		}
		return newIssueidString;
	}

	public WebElement getCellFromTheViewIssueTableUsingValue(String cellValue, int cellNum, String tagName) {

		WebElement table = getWebElement(By.id("buglist"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 1; cRow < rows.size() - 1; cRow++) {

			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));
			String getIssueiDs = COLS.get(cellNum).getText();

			if (getIssueiDs.contains(cellValue)) {
				WebElement cell = COLS.get(cellNum).findElement(By.tagName(tagName));
				return cell;
			}
		}

		return null;
	}

	public String getCellFromTheViewIssueTableUsingValueTwoValues(String severity, String issueId,
			String severityOptionValue) {

		int severityCnt = 0;
		int issueIDCnt = 0;

		WebElement table = getWebElement(By.id("buglist"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 1; cRow < rows.size() - 1; cRow++) {

			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));

			for (int cellNum = 0; cellNum < COLS.size(); cellNum++) {

				String cellValue1 = COLS.get(cellNum).getText();

				if (cellValue1.contains(severity)) {

					System.out.println("The column " + cellValue1 + " is available at number " + cellNum
							+ " in the view issue table");

					severityCnt = cellNum;

				}
				if (cellValue1.contains(issueId)) {

					System.out.println("The column " + cellValue1 + " is available at number " + cellNum
							+ " in the view issue table");

					issueIDCnt = cellNum;

				}

			}
		}

		System.out.println("==========================================================");
		System.out.println("Below are the Issues having severity as " + severityOptionValue);

		for (int i = 3; i < rows.size() - 1; i++) {

			List<WebElement> COLS1 = rows.get(i).findElements(By.tagName("td"));

			WebElement cell = COLS1.get(severityCnt);

			if (cell.getText().contains(severityOptionValue)) {

				String IssueID = COLS1.get(issueIDCnt).getText();

				System.out.println(" #" + IssueID);

			}
		}

		return null;
	}

	public String[] getCellFromTheViewIssueTable(int cellNum, String tagName) {

		int temp = 0;
		String cellvalues[] = new String[50];
		String newcellvalues[];
		WebElement table = getWebElement(By.id("buglist"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 3; cRow < rows.size() - 1; cRow++) {

			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));
			String getCellValue = COLS.get(cellNum).getText();

			if (getCellValue != null) {

				cellvalues[temp] = getCellValue;
				temp++;
			}
		}

		newcellvalues = new String[temp];
		for (int i = 0; i < temp; i++) {

			newcellvalues[i] = cellvalues[i];
		}

		return newcellvalues;
	}
	
public int numberOfRows(int cellNum) {

		int temp = 0;
		String cellvalues[] = new String[50];
		
		WebElement table = getWebElement(By.id("buglist"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 3; cRow < rows.size() - 1; cRow++) {

			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));
			String getCellValue = COLS.get(cellNum).getText();

			if (getCellValue != null) {

				cellvalues[temp] = getCellValue;
				temp++;
			}
		}
		return temp;
	}

	public WebElement getIssueCellFromTheViewIssueTable(String issueID, int cellNum, String tagName) {

		WebElement table = getWebElement(By.id("buglist"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 3; cRow < rows.size() - 1; cRow++) {

			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));
			String getIssueiDs = COLS.get(cRow).getText();
	

			if (getIssueiDs.contains(issueID)) {
				WebElement cellValue = COLS.get(cellNum).findElement(By.tagName(tagName));
				return cellValue;
			}
		}

		return null;
	}

	public void validatePriority(String issueID, int cellNum) {

		WebElement table = getWebElement(By.id("buglist"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 3; cRow < rows.size() - 1; cRow++) {

			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));
			String getIssueiDs = COLS.get(cRow).getText();

			if (getIssueiDs.contains(issueID)) {
				COLS.get(cellNum).findElement(By.xpath("//img[@title = 'immediate']"));

				if (validedWebElement(By.xpath("//img[@title = 'immediate']"))) {
					System.out.println("Updated Priority to immediate successful on view issue table");
					break;

				} else {
					System.out.println("Priority not Updated");
				}
			}
		}

	}

	public void getListOfIssuesWithSamePriority(String priority) {

		WebElement table = getWebElement(By.id("buglist"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (int cRow = 3; cRow < rows.size() - 1; cRow++) {
			table = getWebElement(By.id("buglist"));
			rows = table.findElements(By.tagName("tr"));
			List<WebElement> COLS = rows.get(cRow).findElements(By.tagName("td"));

			for (int i = 0; i < 1; i++) {

				int cRow1 = 3;
				WebElement getIssueiDs = COLS.get(cRow1);
				String issueID = getIssueiDs.getText();
				getIssueiDs.click();
				if (validedWebElement(verifyPriority)) {

					if (getWebElement(verifyPriority).getText().contains(priority)) {

						System.out.println("IssueID#" + issueID + " has Priority as " + priority);
					} else {

					}

				} else {
					System.out.println("Priority webelement Not found");
				}
				clickOn(viewIsstab);

			}

		}

	}

	public void switchToPopupWindow() throws InterruptedException {

		driver = new FirefoxDriver();

		driver.get("file:///C:/Users/dhakarem/Desktop/Training%20Setup/CODE/WinPopup.html");

		String corewindow = driver.getWindowHandle();
		System.out.println("=======================================");

		System.out.println("Core window handlevalue is " + corewindow);

		clickOn(By.id("helpbutton"));


		if (validedWebElement(By.xpath("//button[contains(text(), 'OK')]"))) {
			System.out.println(" Ok Button found");
		} else {
			System.out.println("=======================================");
			System.out.println("Ok Button not found");
			System.out.println("Thats why switching to another window");
			Thread.sleep(1000); ///////////////////////////////////////////////////////
			System.out.println("=======================================");

			Set<String> newWindowHandle = driver.getWindowHandles();

			for (String currentWindowHandle : newWindowHandle) {

				if (!currentWindowHandle.equals(corewindow)) {

					System.out.println("Current window handle value is " + currentWindowHandle);

					driver.switchTo().window(currentWindowHandle);
					Thread.sleep(1000); ///////////////////////////////////////////////////////
					if (validedWebElement(By.xpath("//button[contains(text(), 'OK')]"))) {
						Thread.sleep(1000); ///////////////////////////////////////////////////////
						System.out.println("Ok Button found, means we switch to new popup");
						System.out.println("Assignment completed, hence closing the popup window");
						driver.close();
						System.out.println("=======================================");

					} else {
						System.out.println("Still Ok button not found");
					}
					break;

				}
			}
		}
		driver.switchTo().window(corewindow);
		System.out.println("Assignment completed, hence closing the main window");
		driver.close();
		System.out.println("=======================================");

	}
}
