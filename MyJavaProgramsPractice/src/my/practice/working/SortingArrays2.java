package my.practice.working;


import java.util.Scanner;


public class SortingArrays2 {

//============Below method is to sort the arrays in ascending order===========================================================	
	
public String arraySortingAscending(int num) {

	int reference;


		Scanner myScanner = new Scanner(System.in);	
//		System.out.println("Enter the sorting nubmers");	
//		num = myScanner.nextInt();	
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

	String Test = "0";
	for (int i = 0; i < sA.length; i++) 
	{
		Test = Integer.toString(sA[i]);
	}
myScanner.close();	
	return Test ;
}
//=============Below method is to sort the arrays in ascending order.=================================================

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