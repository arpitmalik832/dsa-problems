/**
 * Return the first non-repeating character in a string
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(1) as we use fixed size array of 26 chars
 * Assumption: String contains only lowercase letters
 */
package com.dsa.problems.strings;

public class NonRepeatingChar {
  public static String soln(String A) {
    int n = A.length();

    // Create fixed size array for lowercase letters (a-z)
    int[] freq = new int[26];

    // Count frequency of each character
    for (int i = 0; i < n; i++) {
      freq[A.charAt(i) - 'a']++;
    }

    // Find first char with frequency 1
    for (int i = 0; i < n; i++) {
      if (freq[A.charAt(i) - 'a'] == 1) {
        return String.valueOf(A.charAt(i));
      }
    }

    return "$";
  }

  public static void main(String[] args) {
    System.out.println(soln("abcabd")); // "c"
    System.out.println(soln("abcabc")); // "$"
    System.out.println(soln("abcd")); // "a"
  }
}
