package com.dsa.problems.scaler.hashing;

import java.util.*;

public class count_unique_elements {
  /**
   * Q. Count unique elements
   *
   * You are given an array A of N integers. Return the count of elements with frequency 1 in the given array.
   */
  public static int countUniqueElements(ArrayList<Integer> A) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int a : A) {
      if(hm.containsKey(a)) {
        hm.put(a, hm.get(a) + 1);
      } else {
        hm.put(a, 1);
      }
    }

    int rslt = 0;
    for(int a : A) {
      if(hm.containsKey(a) && hm.get(a) == 1) {
        rslt++;
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(countUniqueElements(new ArrayList<>(Arrays.asList(1,2,2,1,3,4,5,5,3))));
  }
}
