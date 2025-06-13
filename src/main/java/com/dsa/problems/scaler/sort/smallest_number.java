package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class smallest_number {
  /**
   * Q. Smallest Number
   *
   * An integer is given to you in the form of an array, with each element being a separate digit.
   *
   * Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.
   *
   * Note - Do not use any sorting algorithm or library's sort method.
   */
  private static void smallestNumber(ArrayList<Integer> A) {
    ArrayList<Integer> nums = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
      nums.add( 0);
    }

    for(int i = 0; i < A.size(); i++) {
      nums.set(A.get(i), nums.get(A.get(i)) + 1);
    }

    int j = 0;
    for(int i = 0; i < nums.size(); i++) {
      for(int x = 0; x < nums.get(i); x++) {
        A.set(j++, i);
      }
    }
  } 

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,4,6,3,5,6,7,4,6));
    smallestNumber(A);
    System.out.println(A);
  }
}
