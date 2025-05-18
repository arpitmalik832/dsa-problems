/**
 * 3 Sum
 *
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 *
 * Assume that there will only be one solution.
 *
 * Problem Constraints
 *
 * -10^8 <= B <= 10^8
 * 1 <= N <= 10^4
 * -10^8 <= A[i] <= 10^8
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer B denoting the sum you need to get close to.
 *
 * Output Format
 *
 * Return a single integer denoting the sum of three integers which is closest to B.
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [-1, 2, 1, -4]
 * B = 1
 *
 * Input 2:
 *
 * A = [1, 2, 3]
 * B = 6
 *
 * Example Output
 *
 * Output 1:
 *
 * 2
 *
 * Output 2:
 *
 * 6
 */

package com.dsa.problems.two_pointers;

import java.util.*;

public class Three_Sum {
  public static int threeSumClosest(ArrayList<Integer> A, int B) {
    A.sort((a, b) -> a - b);
    int n = A.size();
    int closestSum = A.get(0) + A.get(1) + A.get(2);
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int sum = A.get(j) + A.get(k) + A.get(i);
        if (sum == B) {
          return B;
        }
        if (Math.abs(B - sum) < Math.abs(B - closestSum)) {
          closestSum = sum;
        }
        if (sum > B) {
          k--;
        } else {
          j++;
        }
      }
    }

    return closestSum;
  }

  public static void main(String[] args) {
    System.out.println(threeSumClosest(new ArrayList<Integer>(Arrays.asList(-1, 2, 1, -4)), 1));
    System.out.println(threeSumClosest(new ArrayList<Integer>(Arrays.asList(5, -2, -1, -10, 10)), 5));
  }
}
