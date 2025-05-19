/**
 * You are given an array of integers arr[]. Your task is to reverse the given array.
 *
 * Note: Modify the array in place.
 *
 * Examples:
 *
 * Input: arr = [1, 4, 3, 2, 6, 5]
 * Output: [5, 6, 2, 3, 4, 1]
 * Explanation: The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is 5 6 2 3 4 1.
 *
 * Input: arr = [4, 5, 2]
 * Output: [2, 5, 4]
 * Explanation: The elements of the array are 4 5 2. The reversed array will be 2 5 4.
 *
 * Input: arr = [1]
 * Output: [1]
 * Explanation: The array has only single element, hence the reversed array is same as the original.
 *
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 0 <= arr[i] <= 10^5
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Initialize two pointers, left and right
 * 2. Swap the elements at the left and right pointers
 * 3. Move the left pointer to the right and the right pointer to the left
 * 4. Repeat until the left pointer is greater than the right pointer
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Reverse_an_array {
  public static ArrayList<Integer> reverseArray(ArrayList<Integer> arr) {
    int left = 0;
    int right = arr.size() - 1;
    while (left < right) {
      Collections.swap(arr, left, right);
      left++;
      right--;
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(reverseArray(new ArrayList<>(Arrays.asList(1, 4, 3, 2, 6, 5))));
    System.out.println(reverseArray(new ArrayList<>(Arrays.asList(4, 5, 2))));
    System.out.println(reverseArray(new ArrayList<>(Arrays.asList(1))));
  }
}
