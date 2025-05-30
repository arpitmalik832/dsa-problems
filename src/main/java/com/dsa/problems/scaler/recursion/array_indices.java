package com.dsa.problems.scaler.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class array_indices {

  public static void getIndicesRec(ArrayList<Integer> A, int B, int i, ArrayList<Integer> rslt) {
    if(i == A.size()) {
      return;
    }

    if(A.get(i) == B) {
      rslt.add(i);
    }

    getIndicesRec(A, B, i + 1, rslt);
  }
  
  public static ArrayList<Integer> getIndices(ArrayList<Integer> A, int B) {
    ArrayList<Integer> rslt = new ArrayList<>();
    getIndicesRec(A, B, 0, rslt);
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(getIndices(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 3));
  }
}
