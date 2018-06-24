package com.application.mantisbt.PartA;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment_2_EvenOdd {

public static void main(String[] args) {

		Assignment_2_EvenOdd objSort = new Assignment_2_EvenOdd();
		objSort.findEvenOdd();		
	}

	public void findEvenOdd() {

			Scanner myScanner = new Scanner(System.in);	
			System.out.println("Enter the sorting nubmers");	
			int num = myScanner.nextInt();	
			int[] sA = new int[num];
			int evenCnt = 0;
			int oddCnt = 0;
			int[] evenNum = new int[num];
			int[] oddNum = new int[num];
			System.out.println("Enter your " + num + " numbers");
			
		for (int baseCnt = 0; baseCnt < sA.length; baseCnt++) {
			sA[baseCnt] = myScanner.nextInt();
	}
		for (int sortA = 0; sortA < sA.length; sortA++) {	
		
			if (sA[sortA]%2 == 0) {
				evenNum[evenCnt] = sA[sortA];
				evenCnt++;		
			} 
			else {
				oddNum[oddCnt] = sA[sortA];
				oddCnt++;
			}
		}
int[] newEven = Arrays.copyOf(evenNum, evenCnt);
int[] newOdd = Arrays.copyOf(oddNum, oddCnt);


System.out.println("Below are Even Numbers");
	for (int i : newEven) {
		System.out.println(i);
	}
	
System.out.println("Below are Odd Numbers");
	for (int i : newOdd) {
		System.out.println(i);
	}

myScanner.close();

}
	
}


