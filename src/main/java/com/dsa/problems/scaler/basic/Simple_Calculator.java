/**
 * Q. A Simple Calculator
 *
 * Given two numbers A and B. Print A+B, A*B, A-B, A/B in the same order.
 *
 * Problem Constraints
 * 
 * 1 <= A, B <= 10^4
 * 
 */

package com.dsa.problems.scaler.basic;

import java.util.*;

public class Simple_Calculator {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      System.out.println(A + B);
      System.out.println(A * B);
      System.out.println(A - B);
      System.out.println(A / B);
    }
  }
}