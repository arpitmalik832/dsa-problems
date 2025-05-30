package com.dsa.problems.scaler.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class print_arr {
  public static void printArrRec(ArrayList<Integer> A, int i) {
    if(i == A.size()) {
      return;
    }

    System.out.print(A.get(i) + " ");
    printArrRec(A, i + 1);
  }

  public static void printArr(ArrayList<Integer> A)  {
    printArrRec(A, 0);
  }

  public static void main(String[] args) {
    printArr(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
  }
}
