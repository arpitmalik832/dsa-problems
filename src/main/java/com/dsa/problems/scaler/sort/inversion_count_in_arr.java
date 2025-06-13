package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class inversion_count_in_arr {
  private static int count = 0;

  private static void merge(ArrayList<Integer> A, int s, int m, int e) {
    int i = s, j = m + 1;
    ArrayList<Integer> tempArr = new ArrayList<>();
    while(i <= m && j <= e) {
      if(A.get(i) <= A.get(j)) {
        tempArr.add(A.get(i));
        i++;
      } else {
        count++;
        tempArr.add(A.get(j));
        j++;
      }
    }
    while(i <= m) {
      tempArr.add(A.get(i));
      i++;
    }
    while(j <= e) {
      tempArr.add(A.get(j));
      j++;
    }
    int x = s;
    for(i = 0; i < tempArr.size(); i++) {
      A.set(x++, tempArr.get(i));
    }
  }

  private static void mergeSort(ArrayList<Integer> A, int s, int e) {
    if(s == e) {
      return;
    }
    int mid = (int)((s + e) / 2);
    mergeSort(A, s, mid);
    mergeSort(A, mid + 1, e);
    merge(A, s, mid, e);
  }

  /**
   * Q. Inversion count in an array
   *
   * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
   *
   * Problem Constraints
   * 1 <= length of the array <= 105
   * 1 <= A[i] <= 109
   */
  private static int inversionCountInArr(ArrayList<Integer> A) {
    mergeSort(A, 0, A.size() - 1);
    return count;
  }

  public static void main(String[] args) {
    System.out.println(inversionCountInArr(new ArrayList<>(Arrays.asList(1,3,2,4))));
  }
}
