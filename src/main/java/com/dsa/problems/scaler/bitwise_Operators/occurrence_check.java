package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class occurrence_check {
  public static int soln(ArrayList<Integer> A) {
    int rslt = 0;
    for(int i : A) {
      rslt ^= i;
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 3, 2, 1, 3))));
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 3, 5, 1, 3))));
  }
}
