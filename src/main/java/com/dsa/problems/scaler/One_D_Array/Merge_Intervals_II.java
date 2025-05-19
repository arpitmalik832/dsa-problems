/**
 * Merge Intervals - 2
 *
 * You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Problem Constraints
 *
 * 0 <= |intervals| <= 105
 *
 * Input Format
 *
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 * Output Format
 *
 * Return the vector of intervals after merging
 *
 * Example Input
 *
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 *
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 * Example Output
 *
 * Output 1:
 *
 * [ [1, 5], [6, 9] ]
 *
 * Output 2:
 *
 * [ [1, 9] ]
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 *
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 *
 */

package com.dsa.problems.scaler.One_D_Array;

import java.util.*;

public class Merge_Intervals_II {
  public static ArrayList<ArrayList<Integer>> soln(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {
    int n = A.size();

    boolean isInserted = false;
    for (int i = 0; i < n; i++) {
      if (B.get(0) < A.get(i).get(0) || (B.get(0) == A.get(i).get(0) && B.get(1) <= A.get(i).get(1))) {
        A.add(i, B);
        isInserted = true;
      }
    }

    if (!isInserted) {
      A.add(B);
    }

    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
    n = A.size();
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
            new ArrayList<Integer>(Arrays.asList(6, 9)))),
            new ArrayList<Integer>(Arrays.asList(2, 5))));
  }
}
