package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class merge_sort {
  private static void merge(ArrayList<Integer> A, int s, int m, int e) {
    int i = s, j = m + 1;
    ArrayList<Integer> temp = new ArrayList<>();
    while(i <= m && j <= e) {
      if(A.get(i) <= A.get(j)) {
        temp.add(A.get(i++));
      } else {
        temp.add(A.get(j++));
      }
    }

    while(i <= m) {
      temp.add(A.get(i++));
    }
    while(j <= e) {
      temp.add(A.get(j++));
    }

    j = s;
    for(i = 0; i < temp.size(); i++) {
      A.set(j++, temp.get(i));
    }
  }

  /**
   * Q. Merge Sort
   *
   * Given an integer array A, sort the array using Merge Sort.
   *
   * Problem Constraints
   * 1 <= |A| <= 105
   * 1 <= A[i] <= 109} arr
   */
  private static void mergeSort(ArrayList<Integer> A, int s, int e) {
    if(s == e) {
      return;
    }
    int m = (int)((s + e) / 2);
    mergeSort(A, s, m);
    mergeSort(A, m + 1, e);
    merge(A, s, m, e);
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,42,5,45,34,35,34,35,32,31,423,23));
    mergeSort(A, 0, A.size() - 1);
    System.out.println(A);
  }
}
