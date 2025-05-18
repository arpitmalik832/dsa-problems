/**
 * Given two integers A and B as input, print whether the larger one.
 *
 * Input 1: 20, 14
 *
 * Input 2: 14, 13
 *
 * Output 1: 20
 *
 * Output 2: 14
 */
package com.dsa.problems.basic;

import java.util.*;

public class If_Else_II {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      if (A > B) {
        System.out.println(A);
      } else {
        System.out.println(B);
      }
    }
  }
}
