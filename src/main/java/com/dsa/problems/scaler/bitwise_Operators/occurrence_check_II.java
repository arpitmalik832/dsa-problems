package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class occurrence_check_II {
  public static boolean checkBit(int A, int B) {
    return ((A >> B) & 1) == 1;
  }

  /**
   * Q. Given an integer array where every number is occurring twice except two. Find the numbers which are occurring once.
   */
  public static ArrayList<Integer> soln(ArrayList<Integer> A) {
    int xor = 0;

    for(int i : A) {
      xor ^= i;
    }

    int index = -1;
    for(byte i = 0; i < 32; i++) {
      if(checkBit(xor, i)) {
        index = i;
        break;
      }
    }

    int num1 = 0, num2 = 0;
    for(int i : A) {
      if(checkBit(i, index)) {
        num1 ^= i;
      } else {
        num2 ^= i;
      }
    }

    ArrayList<Integer> rslt = new ArrayList<>();
    if(num1 < num2) {
      rslt.add(num1);
      rslt.add(num2);
    } else {
      rslt.add(num2);
      rslt.add(num1);
    }
    
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3))));
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 5, 1, 2, 3))));
  }
}
