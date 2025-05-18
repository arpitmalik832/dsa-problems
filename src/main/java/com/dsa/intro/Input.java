package com.dsa.intro;

import java.util.*;

public class Input {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int i = sc.nextInt();
      System.out.println(i);

      double d = sc.nextDouble();
      System.out.println(d);

      long l = sc.nextLong();
      System.out.println(l);

      float f = sc.nextFloat();
      System.out.println(f);

      String s = sc.next(); // scan a word
      System.out.println(s);

      String a1 = sc.nextLine(); // scan the entire line
      System.out.println(a1);

      // Take 2 names X and Y as input and print X loves Y.
      String X = sc.next();
      String Y = sc.next();
      System.out.println(X + " loves " + Y);

      // Take name X and age Y as input and print X age is Y.
      String name = sc.next();
      int age = sc.nextInt();
      System.out.println(name + "'s age is " + age);
    }
  }
}
