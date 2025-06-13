package com.dsa.problems.scaler.sort;

import java.util.*;

public class sort_by_color {
  /**
   * Q. Sort by Color
   *
   * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
   *
   * We will represent the colors as,
   *
   * red -> 0
   * white -> 1
   * blue -> 2
   *
   * Note: Using the library sort function is not allowed.
   */  
  private static void sortByColor(ArrayList<Integer> A) {
    ArrayList<Integer> freq = new ArrayList<>();
    for(int i = 0; i < 3; i++) {
      freq.add(0);
    }

    for(int i = 0; i < A.size(); i++) {
      freq.set(A.get(i), freq.get(A.get(i)) + 1);
    }

    int k = 0;
    for(int i = 0; i < 3; i++) {
      for(int x = 0; x < freq.get(i); x++) {
        A.set(k++, i);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,1,2,1,2,1,0,1,0,0,1,0));
    sortByColor(A);
    System.out.println(A);
  }
}
