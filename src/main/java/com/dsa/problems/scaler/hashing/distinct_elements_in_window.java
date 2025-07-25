package com.dsa.problems.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class distinct_elements_in_window {
  /**
   * Q. Distinct Numbers in Window
   *
   * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
   * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
   * NOTE: if B > N, return an empty array.
   *
   * Problem Constraints
   * 1 <= N <= 106
   * 1 <= A[i] <= 109
   *
   * Input Format
   * First argument is an integer array A
   * Second argument is an integer B.
   *
   * Output Format
   * Return an integer array.
   *
   * Example Input
   * Input 1:
   * A = [1, 2, 1, 3, 4, 3]
   * B = 3
   *
   * Input 2:
   * A = [1, 1, 2, 2]
   * B = 1
   *
   * Example Output
   * Output 1:
   * [2, 3, 3, 2]
   *
   * Output 2:
   * [1, 1, 1, 1]
   */
  public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> A, int B) {
    if(B > A.size()) {
      return new ArrayList<>();
    }

    HashMap<Integer, Integer> hm = new HashMap<>();
    int i = 0;
    int j = i + B - 1;
    ArrayList<Integer> rslt = new ArrayList<>();
    for(int x = i; x <= j; x++) {
      if(hm.containsKey(A.get(x))) {
        hm.put(A.get(x), hm.get(A.get(x)) + 1);
      } else {
        hm.put(A.get(x), 1);
      }
    }
    rslt.add(hm.size());
    j++;
    while(j < A.size()) {
      if(hm.containsKey(A.get(j))) {
        hm.put(A.get(j), hm.get(A.get(j)) + 1);
      } else {
        hm.put(A.get(j), 1);
      }
      if(hm.get(A.get(i)) == 1) {
        hm.remove(A.get(i));
      } else {
        hm.put(A.get(i), hm.get(A.get(i)) - 1);
      }
      rslt.add(hm.size());
      i++;
      j++;
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(countDistinctElements(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3));
  }
}
