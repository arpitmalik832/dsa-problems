package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class partition_index {
  /**
   * Q. Partition Index
   *
   * Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:
   *
   * if A[i] < p then it should be present on left side of the partition
   * if A[i] > p then it should be present on right side of the partition
   * Rearrange the given array as well as return the partition index.
   *
   * Note: All elements are distinct
   */
  private static int partition(ArrayList<Integer> A) {
    int n = A.size();
    int temp = A.get(0);
    A.set(0, A.get(n - 1));
    A.set(n - 1, temp);

    int pivot = A.get(0);
    int left = 1, right = n - 1;
    while(left <= right) {
      if(A.get(left) < pivot) {
        left++;
      } else if(A.get(right) > pivot) {
        right--;
      } else {
        temp = A.get(left);
        A.set(left, A.get(right));
        A.set(right, A.get(left));
        left++;
        right--;
      }
    }
    temp = A.get(0);
    A.set(0, A.get(right));
    A.set(right, temp);

    return right;
  }

  public static void main(String[] args) {
    System.out.println(partition(new ArrayList<>(Arrays.asList(5,4,5,6,1,7,5,4,6))));
  }
}
