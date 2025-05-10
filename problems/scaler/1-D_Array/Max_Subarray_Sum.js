/**
 *  Max Sum Contiguous Subarray
 *
 * Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
 *
 * In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
 *
 * Problem Constraints
 *
 * 1 <= N <= 106
 * -1000 <= A[i] <= 1000
 *
 * Input Format
 *
 * The first and the only argument contains an integer array, A.
 *
 * Output Format
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2, 3, 4, -10]
 *
 * Input 2:
 *
 * A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * Example Output
 *
 * Output 1:
 *
 * 10
 *
 * Output 2:
 *
 * 6
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Explanation 2:
 *
 * The subarray [4,-1,2,1] has the maximum possible sum of 6.
 *
 */

/**
 * Brute force solution
 * Time complexity: O(N^3)
 * Space complexity: O(1)
 */
function soln(A) {
  const size = A.length;
  let ans = 0;
  let sum = 0;
  for (let i = 0; i < size; i++) {
    for (let j = i; j < size; j++) {
      for (let k = i; k <= j; k++) {
        sum += A[k];
      }
      ans = Math.max(ans, sum);
      sum = 0;
    }
  }
  return ans;
}

/**
 * Optimized solution using prefix sum
 * Time complexity: O(N^2)
 * Space complexity: O(N)
 */
function soln2(A) {
  const size = A.length;
  const prefixSum = new Array(n).fill(0);
  // calculating prefix sum
  prefixSum[0] = A[0];
  for (let i = 1; i < size; i++) {
    prefixSum[i] = A[i] + prefixSum[i - 1];
  }
  let ans = 0;
  let sum = 0;
  for (let i = 0; i < size; i++) {
    for (let j = i; j < size; j++) {
      if (i === 0) {
        sum = prefixSum[j];
      } else {
        sum = prefixSum[j] - prefixSum[i - 1];
      }
      ans = Math.max(ans, sum);
    }
  }
  return ans;
}

/**
 * Optimized solution using Kadane's algorithm
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
function soln(A) {
  let maxSoFar = A[0];
  let maxEndingHere = A[0];
  const size = A.length;
  for (let i = 1; i < size; i++) {
    maxEndingHere = Math.max(A[i], A[i] + maxEndingHere);
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
  }
  return maxSoFar;
}

console.log(soln([1, 2, 3, 4, -10]));
console.log(soln2([1, 2, 3, 4, -10]));
console.log(soln3([1, 2, 3, 4, -10]));
