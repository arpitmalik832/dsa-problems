/**
 *  Boundary Traversal
 */

package com.dsa.problems.Two_D_Array;

import java.util.*;

public class Boundary_traversal {
  public static ArrayList<Integer> soln(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    int m = A.get(0).size();

    ArrayList<Integer> boundary = new ArrayList<>();

    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = m - 1;

    int count = 0;
    while (count < m + (n - 1) + (m - 1) + (n - 2)) {
      for (int i = left; i <= right; i++) {
        boundary.add(A.get(top).get(i));
        count++;
      }
      top++;

      for (int i = top; i <= bottom; i++) {
        boundary.add(A.get(i).get(right));
        count++;
      }
      right--;

      if (left <= right) {
        for (int i = right; i >= left; i--) {
          boundary.add(A.get(bottom).get(i));
          count++;
        }
        bottom--;
      }

      if (top <= bottom) {
        for (int i = bottom; i >= top; i--) {
          boundary.add(A.get(i).get(left));
          count++;
        }
        left++;
      }
    }

    return boundary;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<ArrayList<Integer>>(Arrays.asList(
        new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),
        new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8)),
        new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12))))));
  }
}
