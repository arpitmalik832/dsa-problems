package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class find_smallest_again {
  private static int findPos(ArrayList<Integer> A, int sum) {
    int n = A.size();
    int cnt = 0;
    for(int i = 0; i < n - 2; i++) {
      int j = i + 1, k = n - 1;
      while(j < k) {
        int tempSum = A.get(i) + A.get(j) + A.get(k);
        if(tempSum <= sum) {
          cnt += k - j;
          j++;
        } else {
          k--;
        }
      } 
    }
    return cnt;
  }
  /**
   * Q. Find Smallest Again
   *
   * Given an integer array A of size N.
   *
   * If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
   *
   * NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
   *
   * Problem Constraints
   * 3 <= N <= 500
   * 1 <= A[i] <= 108
   * 1 <= B <= (N*(N-1)*(N-2))/6
   */
  private static int findSmallestAgain(ArrayList<Integer> A, int B) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    });

    int n = A.size();
    int lo = A.get(0) + A.get(1) + A.get(2);
    int hi = A.get(n - 3) + A.get(n - 2) + A.get(n - 1);
    while(lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int pos = findPos(A, mid);
      if (pos >= B) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  public static void main(String[] args) {
    System.out.println(findSmallestAgain(new ArrayList<>(Arrays.asList(22,10,5,11,16,2,11,7,16,2,17,6,15,3,9,6)), 5));
  }
}
