package com.dsa.problems.scaler.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class towerOfHanoi {
  public static void moveDiscs(int n, int start, int dest, int buffer, ArrayList<ArrayList<Integer>> rslt) {
    if(n == 1) {
      rslt.add(new ArrayList<>(Arrays.asList(n, start, dest)));
      return;
    }

    moveDiscs(n - 1, start, buffer, dest, rslt);
    rslt.add(new ArrayList<>(Arrays.asList(n, start, dest)));
    moveDiscs(n - 1, buffer, dest, start, rslt);
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
    moveDiscs(3, 1, 3, 2, rslt);
    System.out.println(rslt);
  }
}
