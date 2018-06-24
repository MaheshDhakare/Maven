package com.application.mantisbt.PartA;

import java.util.Scanner;

public class Assignment_1_d_RemoveDuplicates {

	public static void main(String[] args) {

		Assignment_1_d_RemoveDuplicates objSort = new Assignment_1_d_RemoveDuplicates();
		objSort.removeDuplicatesNum(5);
	}		
public void removeDuplicatesNum(int num) {



			Scanner myScanner = new Scanner(System.in);	
			System.out.println("Enter the sorting nubmers");	
			num = myScanner.nextInt();	
			int[] sA = new int[num];
			int[] newArray = new int[num];
			int newCnt = 0;
			System.out.println("Enter your " + num + " numbers");
			
for (int baseCnt = 0; baseCnt < sA.length; baseCnt++) {
			sA[baseCnt] = myScanner.nextInt();
	}
for (int sortA = 0; sortA < sA.length; sortA++) {	
		
		for (int sortB = sortA+1; sortB < sA.length; sortB++){
		
			if (sA[sortA] == sA[sortB]){
				newArray[newCnt] = sA[sortA];
				newCnt++;
				break;
			}
			if (sA[sortA] != sA[sortB]){
				newArray[newCnt] = sA[sortA];
				
			}
		}
	}

for (int i = 0; i < newArray.length; i++) 
		{
			System.out.println(newArray[i]);		
		}
	myScanner.close();
	}
}
