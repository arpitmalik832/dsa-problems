package com.dsa.problems.scaler.sort;

import java.util.*;

public class factors_sort {
  private static int getFactorsCount(int n) {
    int count = 0;
    for(int i = 1; i * i <= n; i++) {
      if(n % i == 0) {
        if((int)(n / i) == i) {
          count += 1;
        } else {
          count += 2;
        }
      }
    }

    return count;
  }

  /**
   * Q. Factors sort
   *
   * You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
   *
   * Note: You cannot use any extra space
   */
  private static void factorsSort(ArrayList<Integer> A) {
    A.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        int factorCountA = getFactorsCount(a);
        int factorCountB = getFactorsCount(b);
        if(factorCountA == factorCountB) {
          return a - b;
        } else {
          return factorCountA - factorCountB;
        }
      }
    });
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3,4,5,10,4,25,9));
    factorsSort(A);
    System.out.println(A);
  }
}
