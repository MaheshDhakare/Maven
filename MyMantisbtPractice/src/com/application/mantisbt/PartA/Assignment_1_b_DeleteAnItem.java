package com.application.mantisbt.PartA;

import java.util.Arrays;

public class Assignment_1_b_DeleteAnItem {

	public static void main(String[] args) {

Assignment_1_b_DeleteAnItem objdeleteItem = new Assignment_1_b_DeleteAnItem();
		objdeleteItem.deleteItem();
	}
public void deleteItem() {
	
		int array[] = {64,96,85,86,96,536,96,67,96,72,96,96,96,96};
		int skipNum = 64;
		int newarry[] = new int[50];
		int newcnt = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != skipNum) {
				newarry[newcnt] = array[i];
				newcnt++;				
			}
		}		
		
		int[] copyOf = Arrays.copyOf(newarry, newcnt);		
		for (int k : copyOf) {
			System.out.println(k);
		}
	}
}
