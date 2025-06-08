package com.dsa.problems.scaler.hashing;

import java.util.*;

public class longest_substring_without_repeat {
  /**
   * Q. Longest Substring Without Repeat
   *
   * Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
   * Your task is to return an integer representing the "GOOD"ness of string A.
   * Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
   *
   * Problem Constraints
   * 1 <= size(A) <= 10^6
   *
   * String consists of lowerCase,upperCase characters and digits are also present in the string A.
   *
   * Input Format
   * Single Argument representing string A.
   *
   * Output Format
   * Return an integer denoting the maximum possible length of substring without repeating characters.
   */
  private static int longestSubstringWithoutRepeat(String A) {
    HashSet<Character> hs = new HashSet<>();

    int x = 0, y = 0;
    int ans = 0;
    while(y < A.length()) {
      if(hs.contains(A.charAt(y))) {
        while(hs.contains(A.charAt(y))) {
          hs.remove(A.charAt(x));
          x++;
        }
      }
      hs.add(A.charAt(y));
      ans = Math.max(ans, hs.size());
      y++;
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestSubstringWithoutRepeat("abcabcd"));
  }
}
