package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class subsets {
  public static ArrayList<ArrayList<Integer>> fundSubsets(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
    int n = A.size();
    int total = 1 << n;
    for(int i = 0; i < total; i++) {
      ArrayList<Integer> subset = new ArrayList<>();
      for(int j = 0; j < n; j++) {
        if((i & (1 << j)) != 0) {
          subset.add(A.get(j));
        }
      }
      rslt.add(subset);
    }
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(fundSubsets(new ArrayList<>(Arrays.asList(1, 2, 3))));
  }
}
