/**
 * Max Circular Subarray Sum
 *
 * Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.
 *
 * Examples:
 *
 * Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
 * Output: 22
 * Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
 *
 * Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
 * Output: 23
 * Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
 *
 * Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1]
 * Output: 52
 * Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
 *
 * Constraints:
 * 1 <= arr.size() <= 105
 * -104 <= arr[i] <= 104
 */

/**
 * Steps:
 * 1. Find the maximum subarray sum using Kadane's algorithm
 * 2. Find the minimum subarray sum using Kadane's algorithm
 * 3. Find the total sum of the array
 * 4. Ciscular subarray sum is total sum - minimum subarray sum
 * 5. Return the maximum of the two sums
 */
const maxCircularSubarraySum = (arr) => {
  const size = arr.length;

  const totalSum = arr.reduce((acc, curr) => acc + curr, 0);

  let maxRegularSum = arr[0];
  let maxRegularEndingHere = arr[0];

  for (let i = 1; i < size; i++) {
    maxRegularEndingHere = Math.max(arr[i], maxRegularEndingHere + arr[i]);

    maxRegularSum = Math.max(maxRegularSum, maxRegularEndingHere);
  }

  let minRegularSum = arr[0];
  let minRegularEndingHere = arr[0];

  for (let i = 1; i < size; i++) {
    minRegularEndingHere = Math.min(arr[i], minRegularEndingHere + arr[i]);

    minRegularSum = Math.min(minRegularSum, minRegularEndingHere);
  }

  return Math.max(maxRegularSum, totalSum - minRegularSum);
};

console.log(maxCircularSubarraySum([8, -8, 9, -9, 10, -11, 12])); // 22
console.log(maxCircularSubarraySum([10, -3, -4, 7, 6, 5, -4, -1])); // 23
console.log(maxCircularSubarraySum([-1, 40, -14, 7, 6, 5, -4, -1])); // 52
