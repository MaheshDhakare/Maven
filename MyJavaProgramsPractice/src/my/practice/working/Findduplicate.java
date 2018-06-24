package my.practice.working;

public class Findduplicate {

	static int temp;

	public static void main(String[] args) {
		int[] arry = {1,2,1,1,1};
		System.out.println(arry.length);
		for (int i = 0; i < arry.length; i++) {
			for (int j = i+1; j < arry.length; j++) {
				if (arry[i]==arry[j]) {
					temp = arry[j];
					
				}
				
			}
		}
		System.out.println(temp);
	}

	

	}

