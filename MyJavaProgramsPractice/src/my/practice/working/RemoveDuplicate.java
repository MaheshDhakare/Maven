package my.practice.working;

public class RemoveDuplicate {

	static int temp;

	public static void main(String[] args) {
		int[] arry = {1,2,3,4,4,3,5,3,5,5,4,3,1};
		System.out.println(arry.length);
		for (int i = 0; i < arry.length; i++) {
			for (int j = i+1; j < arry.length; j++) {
				if (arry[i]==arry[j]) {
				//	temp = arry[j];
					System.out.println(i);
					break;
					
				}
				
			}
		}
	}

	

	}

