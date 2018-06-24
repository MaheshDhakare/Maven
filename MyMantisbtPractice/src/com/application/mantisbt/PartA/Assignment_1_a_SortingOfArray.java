package com.application.mantisbt.PartA;

import java.util.Scanner;

public class Assignment_1_a_SortingOfArray {

	public static void main(String[] args) {

		Assignment_1_a_SortingOfArray objSort = new Assignment_1_a_SortingOfArray();
		objSort.arraySortingAscending(5);
		objSort.arraySortingDscending(5);
	
	}
	//=============Below method is to sort the arrays in ascending order.=================================================	
public void arraySortingAscending(int num) {

int reference;

			Scanner myScanner = new Scanner(System.in);	
			System.out.println("Enter the sorting nubmers");	
			num = myScanner.nextInt();
			int[] sA = new int[num];
			System.out.println("Enter your " + num + " numbers");
			
for (int baseCnt = 0; baseCnt < sA.length; baseCnt++) {
			sA[baseCnt] = myScanner.nextInt();
	}
for (int sortA = 0; sortA < sA.length; sortA++) {	
		
		for (int sortB = sortA+1; sortB < sA.length; sortB++){
		
			if (sA[sortA] > sA[sortB]){
				
				reference = sA[sortA];
				sA[sortA] = sA[sortB];
				sA[sortB] = reference;		
			}	
		}
	}

for (int i = 0; i < sA.length; i++) 
		{
			System.out.println(sA[i]);		
		}
	myScanner.close(); //REMOVE THIS LINE, AS THIS CLOSES YOUR SYSTEM.IN AND YOU WON'T BE ABLE TO USE SYS IN AGAIN.
	}

//=============Below method is to sort the arrays in dscending order.=================================================

public void arraySortingDscending(int num) {
		
int reference;

		Scanner myScanner = new Scanner(System.in);	
		System.out.println("Enter the sorting nubmers");	
		num = myScanner.nextInt();
		int[] sA = new int[num];
		System.out.println("Enter your " + num + " numbers");
		
for (int baseCnt = 0; baseCnt < sA.length; baseCnt++) {
		sA[baseCnt] = myScanner.nextInt();	
	}
		
for (int sortA = 0; sortA < sA.length; sortA++) {	
		
		for (int sortB = sortA+1; sortB < sA.length; sortB++){
		
			if (sA[sortA] < sA[sortB]){
				
				reference = sA[sortA];
				sA[sortA] = sA[sortB];
				sA[sortB] = reference;		
			}	
		}
	}

for (int i = 0; i < sA.length; i++) 
		{
			System.out.println(sA[i]);		
		}	
	myScanner.close();
	}
}
