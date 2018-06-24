package my.practice.working;



import org.openqa.selenium.WebElement;

import com.application.mantisbt.PartB.All_Com_Reuseable_Methods;

public class Test22 {


	public static void main(String[] args) {

		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		
		All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();
		objBussPro.ReadExcel("C:\\Users\\dhakarem\\Desktop\\Assig13.xlsx", "Test");
		
		for (int rowNum = 1; rowNum < 2; rowNum++) {
			
			String userName = objBussPro.getCellvalue(rowNum, 1);
			String password = objBussPro.getCellvalue(rowNum, 2);
			
			if ((userName != null) && (password != null)){

				objBussPro.LoginToMantis("http://localhost:8080/mantisbt/login_page.php", userName, password);	
				objBussPro.createReport(rowNum);
				String issueID = objBussPro.getIssueID();
				System.out.println("IssueID#" + issueID);
				
//				objBussPro.clickOn(objBussPro.viewIsstab);
//				System.out.println("Clicked on View Issue tab");
				
				WebElement clickOnEditInViewIssueTab = objBussPro.getIssueCellFromTheViewIssueTable(issueID, 1, "a");
				clickOnEditInViewIssueTab.click();

//				
//			
//						
				}
				
	}

}
}





























