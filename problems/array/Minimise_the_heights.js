/**
 * Minimize the Heights
 *
 * Given an array arr[] denoting heights of N towers and a positive integer K.
 *
 * For each tower, you must perform exactly one of the following operations exactly once.
 *
 * Increase the height of the tower by K
 * Decrease the height of the tower by K
 *
 * Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
 *
 * Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.
 *
 * Examples :
 *
 * Input: k = 2, arr[] = {1, 5, 8, 10}
 * Output: 5
 * Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
 *
 * Input: k = 3, arr[] = {3, 9, 12, 16, 20}
 * Output: 11
 * Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11.
 *
 * Constraints:
 * 1 ≤ k ≤ 10^7
 * 1 ≤ n ≤ 10^5
 * 1 ≤ arr[i] ≤ 10^7
 */

/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Sort the array
 * 2. Initialize min and max heights
 * 3. Try different configurations of adding/subtracting k
 * 4. Return the minimum difference that satisfies all constraints
 */
const minimiseHeights = (arr, k) => {
  // Sort the array
  arr.sort((a, b) => a - b);

  // Initial difference
  let minDiff = arr[arr.length - 1] - arr[0];

  // Try different configurations
  for (let i = 0; i < arr.length - 1; i++) {
    // Try adding k to first i elements and subtracting k from rest
    const add = arr[i] + k;
    const subtract = arr[i + 1] - k;

    // Skip if subtracting k would make height negative
    if (subtract < 0) continue;

    // Calculate new min and max
    const newMin = Math.min(arr[0] + k, subtract);
    const newMax = Math.max(arr[arr.length - 1] - k, add);

    // Update minimum difference
    minDiff = Math.min(minDiff, newMax - newMin);
  }

  return minDiff;
};

console.log(minimiseHeights([1, 5, 8, 10], 2)); // 5
console.log(minimiseHeights([3, 9, 12, 16, 20], 3)); // 11
console.log(minimiseHeights([1, 8, 10, 6, 4, 6, 9, 1], 7)); // 9
console.log(minimiseHeights([5, 3, 5, 5], 4));
