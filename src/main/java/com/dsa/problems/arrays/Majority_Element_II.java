/**
 * Boyer-Moore Voting Algorithm
 *
 * Given an array of integers where each number represents a vote to a candidate,
 * return the candidates that have votes greater than one-third of the total votes.
 * If there's no majority vote, return an empty array.
 *
 * Examples:
 * Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 * Output: [5, 6]
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: []
 */

/**
 * Using Boyer-Moore Voting Algorithm
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Initialize two candidates and their counts
 * 2. Iterate through the array and update the candidates and their counts
 * 3. After the first pass, verify the candidates
 * 4. Add the candidates that meet the threshold to the result
 * 5. Sort the result in increasing order
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Majority_Element_II {
  public static ArrayList<Integer> majorityElement(ArrayList<Integer> arr) {
    int n = arr.size();
    int threshold = n / 3;
    ArrayList<Integer> result = new ArrayList<>();

    // Initialize candidates and their counts
    int candidate1 = 0,
        candidate2 = 0;
    int count1 = 0,
        count2 = 0;

    // First pass: Find potential candidates
    for (int num : arr) {
      if (num == candidate1) {
        count1++;
      } else if (num == candidate2) {
        count2++;
      } else if (count1 == 0) {
        candidate1 = num;
        count1 = 1;
      } else if (count2 == 0) {
        candidate2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    // Second pass: Verify candidates
    count1 = 0;
    count2 = 0;

    for (int num : arr) {
      if (num == candidate1)
        count1++;
      else if (num == candidate2)
        count2++;
    }

    // Add candidates that meet the threshold
    if (count1 > threshold)
      result.add(candidate1);
    if (count2 > threshold)
      result.add(candidate2);

    // Sort the result in increasing order
    Collections.sort(result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(majorityElement(new ArrayList<>(Arrays.asList(2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6)))); // [5, 6]
    System.out.println(majorityElement(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))); // []
    System.out.println(majorityElement(new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3, 2, 2, 2)))); // [1, 2]
    System.out.println(majorityElement(new ArrayList<>(Arrays.asList(1, 3)))); // [1, 3]
  }
}
