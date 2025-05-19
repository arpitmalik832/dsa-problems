/**
 * Merge Sorted Overlapping Intervals
 *
 * You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.
 *
 * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 100000.
 * 1 <= A[i][0] <= A[i][1] <= 100000
 *
 * A is sorted based on the start value (A[i][0])
 *
 * Input Format
 *
 * First argument is a list of intervals in 2-Dimensional Array.
 *
 * Output Format
 *
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 * Example Input
 *
 * Input 1:
 * [ [1, 3], [2, 6], [8, 10], [15, 18] ]
 *
 * Input 2:
 * [ [2, 10], [4, 9], [6, 7] ]
 *
 * Example Output
 *
 * Output 1:
 * [ [1, 6], [8, 10], [15, 18] ]
 *
 * Output 2:
 * [ [2, 10] ]
 *
 */

/** Approach 1: Brute Force Solution
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
package com.dsa.problems.One_D_Array;

import java.util.*;

public class Merge_Intervals {
  public static ArrayList<ArrayList<Integer>> soln(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
    ArrayList<Integer> current = A.get(0);

    for (int i = 1; i < n; i++) {
      if (current.get(1) >= A.get(i).get(0)) {
        current.set(1, Math.max(current.get(1), A.get(i).get(1)));
      } else {
        rslt.add(current);
        current = A.get(i);
      }
    }

    rslt.add(current);

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(
        soln(new ArrayList<ArrayList<Integer>>(Arrays.asList(
            new ArrayList<Integer>(Arrays.asList(1, 3)),
            new ArrayList<Integer>(Arrays.asList(2, 5)),
            new ArrayList<Integer>(Arrays.asList(6, 9))))));
  }
}
