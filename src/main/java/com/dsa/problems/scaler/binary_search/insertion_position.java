package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class insertion_position {
  private static int insertionPosition(ArrayList<Integer> A, int B) {
    final int n = A.size();
    int i = 0, j = n - 1;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m) == B) {
        return m;
      } else if(A.get(m) < B) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    return i;
  }

  public static void main(String[] args) {
    System.out.println(insertionPosition(new ArrayList<>(Arrays.asList(2,3,4,5,7)), 6));
  }
}
