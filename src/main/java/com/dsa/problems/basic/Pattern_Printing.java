/**
 * Q7. Manual pattern printing - 1
 *
 * Print the following pattern in output
 *
 * *****
 * ****
 * ***
 * **
 * *
 */
package com.dsa.problems.basic;

public class Pattern_Printing {
  public static void main(String[] args) {
    for (int i = 5; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
