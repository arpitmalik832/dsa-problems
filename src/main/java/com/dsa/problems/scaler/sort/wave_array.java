package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class wave_array {
  /**
   * Q. Wave Array
   *
   * Given an array of integers A, sort the array into a wave-like array and return it.
   * In other words, arrange the elements into a sequence such that
   *
   * a1 >= a2 <= a3 >= a4 <= a5.....
   * NOTE: If multiple answers are possible, return the lexicographically smallest one.
   */
  private static void waveArray(ArrayList<Integer> A) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    });

    for(int i = 0; i < A.size() - 1; i += 2) {
      int temp = A.get(i);
      A.set(i, A.get(i + 1));
      A.set(i + 1, temp);
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,23,23132,424,4,24,4,242,34,12,2));
    waveArray(A);
    System.out.println(A);
  }
}
