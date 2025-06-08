package com.dsa.problems.scaler.hashing;

import java.util.*;

public class count_distinct_elements {
  /**
   * Q. Count distinct elements
   *
   * Given an array A of N integers, return the number of unique elements in the array.
   */
  private static int countDistinctElements (ArrayList<Integer> A) {
    HashSet<Integer> hs = new HashSet<>();

    for(int i = 0; i < A.size(); i++) {
      hs.add(A.get(i));
    }

    return hs.size();
  }

  public static void main(String[] args) {
    System.out.println(countDistinctElements(new ArrayList<>(Arrays.asList(1,2,3,1,2,4,2))));
  }
}
