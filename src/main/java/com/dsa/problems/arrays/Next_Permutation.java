/**
 * Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges
 * the numbers into the lexicographically next greater permutation. If no such permutation exists,
 * rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
 *
 * Examples:
 * Input: arr = [2, 4, 1, 7, 5, 0]
 * Output: [2, 4, 5, 0, 1, 7]
 *
 * Input: arr = [3, 2, 1]
 * Output: [1, 2, 3]
 *
 * Input: arr = [3, 4, 2, 5, 1]
 * Output: [3, 4, 5, 1, 2]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Find the first pair from right where arr[i] < arr[i+1]
 * 2. If no such pair is found, reverse the array
 * 3. If such a pair is found, find the number greater than arr[i] and closest to the last index
 * 4. Swap the numbers
 * 5. Reverse the suffix after i
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Next_Permutation {
  public static ArrayList<Integer> nextPermutation(ArrayList<Integer> arr) {
    int n = arr.size();
    int i = n - 2;

    // Find the first pair from right where arr[i] < arr[i+1]
    while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
      i--;
    }

    if (i >= 0) {
      int j = n - 1;
      // Find the smallest number greater than arr[i]
      while (j > i && arr.get(j) <= arr.get(i)) {
        j--;
      }
      // Swap the numbers
      Collections.swap(arr, i, j);
    }

    // Reverse the suffix after i
    int left = i + 1;
    int right = n - 1;
    while (left < right) {
      Collections.swap(arr, left, right);
      left++;
      right--;
    }

    return arr;
  }

  public static void main(String[] args) {
    System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(2, 4, 1, 7, 5, 0)))); // [2, 4, 5, 0, 1, 7]
    System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(3, 2, 1)))); // [1, 2, 3]
    System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(3, 4, 2, 5, 1)))); // [3, 4, 5, 1, 2]
  }
}
