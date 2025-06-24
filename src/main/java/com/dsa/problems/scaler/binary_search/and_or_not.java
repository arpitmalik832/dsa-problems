package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class and_or_not {
  private static boolean isPossible(ArrayList<Integer> A, int B, int i, int items, ArrayList<Integer> pf) {
    int sum = 0;
    if(i - items < 0) {
      sum = pf.get(i);
    } else {
      sum = pf.get(i) - pf.get(i - items); 
    }
    if(items * A.get(i) - sum > B)
      return false;

    return true;
  }
  /**
   * Q3. ADD OR NOT
   *
   * Given an array of integers A of size N and an integer B.
   *
   * In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
   *
   * Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
   * If there are several such numbers, your task is to find the minimum one.
   *
   * Problem Constraints
   * 1 <= N <= 105
   * -109 <= A[i] <= 109
   * 0 <= B <= 109
   */
  private static ArrayList<Integer> andOrNot(ArrayList<Integer> A, int B) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    });

    int n = A.size();
    ArrayList<Integer> pf = new ArrayList<>(A);
    for(int i = 1; i < pf.size(); i++) {
      pf.set(i, pf.get(i) + pf.get(i - 1));
    }

    ArrayList<Integer> rslt = new ArrayList<>(Arrays.asList(-1,-1));
    for(int i = 0; i < n; i++) {
      int lo = 1, hi = i + 1;
      int tempRslt = 0;
      while(lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if(isPossible(A, B, i, mid, pf)) {
          tempRslt =  mid;
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
      if(rslt.get(0) < tempRslt) {
        rslt.set(0, tempRslt);
        rslt.set(1, A.get(i));
      }
    }
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(andOrNot(new ArrayList<>(Arrays.asList(3,1,2,2,1)),3));
  }
}
