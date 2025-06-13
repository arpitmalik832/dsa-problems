package com.dsa.problems.scaler.Two_D_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class count_intersections {
  /**
   * Count Intersection
   *
   * You are given a 2D array A of length N*3 consisting of N intervals.
   *
   * where interval from A[i][1] to A[i][2] is defined below
   *
   * 1. if A[i][0] = 1 then both A[i][1] and A[i][2] is included in interval
   * 2. if A[i][0] = 2 then A[i][1] is included and and A[i][2] is excluded in interval
   * 3. if A[i][0] = 3 then A[i][1] is excluded and and A[i][2] is included in interval
   * 4. if A[i][0] = 4 then both A[i][1] and A[i][2] is excluded in interval
   *
   * Your task is to find How many pairs of intervals are so their intersection is not null.
   *
   * Problem Constraints
   *
   * 1 <= |A| <= 1000
   * 1 <= A[i][0] <= 4
   * 1 <= A[i][1] <A[i][2] <= 109
   */
  private static int countIntersections(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    ArrayList<ArrayList<Integer>> Q = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      int l = A.get(i).get(1), r = A.get(i).get(2);
      if(A.get(i).get(0) == 2 || A.get(i).get(0) == 4) {
        r -= 0.5;
      }
      if(A.get(i).get(0) == 3 || A.get(i).get(0) == 4) {
        l += 0.5;
      }
      Q.add(new ArrayList<>(Arrays.asList(l, r)));
    }

    int count = 0;
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(!(Q.get(i).get(1) < Q.get(j).get(0) || Q.get(j).get(1) < Q.get(i).get(0))) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    A.add(new ArrayList<>(Arrays.asList(1, 2, 4)));
    A.add(new ArrayList<>(Arrays.asList(2, 2, 3)));
    A.add(new ArrayList<>(Arrays.asList(3, 2, 4)));
    System.out.println(countIntersections(A));
  }
}
