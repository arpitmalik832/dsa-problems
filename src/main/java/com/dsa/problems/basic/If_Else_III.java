/**
 * Q3. Given temperature of patient in fahrenheit as input. Print whether temperature is low, normal or high. The normal temp range is from 98.2 to 98.8.
 * 
 * Input 1: 98.1
 *
 * Output 1: low
 *
 * Input 2: 98.5
 *
 * Output 2: normal
 *
 * Input 3: 99.3
 *
 * Output 3: high
 */
package com.dsa.problems.basic;

import java.util.*;

public class If_Else_III {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      double temp = sc.nextDouble();
      if (temp < 98.2) {
        System.out.println("low");
      } else if (temp >= 98.2 && temp <= 98.8) {
        System.out.println("normal");
      } else {
        System.out.println("high");
      }
    }
  }
}
