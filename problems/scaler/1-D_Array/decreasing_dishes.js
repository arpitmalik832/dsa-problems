/**
 * Decreasing dishes
 *
 * Given an array of N positive integers representing the weights of ingredients in a dish.
 * Find the maximum possible sum of a subarray with decreasing weights.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 0 <= A[i] <= 105
 *
 * Sum of all elements of A <= 109
 */
function soln(A) {
  let maxSoFar = A[0];
  let tempSum = A[0];
  for (let i = 1; i < A.length; i++) {
    if (A[i] >= A[i - 1]) {
      tempSum = A[i];
    } else {
      tempSum += A[i];
    }
    maxSoFar = Math.max(maxSoFar, tempSum);
  }

  return maxSoFar;
}
