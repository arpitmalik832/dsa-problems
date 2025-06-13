package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class quick_sort {
  private static int parition(ArrayList<Integer> A, int s, int e) {
    int m = (int)((s + e) / 2);
    int aS = A.get(s), aE = A.get(e), aM = A.get(m);
    int pivot = s; 
    if(aM > aS && aM < aE) {
      pivot = m;
    } else if(aE > aS && aE < aM) {
      pivot = e;
    }
    int temp = A.get(s);
    A.set(s, A.get(pivot));
    A.set(pivot, temp);
    int l = s + 1, r = e;
    while(l <= r) {
      if(A.get(l) <= A.get(s)) {
        l++;
      } else if(A.get(r) >= A.get(s)) {
        r--;
      } else {
        temp = A.get(l);
        A.set(l, A.get(r));
        A.set(r, temp);
        l++;
        r--;
      }
    }
    temp = A.get(s);
    A.set(s, A.get(r));
    A.set(r, temp);

    return r;
  }

  /**
   * Q3. Quick Sort
   *
   * Given an integer array A, sort the array using Quick Sort.
   */
  private static void quickSort(ArrayList<Integer> A, int s, int e) {
    if(s >= e) {
      return;
    }

    int p = parition(A, s, e);
    quickSort(A, s, p - 1);
    quickSort(A, p + 1, e);
  }  

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,5,6,3,1,45,6,3,5,6));
    quickSort(A, 0, A.size() - 1);
    System.out.println(A);
  }
}
