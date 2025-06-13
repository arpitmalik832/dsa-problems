package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class sort_01 {
  /**
   * Q. Sort 01
   *
   * Given an array A of 0s and 1s of length N. Sort this array.
   *
   * Note - Do not use any sorting algorithm or library's sort method.
   */
  private static void sort01(ArrayList<Integer> A) {
    ArrayList<Integer> freq = new ArrayList<>();
    for(int i = 0; i < 2; i++) {
      freq.add(0);
    }

    for(int i = 0; i < A.size(); i++) {
      freq.set(A.get(i), freq.get(A.get(i)) + 1);
    }

    int j = 0;
    for(int i = 0; i < 2; i++) {
      for(int x = 0; x < freq.get(i); x++) {
        A.set(j++, i);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,0,1,1,1,0,0,0));
    sort01(A);
    System.out.println(A);
  }
}
