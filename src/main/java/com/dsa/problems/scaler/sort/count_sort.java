package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class count_sort {
  /**
   * Q. Count Sort
   *
   * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
   *
   * Problem Constraints
   * 1 <= |A| <= 10^5
   * 1 <= A[i] <= 10^5
   */
  private static void countSort(ArrayList<Integer> A) {
    final int freqSize = (int)(Math.pow(10, 5) + 1);
    ArrayList<Integer> freq = new ArrayList<>();
    for(int i = 0; i < freqSize; i++) {
      freq.add(i, 0);
    }

    for(int i = 0; i < A.size(); i++) {
      int temp = A.get(i);
      freq.set(temp, freq.get(temp) + 1);
    }

    int j = 0;
    for(int i = 0; i < freqSize; i++) {
      for(int z = 0; z < freq.get(i); z++) {
        A.set(j++, i);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3,5,6,4,2,5,2,4,3,2,5,3,9,7,2,5));
    countSort(A);
    System.out.println(A);
  }
}
