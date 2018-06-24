package my.practice.working;

public class FindTheMinNumber {

	public static void main(String[] args) {
		int arr[]={7,3,4,5,34,56,3,1}; 
		int min=arr[0];
		int minIndex = 0;
		
		for(int i=1;i<arr.length;i++) {		
			if(min>arr[i]) {				
				min=arr[i];
				minIndex  = i;		  
			}
			}
		System.out.println("The min number is "+min+" and it is present at "+minIndex+ " index");
	
		}

	}


