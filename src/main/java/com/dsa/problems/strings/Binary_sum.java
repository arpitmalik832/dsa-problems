/**
 * Given two binary strings A and B, return their sum (also a binary string).
 *
 * Example:
 * Input: A = "100", B = "11"
 * Output: "111"
 */

package com.dsa.problems.strings;

import java.util.ArrayList;

public class Binary_sum {
  public static String soln(String A, String B) {
    ArrayList<Character> aArr = new ArrayList<>();
    ArrayList<Character> bArr = new ArrayList<>();

    for (int i = 0; i < A.length(); i++) {
      aArr.add(A.charAt(i));
    }
    for (int i = 0; i < B.length(); i++) {
      bArr.add(B.charAt(i));
    }

    int k = 0;
    while (k < aArr.size() && aArr.get(k) == '0') {
      k++;
    }
    if (k > 0) {
      aArr.subList(0, k).clear();
    }

    k = 0;
    while (k < bArr.size() && bArr.get(k) == '0') {
      k++;
    }
    if (k > 0) {
      bArr.subList(0, k).clear();
    }

    int n = aArr.size();
    int m = bArr.size();

    int i = n - 1;
    int j = m - 1;
    int carry = 0;
    StringBuilder finalSum = new StringBuilder();

    while (i >= 0 || j >= 0 || carry > 0) {
      int sum = carry;
      if (i >= 0) {
        sum += Character.getNumericValue(aArr.get(i));
        i--;
      }
      if (j >= 0) {
        sum += Character.getNumericValue(bArr.get(j));
        j--;
      }

      carry = sum / 2;
      sum = sum % 2;

      finalSum.insert(0, sum);
    }

    return finalSum.toString();
  }

  public static void main(String[] args) {
    System.out.println(soln("100", "11")); // "111"
    System.out.println(soln("1101", "111")); // "10100"
    System.out.println(soln("01001001", "0110101")); // "1011110"
  }
}
