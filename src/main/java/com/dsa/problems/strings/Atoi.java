package com.dsa.problems.strings;

public class Atoi {
  public static int soln(String s) {
    s = s.trim();
    final boolean isNegative = s.charAt(0) == '-';

    long num = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        num = num * 10 + (int) (s.charAt(i) - '0');
      } else if (s.charAt(i) != '-' && s.charAt(i) != '+') {
        break;
      }
    }

    if (num > 0 && isNegative)
      num = -num;

    final int upperLimit = (int) Math.pow(2, 31) - 1;
    final int lowerLimit = (int) -Math.pow(2, 31);
    if (num > upperLimit) {
      return upperLimit;
    }
    if (num < lowerLimit) {
      return lowerLimit;
    }

    return (int) num;
  }

  public static void main(String[] args) {
    System.out.println(soln("-0012gfg4")); // -12
    System.out.println(soln("42")); // 42
    System.out.println(soln("   -42")); // -42
    System.out.println(soln("4193 with words")); // 4193
    System.out.println(soln("words and 987")); // 0
    System.out.println(soln("-91283472332")); // -2147483648

  }
}
