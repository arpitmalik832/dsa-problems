package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class max_chunks_to_make_sorted {
  /**
   * Q. Max Chunks To Make Sorted
   *
   * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.
   *
   * What is the most number of chunks we could have made?
   */
  private static int maxChunksToMakeSorted(ArrayList<Integer> A) {
    int max = Integer.MIN_VALUE;

    int chunks = 0;
    for(int i = 0; i < A.size(); i++) {
      max = Math.max(max, A.get(i));
      if(A.get(i) == i) {
        chunks++;
      }
    }

    return chunks;
  }

  public static void main(String[] args) {
    System.out.println(maxChunksToMakeSorted(new ArrayList<>(Arrays.asList(0,2,1,3))));
  }
}
