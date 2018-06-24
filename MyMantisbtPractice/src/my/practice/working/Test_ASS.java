package my.practice.working;

public class Test_ASS {

	public static void main(String[] args) {
		
		
		int value[] = {162,837,4653,9463,3,7462,56,0,1,3,4,6453,85764,-3872,29,8347,-27,-8,-0,249764,-9476324};
//		int value[] = {837,111,4653};
		int temp= 0;
		
		System.out.print("The assending order is = ");
		for (int i = 0; i < value.length; i++) {
			
			for (int j = i+1; j < value.length; j++) {
				
				if (value[i]>value[j]) {
					
					temp = value[j];
					value[j] = value[i];
					value[i] = temp;					
				}

			}
			System.out.print(value[i]+ ",");
		}
		System.out.println("\n");
		System.out.print("The decending order is = ");
		for (int i = 0; i < value.length; i++) {
			
			for (int j = i+1; j < value.length; j++) {
				
				if (value[i]<value[j]) {
					
					temp = value[j];
					value[j] = value[i];
					value[i] = temp;					
				}

			}
			System.out.print(value[i]+ ",");
		}

	}

}
