package com.dsa.problems.scaler.Two_D_Array;

import java.util.*;

public class rotate_image {
  /**
   * Q. Rotate Image
   *
   * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
   *
   * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
   */
  /**
   * Approach: reversal along horizontal axis and transpose of the matrix.
   */
  private static void rotateImage(ArrayList<ArrayList<Integer>> A) {
    int i = 0;
    final int n = A.size();
    while(i <= (int)((n - 1) / 2)) {
      ArrayList<Integer> temp = A.get(i);
      A.set(i, A.get(n - 1 - i));
      A.set(n - 1 - i, temp);
      i++;
    }

    for(i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        int temp = A.get(i).get(j);
        A.get(i).set(j , A.get(j).get(i));
        A.get(j).set(i, temp);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    a.add(new ArrayList<>(Arrays.asList(1,2,3)));
    a.add(new ArrayList<>(Arrays.asList(4,5,6)));
    a.add(new ArrayList<>(Arrays.asList(7,8,9)));
    rotateImage(a);
    System.out.println(a);
  }

}
