/**
 * Q2. Sub-array with 0 sum
 *
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * -10^9 <= A[i] <= 10^9
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 */
function soln(A) {
  let n = A.length;
  for (let i = 1; i < n; i++) {
    A[i] = A[i - 1] + A[i];
  }

  const hs = new Set();
  for (let i = 0; i < n; i++) {
    if (hs.has(A[i]) || A[i] === 0) {
      return 1;
    }
    hs.add(A[i]);
  }

  return 0;
}

console.log(soln([2, 1, -3, 4, 5]));
