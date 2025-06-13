package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class merge_two_sorted_arrays {
  /**
   * Q. Merge Two Sorted Arrays
   *
   * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
   *
   * Note: A linear time complexity is expected and you should avoid use of any library function.
   */
  private static ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B) {
    int i = 0, j = 0;
    ArrayList<Integer> temp = new ArrayList<>();
    while(i < A.size() && j < A.size()) {
      if(A.get(i) <= B.get(j)) {
        temp.add(A.get(i++));
      } else {
        temp.add(B.get(j++));
      }
    }
    while(i < A.size()) {
      temp.add(A.get(i++));
    }
    while(j < B.size()) {
      temp.add(B.get(j++));
    }

    return temp;
  }

  public static void main(String[] args) {
    System.out.println(merge(new ArrayList<>(Arrays.asList(2,3,5)), new ArrayList<>(Arrays.asList(1,4,6,7))));
  }
}
