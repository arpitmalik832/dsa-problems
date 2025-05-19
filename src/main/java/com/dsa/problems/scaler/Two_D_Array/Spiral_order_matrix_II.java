package com.dsa.problems.scaler.Two_D_Array;

import java.util.*;

public class Spiral_order_matrix_II {
  public static ArrayList<ArrayList<Integer>> soln(int A) {
    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();

    int sq = A * A;
    for (int i = 0; i < A; i++) {
      rslt.add(new ArrayList<>());
      for (int j = 0; j < A; j++) {
        rslt.get(i).add(0);
      }
    }

    int num = 1;
    int left = 0;
    int top = 0;
    int right = A - 1;
    int bottom = A - 1;

    while (left <= right && top <= bottom && num <= sq) {
      for (int j = left; j <= right; j++) {
        rslt.get(top).set(j, num);
        num++;
      }
      top++;

      for (int i = top; i <= bottom; i++) {
        rslt.get(i).set(right, num);
        num++;
      }
      right--;

      if (left <= right) {
        for (int j = right; j >= left; j--) {
          rslt.get(bottom).set(j, num);
          num++;
        }
        bottom--;
      }

      if (top <= bottom) {
        for (int i = bottom; i >= top; i--) {
          rslt.get(i).set(left, num);
          num++;
        }
        left++;
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(soln(3));
  }
}
