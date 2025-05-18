/**
 * Given an array of integers A of size N, where A[i] represents the height of the ith wall. Find the maximum amount of water that can be trapped in the walls.
 *
 * The amount of water that can be trapped in the walls is the difference between the height of the wall and the height of the water level.
 *
 * The water level is the minimum of the height of the wall and the height of the water level.
 *
 */
package com.dsa.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Area_Containing_Max_Water {
  public static int maxWaterTrapped(ArrayList<Integer> A) {
    int n = A.size();

    int i = 0;
    int j = n - 1;

    int maxWater = 0;

    while (i < j) {
      int water = Math.min(A.get(i), A.get(j)) * (j - 1);
      maxWater = Math.max(maxWater, water);

      if (A.get(i) < A.get(j)) {
        i++;
      } else {
        j--;
      }
    }

    return maxWater;
  }

  public static void main(String[] args) {
    System.out.println(maxWaterTrapped(new ArrayList<Integer>(Arrays.asList(1, 5, 4, 3))));
  }
}
