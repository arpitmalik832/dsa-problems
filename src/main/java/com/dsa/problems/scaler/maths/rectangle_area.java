package com.dsa.problems.scaler.maths;

public class rectangle_area {
  /**
   * Q. Rectangle Area
   *
   * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
   *
   * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
   *
   * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
   */
  private static int rectangleArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int tempArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
    if (bx2 <= ax1 || by2 <= ay1 || bx1 >= ax2 || by1 >= ay2) {
      return tempArea;
    }
    int tempX1 = Math.max(ax1, bx1);
    int tempX2 = Math.min(ax2, bx2);
    int tempY1 = Math.max(ay1, by1);
    int tempY2 = Math.min(ay2, by2);
    return tempArea - (tempX2 - tempX1) * (tempY2 - tempY1);
  }

  public static void main(String[] args) {
    System.out.println(rectangleArea(0, 0, 0, 0, 0, 0, 0, 0));
  }
}