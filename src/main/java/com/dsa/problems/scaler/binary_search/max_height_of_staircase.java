package com.dsa.problems.scaler.binary_search;

public class max_height_of_staircase {
  private static int maxHeightOfStairCase(int A) {
    int x1 = (int)Math.floor((-1 + Math.sqrt(1 + 8 * A))/ 2);
    int x2 = (int)Math.floor((-1 - Math.sqrt(1 + 8 * A))/ 2);
    return Math.max(x1, x2);
  }

  public static void main(String[] args) {
    System.out.println(maxHeightOfStairCase(10));
    System.out.println(maxHeightOfStairCase(20));
  }
}
