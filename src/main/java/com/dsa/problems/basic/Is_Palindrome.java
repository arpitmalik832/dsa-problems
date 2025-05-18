package com.dsa.problems.basic;

import java.util.*;

public class Is_Palindrome {
  static boolean isPalindrome(int[] A, int start, int end) {
    while (start < end) {
      if (A[start] == A[end]) {
        start++;
        end--;
      } else {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    // YOUR CODE GOES HERE
    // Please take input and print output to standard input/output (stdin/stdout)
    // DO NOT USE ARGUMENTS FOR INPUTS
    // E.g. 'Scanner' for input & 'System.out' for output
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] A = new int[6];
      int i = 0;
      while (n > 0) {
        A[i++] = n % 10;
        n /= 10;
      }

      System.out.println(isPalindrome(A, 0, i - 1) ? "Yes" : "No");
    }
  }
}