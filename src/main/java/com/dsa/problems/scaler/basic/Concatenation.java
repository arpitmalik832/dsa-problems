/**
 * A says Hi to B
 *
 * Take two names A and B as input from the user, print "A says Hi to B" (Without quotations), where A and B are the names in input.
 *
 * Problem Constraints
 * 
 * 1 <= len(A), len(B) <= 15
 * Characters in A and B are in lowercase English Alphabets.
 *
 *
 * Input Format
 *
 * There are two input lines
 * The first line has a string A.
 * The second line has a string B.
 *
 * Output Format
 *
 * Print in a single line A says Hi to B.
 */
package com.dsa.problems.scaler.basic;

import java.util.*;

public class Concatenation {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String A = sc.next();
      String B = sc.next();
      System.out.println(A + " says Hi to " + B);
    }
  }
}
