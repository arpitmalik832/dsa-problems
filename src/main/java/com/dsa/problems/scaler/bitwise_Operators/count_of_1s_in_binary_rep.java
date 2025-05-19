/**
 * Count of 1s in binary representation of a number
 */
package com.dsa.problems.scaler.bitwise_Operators;

public class count_of_1s_in_binary_rep {
  public static int soln(int A) {
    int count = 0;
    while (A > 0) {
      count += A & 1;
      A >>= 1;
    }
    return count;
  }
}
