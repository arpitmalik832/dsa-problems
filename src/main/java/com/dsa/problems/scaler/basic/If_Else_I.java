/**
 * Given an integer age as input, print whether the person is eligible to vote or not.
 *
 * Input 1: 20
 *
 * Input 2: 14
 *
 * Output 1: Yes
 *
 * Output 2: No
 */
package com.dsa.problems.scaler.basic;

import java.util.*;

public class If_Else_I {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int age = sc.nextInt();
      if (age >= 18) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
