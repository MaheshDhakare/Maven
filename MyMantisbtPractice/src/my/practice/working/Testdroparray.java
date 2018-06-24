package my.practice.working;

import com.application.mantisbt.PartB.All_Com_Reuseable_Methods;

public class Testdroparray {

	public static void main(String[] args) {
		
		String dropdownValue = "Priority";
		int cnt = 1;
		
		All_Com_Reuseable_Methods objBussPro = new All_Com_Reuseable_Methods();
		objBussPro.ReadExcel("C:\\Users\\dhakarem\\Desktop\\Assig13.xlsx", "Test");
				
		 if(objBussPro.getDropdownvalueInArray(dropdownValue).length != 0) {
			 
			 String[] dropdownvalueInArray = objBussPro.getDropdownvalueInArray(dropdownValue);
			 System.out.println("Below are the values available under "+ dropdownValue + "dropdown");
			 for (String string : dropdownvalueInArray)
			 {
				 System.out.println(string);
			 }
			System.out.println(dropdownvalueInArray[cnt]);
		 }
		 else {
			System.out.println("There are no values available ubder the dropdown " + "'"+dropdownValue+"'" );
		}
		
		
			
						
		
	}

}
