/**
 * Days In Month
 *
 * You are given an integer A.
 *
 * You have to tell how many days are there in the month denoted by A in a non-leap year.
 *
 * Months are denoted as follows:
 *
 * January : 1
 * February : 2
 * March : 3
 * April : 4
 * May : 5
 * June : 6
 * July : 7
 * August : 8
 * September : 9
 * October : 10
 * November : 11
 * December : 12
 */
package com.dsa.problems.scaler.basic;

import java.util.*;

enum MonthDays {
  JANUARY(31),
  FEBRUARY(28),
  MARCH(31),
  APRIL(30),
  MAY(31),
  JUNE(30),
  JULY(31),
  AUGUST(31),
  SEPTEMBER(30),
  OCTOBER(31),
  NOVEMBER(30),
  DECEMBER(31);

  private final int days;

  MonthDays(int days) {
    this.days = days;
  }

  public int getDays() {
    return days;
  }
}

public class Days_in_Month {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int month = sc.nextInt();
      MonthDays monthDays = MonthDays.values()[month - 1];
      System.out.println(monthDays.getDays());
    }
  }
}
