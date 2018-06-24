package com.application.mantisbt.PartB;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Assignment_20_OpenissuePrintseverityEditseverityUpdateseverityConfirmseverity {

	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	static int rowNum = 2;


	public static void main(String[] args) throws IOException {
		
		System.out.println("===================Assignment_20_OpenissuePrintseverityEditseverityUpdateseverityConfirmseverity=================== ");

		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");

		All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();

		objBussPro.ReadExcel("C:\\Users\\dhakarem\\Desktop\\Eclipse_Workspace\\Assig13.xlsx", "Test");

		for (int rowNum = 1; rowNum < 2; rowNum++) {

			String userName = objBussPro.getCellvalue(rowNum, 1);
			String password = objBussPro.getCellvalue(rowNum, 2);

			if ((userName != null) && (password != null)) {

				objBussPro.LoginToMantis("http://localhost:8080/mantisbt/login_page.php", userName, password);

				if (objBussPro.validedWebElement(objBussPro.logoutButton)) {

					System.out.println("==========================================================");
					System.out.println("Login to Mantis successful");
					System.out.println("==========================================================");

					if (objBussPro.validedWebElement(objBussPro.reportIsstab)) {

						objBussPro.createReport(rowNum);

						if (objBussPro.validedWebElement(objBussPro.viewSubmittedIssueLink)) {

							String issueID = objBussPro.getIssueID();
							System.out.println("Successfully created issue " + issueID + " in Mantis");
							System.out.println("==========================================================");
							objBussPro.clickOn(objBussPro.viewSubmittedIssueLink);

							if (objBussPro.validedWebElement(objBussPro.verifyCurrectIssueOpened)) {

								System.out.println("Currect IssueID# " + issueID + " is opened");

								String severityValue = objBussPro.getWebElement(objBussPro.verifySeverity).getText();

								System.out.println("And the severity for issueID# " + issueID + " is " + severityValue);

								System.out.println("==========================================================");

								if (objBussPro.validedWebElement(objBussPro.editButton)) {

									objBussPro.clickOn(objBussPro.editButton);

									System.out.println("Successfully clicked on Edit button");
									System.out.println("==========================================================");

									if (objBussPro.validedWebElement(objBussPro.backLink)) {

										objBussPro.selectDropdown(objBussPro.editSeverity, "crash");

										System.out.println("Successfully selected text value");
										System.out
												.println("==========================================================");

										if (objBussPro.validedWebElement(objBussPro.updateInformationButton)) {

											objBussPro.clickOn(objBussPro.updateInformationButton);

											System.out.println("Successfully clicked on updateInformation Button");
											System.out.println(
													"==========================================================");

											if (objBussPro.validedWebElement(objBussPro.verifyCurrectIssueOpened)) {

												System.out.println("Currect IssueID# " + issueID + " is opened");

												String updatedseverityValue = objBussPro
														.getWebElement(objBussPro.verifySeverity).getText();

												System.out.println("And the severity for issueID# " + issueID
														+ " is updated to " + updatedseverityValue);

												objBussPro.setCellvalue(rowNum, 11, issueID);
												objBussPro.setCellvalue(rowNum, 12, "Passed");
												objBussPro.setCellvalue(rowNum, 13, "severity for issueID# " + issueID
														+ " is updated to " + updatedseverityValue);

												System.out.println(
														"==========================================================");

												if (objBussPro.validedWebElement(objBussPro.logoutButton)) {

													objBussPro.clickOn(objBussPro.logoutButton);

													if (objBussPro.validedWebElement(objBussPro.loginButton)) {

														System.out.println("Successfully logout from Mantis");
														System.out.println(
																"==========================================================");
														objBussPro.closeBrowser();
														System.out.println("Successfully closed the browser");
														System.out.println(
																"==========================================================");

													} else {
														System.out.println("Unable to close browser");
														objBussPro.setCellvalue(rowNum, 12, "Failed");
														objBussPro.setCellvalue(rowNum, 13, "Unable to close browser");
													}
												} else {

													System.out.println("Unable to find 'Logout button'");
													objBussPro.setCellvalue(rowNum, 12, "Failed");
													objBussPro.setCellvalue(rowNum, 13,
															"Unable to find 'Logout button'");
													objBussPro.closeBrowser();
												}
											} else {
												System.out.println("Incurrect issue ID is opened");
												objBussPro.setCellvalue(rowNum, 12, "Failed");
												objBussPro.setCellvalue(rowNum, 13, "Incurrect issue ID is opened");
												objBussPro.closeBrowser();
											}
										} else {
											System.out.println("Unable to find updateInformation Button");
											objBussPro.setCellvalue(rowNum, 13,
													"Unable to find updateInformation Button");
											objBussPro.setCellvalue(rowNum, 12, "Failed");
											objBussPro.closeBrowser();
										}

									} else {
										System.out.println("Unable to find Back button");
										objBussPro.setCellvalue(rowNum, 13, "Unable to find Back button");
										objBussPro.setCellvalue(rowNum, 12, "Failed");
										objBussPro.closeBrowser();
									}

								} else {
									System.out.println("Unable to find Edit button");
									objBussPro.setCellvalue(rowNum, 13, "Unable to find Edit button");
									objBussPro.setCellvalue(rowNum, 12, "Failed");
									objBussPro.closeBrowser();
								}

							} else {

								System.out.println("Incurrect issue ID is opened");
								objBussPro.setCellvalue(rowNum, 13, "Incurrect issue ID is opened");
								objBussPro.setCellvalue(rowNum, 12, "Failed");
								objBussPro.closeBrowser();

							}

						} else {
							System.out.println("Report issue failed");
							objBussPro.setCellvalue(rowNum, 12, "Failed");
							objBussPro.setCellvalue(rowNum, 13, "Report issue failed");
							objBussPro.closeBrowser();
						}

					} else {
						System.out.println("Unable to find 'Report Issue' link");
						objBussPro.setCellvalue(rowNum, 12, "Failed");
						objBussPro.setCellvalue(rowNum, 13, "Unable to find 'Report Issue' link");
						objBussPro.closeBrowser();
					}

				} else {

					System.out.println("Unable to Login to Mantis");
					objBussPro.setCellvalue(rowNum, 12, "Failed");
					objBussPro.setCellvalue(rowNum, 13, "Unable to Login to Mantis");
					objBussPro.closeBrowser();
				}

			} else {

				System.out.println("Username or Password is missing");
				objBussPro.setCellvalue(rowNum, 12, "Failed");
				objBussPro.setCellvalue(rowNum, 13, "Username or Password is missing");

			}

			System.out.println("::::::::::::::::::::::::::::Test Case Ends::::::::::::::::::::::::::::");

		}
	}
}
