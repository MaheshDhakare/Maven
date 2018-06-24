package my.practice.working;

import java.util.Arrays;

//import java.util.Scanner;

public class Find_SpecificNumber_Copyof {

	public static void main(String[] args) {
		
		int [] arryName = {7,5,1,5,1};
		int numfind = 5;
		int fCount[]= new int [5];
		//fCount[0] = 0;
		int fcnt = 0;
//		Scanner myScanner = new Scanner(System.in);
		
		for (int cnt = 0; cnt < arryName.length; cnt++) {
			if (arryName[cnt] == numfind) {
				fCount[fcnt] = cnt;
				fcnt++;
				
			}
		}
		
		
		int[] copyOf = Arrays.copyOf(fCount, 2);
		for (int i : copyOf) {
			
			System.out.println(i);
		}
		
		}
		

	}


