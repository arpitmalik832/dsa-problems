package com.dsa.problems.scaler.prefix_sum;

import java.util.ArrayList;
import java.util.Scanner;

public class In_Place_Prefix_Sum {
  public static void inPlacePrefixSum(ArrayList<Integer> A) {
    int n = A.size();
    for (int i = 1; i < n; i++) {
      A.set(i, A.get(i) + A.get(i - 1));
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ArrayList<Integer> A = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        A.add(sc.nextInt());
      }
      inPlacePrefixSum(A);
      System.out.println(A);
    }
  }
}
