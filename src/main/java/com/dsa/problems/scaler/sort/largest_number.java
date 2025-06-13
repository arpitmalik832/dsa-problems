package com.dsa.problems.scaler.sort;

import java.util.*;

public class largest_number {
  /**
   * Q. Largest Number
   *
   * Given an array A of non-negative integers, arrange them such that they form the largest number.
   *
   * Note: The result may be very large, so you need to return a string instead of an integer.
   */
  private static String largestNumber(ArrayList<Integer> A) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        String ab = a.toString() + b.toString();
        String ba = b.toString() + a.toString();
        int abNum = Integer.parseInt(ab);
        int baNum = Integer.parseInt(ba);
        if(abNum > baNum) {
          return -1;
        }else {
          return 1;
        }
      }
    });
    String rslt = "";
    for(int a : A) {
      rslt += a;
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new ArrayList<>(Arrays.asList(2,20,8))));
  }
}
