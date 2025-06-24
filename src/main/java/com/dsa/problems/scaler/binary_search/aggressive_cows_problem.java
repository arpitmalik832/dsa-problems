package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class aggressive_cows_problem {
  private static boolean isPossible(ArrayList<Integer> A, int B, int dist) {
    int count = 1;
    int lastLocation = 0;
    for(int i = 1; i < A.size(); i++) {
      if(A.get(i) - A.get(lastLocation) >= dist) {
        count++;
        lastLocation = i;
      }
      if(count == B) {
        return true;
      }
    }

    return false;
  }
  /**
   * Aggressive cows Problem
   *
   * You are given n towns in the form of an array with their locations.
   * You are given number of cows to be placed.
   * You need to maximize the minimum distance between any two adjacent cows.
   */
  private static int solve(ArrayList<Integer> A, int B) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    });
    final int n = A.size();
    int lo = 1, hi = A.get(n - 1) - A.get(0);
    int rslt = 0;
    while(lo <= hi) {
      final int mid = lo + (hi - lo) / 2;
      if(isPossible(A, B, mid)) {
        rslt = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(solve(new ArrayList<>(Arrays.asList(1,3,5,2,4)), 3));
  }
}
