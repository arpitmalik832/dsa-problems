/**
 * Given a sorted integer array A and an integer B, find the subarray in A with sum equal to B.
 * If no such subarray is found, return an array with a single element -1.
 */
package com.dsa.problems.scaler.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Subarray_Sum_K {
  public static ArrayList<Integer> subarraySum(ArrayList<Integer> A, int B) {
    int i = 0;
    int j = 0;
    int sum = A.get(0);
    int start = -1;
    int length = 0;
    int n = A.size();
    while (j < n) {
      if (sum == B) {
        start = i;
        length = j - i + 1;
        break;
      }
      if (sum < B) {
        j++;
        if (j < n) {
          sum += A.get(j);
        }
      } else {
        sum -= A.get(i);
        i++;
      }
    }
    if (start != -1) {
      ArrayList<Integer> result = new ArrayList<>();
      for (int x = start; x < start + length; x++) {
        result.add(A.get(x));
      }

      return result;
    }

    return new ArrayList<>(Arrays.asList(-1));
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int B = 5;
    System.out.println(subarraySum(A, B));
    A = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
    B = 110;
    System.out.println(subarraySum(A, B));
  }
}
