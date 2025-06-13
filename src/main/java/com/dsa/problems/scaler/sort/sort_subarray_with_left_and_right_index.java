package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class sort_subarray_with_left_and_right_index {
    /**
   * Q. Sort subarray with left and right index
   *
   * You are given an array A of integers of length N and two indices, B and C.
   *
   * Your task is to sort the subarray [B, C] within the given array. The rest of the array should remain unchanged.
   *
   * Problem Constraints
   * 1 ≤ N ≤ 105
   * 0 ≤ A[i] ≤ 109
   * 0 ≤ B ≤ C ≤ N - 1
   */
  private static void merge(ArrayList<Integer> A, int s, int m, int e) {
    int i = s,
      j = m + 1,
      k = 0;
    ArrayList<Integer> temp = new ArrayList<>();
    for(int x = 0; x < e - s + 1; x++) {
      temp.add(0);
    }

    while (i <= m && j <= e) {
      if (A.get(i) <= A.get(j)) {
        temp.set(k, A.get(i));
        k++;
        i++;
      } else {
        temp.set(k, A.get(j));
        k++;
        j++;
      }
    }
    while (i <= m) {
      temp.set(k, A.get(i));
      k++;
      i++;
    }

    while (j <= e) {
      temp.set(k,A.get(j));
      k++;
      j++;
    }
  
    i = s;
    for (int x = 0; x < e - s + 1; x++) {
      A.set(i, temp.get(x));
      i++;
    }
  }
    
  private static void mergeSort(ArrayList<Integer> A, int s, int e) {
    if (s == e) {
      return;
    }
    int mid = (int)((s + e) / 2);
    mergeSort(A, s, mid);
    mergeSort(A, mid + 1, e);
    merge(A, s, mid, e);
  }
  
  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,2,435,3,4535,3,45,345,45,34,342,5434));
    mergeSort(A, 3, 5);
    System.out.println(A);
  }
}
