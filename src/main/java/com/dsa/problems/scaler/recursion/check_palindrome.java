package com.dsa.problems.scaler.recursion;

public class check_palindrome {
  public static boolean checkPalindromeRec(String A, int i, int j) {
    if(i >= j) {
      return true;
    }

    if(A.charAt(i) != A.charAt(j)) {
      return false;
    }

    return checkPalindromeRec(A, i + 1, j - 1);
  }

  public static boolean checkPalindrome(String A) {
    return checkPalindromeRec(A, 0, A.length() - 1);
  }

  public static void main(String[] args) {
    System.out.println(checkPalindrome("madam"));
    System.out.println(checkPalindrome("racecar"));
    System.out.println(checkPalindrome("hello"));
    System.out.println(checkPalindrome("level"));
    System.out.println(checkPalindrome("noon"));
    System.out.println(checkPalindrome("radar"));
    System.out.println(checkPalindrome("rotor"));
    System.out.println(checkPalindrome("stats"));
  }
}
