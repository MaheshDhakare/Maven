package com.application.mantisbt.PartA;

public class Assignment_12_Login20Times {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox 41.0\\firefox.exe");
		Assignment_11_WIthXpath obj20 = new Assignment_11_WIthXpath();
		
		obj20.LoginToMantis("http://localhost:8080/mantisbt/login_page.php", "Administrator", "root");
				
		for (int i = 0; i<20; i++)
		{
			
			obj20.reportCreation();
		}
		
		obj20.LogOut();

	}

}
