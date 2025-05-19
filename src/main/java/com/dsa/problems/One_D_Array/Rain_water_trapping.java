/**
 * Rain Water Trapping
 */
package com.dsa.problems.One_D_Array;

import java.util.*;

public class Rain_water_trapping {

  public static ArrayList<Integer> getPfm(ArrayList<Integer> A) {
    int n = A.size();

    ArrayList<Integer> pfm = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      pfm.add(0);
    }

    pfm.set(0, A.get(0));

    for (int i = 1; i < n; i++) {
      pfm.set(i, Math.max(pfm.get(i - 1), A.get(i)));
    }

    return pfm;
  }

  public static ArrayList<Integer> getSfm(ArrayList<Integer> A) {
    int n = A.size();

    ArrayList<Integer> sfm = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      sfm.add(0);
    }

    sfm.set(n - 1, A.get(n - 1));

    for (int i = n - 2; i >= 0; i--) {
      sfm.set(i, Math.max(sfm.get(i + 1), A.get(i)));
    }

    return sfm;
  }

  public static int soln(ArrayList<Integer> A) {
    int n = A.size();

    ArrayList<Integer> pfm = getPfm(A);
    ArrayList<Integer> sfm = getSfm(A);

    int maxWater = 0;

    for (int i = 0; i < n; i++) {
      maxWater = maxWater + Math.min(pfm.get(i), sfm.get(i)) - A.get(i);
    }

    return maxWater;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<Integer>(Arrays.asList(2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1))));
  }
}

// console.log(soln([2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1])); // 8
