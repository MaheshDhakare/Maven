package com.application.mantisbt.PartA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test0753465346 {
  public static void main(String[] args) {
    // A string array with duplicate values
    String[] data = { "A1", "C2", "B3", "D4", "A1", "B", "E", "D", "B", "C" };
    System.out.println("Original array         : " + Arrays.toString(data));

    List<String> list = Arrays.asList(data);
    Set<String> set = new HashSet<String>(list);

    System.out.print("Remove duplicate result: ");

    String[] result = new String[set.size()];
    set.toArray(result);
    for (String s : result) {
      System.out.print(s);
      System.out.println();
    }
  }
}