package com.dsa.problems.scaler.hashing;

import java.util.*;

public class first_non_repeating_element {
  /**
   * Q. First Non Repeating element
   *
   * Given an integer array A of size N, find the first repeating element in it.
   *
   * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
   *
   * If there is no repeating element, return -1.
   *
   * Problem Constraints
   * 1 <= N <= 10^5
   * 1 <= A[i] <= 10^9
   *
   * Input Format
   * The first and only argument is an integer array A of size N.
   *
   * Output Format
   * Return an integer denoting the first repeating element.
   */
  public static int getFirstNonRepeatingElement(ArrayList<Integer> A) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int a : A) {
      if(hm.containsKey(a)) {
        hm.put(a, hm.get(a) + 1);
      } else {
        hm.put(a, 1);
      }
    }

    for(int a : A) {
      if(hm.get(a) == 1) {
        return a;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(getFirstNonRepeatingElement(new ArrayList<>(Arrays.asList(10, 5, 3, 4, 3, 5, 10))));
  }
}
