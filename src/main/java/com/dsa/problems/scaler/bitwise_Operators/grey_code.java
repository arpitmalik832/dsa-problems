package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;

public class grey_code {
  public static ArrayList<Integer> greyCode(int A) {
    ArrayList<Integer> rslt = new ArrayList<>();

    for(int i = 0; i < (1 << A); i++) {
      rslt.add(i ^ (i >> 1));
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(greyCode(2));
    System.out.println(greyCode(3));
  }
}
