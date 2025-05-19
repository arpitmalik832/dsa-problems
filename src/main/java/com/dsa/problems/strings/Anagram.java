/**
 * Anagram - Optimized version using single frequency array
 * Time Complexity: O(n)
 * Space Complexity: O(1) - using single array of fixed size 26
 */

package com.dsa.problems.strings;

public class Anagram {
  public static int soln(String A, String B) {
    int n = A.length();
    int m = B.length();

    if (n != m)
      return 0;

    // Single frequency array
    int[] freq = new int[26];

    // Increment count for chars in A, decrement for chars in B
    for (int i = 0; i < n; i++) {
      freq[A.charAt(i) - 'a']++;
      freq[B.charAt(i) - 'a']--;
    }

    // If strings are anagrams, all frequencies should be 0
    for (int i = 0; i < 26; i++) {
      if (freq[i] != 0)
        return 0;
    }

    return 1;
  }

  public static void main(String[] args) {
    System.out.println(soln("abc", "acb")); // 1
    System.out.println(soln("abc", "acd")); // 0
    System.out.println(soln("geeks", "kseeg")); // 1
  }
}
