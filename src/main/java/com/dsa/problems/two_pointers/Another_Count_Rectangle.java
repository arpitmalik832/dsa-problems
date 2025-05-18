/**
 * Given a sorted array of distinct integers A and an integer B, find and return how many rectangles
 * with distinct configurations can be created using elements of this array as length and breadth
 * whose area is lesser than B.
 *
 */
package com.dsa.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Another_Count_Rectangle {
  public static int countRectangles(ArrayList<Integer> A, int B) {
    final int MOD = 1000000007;
    int n = A.size();
    int count = 0;
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      long area = (long) A.get(left) * A.get(right);
      if (area < B) {
        count = (count + 2 * (right - left + 1) - 1) % MOD;
      }
      if (area >= B) {
        right--;
      } else {
        left++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(countRectangles(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 5)); // 8
  }
}
