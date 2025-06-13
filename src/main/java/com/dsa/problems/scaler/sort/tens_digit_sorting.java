package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class tens_digit_sorting {
  /**
   * Q3. Tens Digit Sorting
   *
   * Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
   *
   * If a number has no tens digit, we can assume value to be 0.
   * If 2 numbers have same tens digit, in that case number with max value will come first
   * Solution should be based on comparator.
   */
  private static void tensDigitSorting(ArrayList<Integer> A) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        int a10 = (a / 10) % 10;
        int b10 = (b / 10) % 10;
        if(a10 == b10) {
          return b - a;
        } else {
          return a10 - b10;
        }
      }
    });
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3203,243,2232,42,3242));
    tensDigitSorting(A);
    System.err.println(A);
  }
}
