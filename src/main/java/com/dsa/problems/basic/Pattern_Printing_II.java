/**
 * Q8. Manual pattern printing - 2
 *
 * Print the following pattern in output
 * 
 *     *
 *    **
 *   ***
 *  ****
 * *****
 */
package com.dsa.problems.basic;

public class Pattern_Printing_II {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (int k = 0; k < 5 - i - 1; k++) {
        System.out.print(" ");
      }
      for (int j = 0; j < i + 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
