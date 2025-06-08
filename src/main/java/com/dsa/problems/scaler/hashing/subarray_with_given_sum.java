package com.dsa.problems.scaler.hashing;

import java.util.*;

public class subarray_with_given_sum {
  /**
   * Q. Subarray with given sum
   *
   * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
   * If the answer does not exist return an array with a single integer "-1".
   * First sub-array means the sub-array for which starting index in minimum.
   *
   * Problem Constraints
   * 1 <= length of the array <= 100000
   * 1 <= A[i] <= 10^9
   * 1 <= B <= 10^9
   *
   * Input Format
   * The first argument given is the integer array A.
   * The second argument given is integer B.
   *
   * Output Format
   * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
   */
  private static ArrayList<Integer> subarraryWithGivenSum(ArrayList<Integer> A, int B) {
    ArrayList<Integer> pf = new ArrayList<>();
    pf.add(A.get(0));

    for(int i = 1; i < A.size(); i++) {
      pf.add(pf.get(i - 1) + A.get(i));
    }

    int start = Integer.MAX_VALUE;
    int length = 0; 
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i = 0; i < pf.size(); i++) {
      if(pf.get(i) == B) {
        if(i < start) {
          start = 0;
          length = i + 1;
        }
      }

      if(hm.containsKey(pf.get(i) - B)) {
        int tempStart = hm.get(pf.get(i) - B);
        if(tempStart < start) {
          start = tempStart + 1;
          length = i - tempStart;
        }
      } else {
        hm.put(pf.get(i), i);
      }
    }

    ArrayList<Integer> rslt = new ArrayList<>();
    if(length == 0) {
      return new ArrayList<>(Arrays.asList(-1));
    }
    for(int i = start; i < start + length; i++) {
      rslt.add(A.get(i));
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(subarraryWithGivenSum(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 5));
  }
}
