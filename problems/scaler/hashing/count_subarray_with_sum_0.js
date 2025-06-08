/**
 * Q. Count Subarray Zero Sum
 *
 * Given an array A of N integers.
 * Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 *
 * Input Format
 * Single argument which is an integer array A.
 *
 * Output Format
 * Return an integer.
 */
function soln(A) {
  const n = A.length;
  for (let i = 1; i < n; i++) {
    A[i] = A[i - 1] + A[i];
  }

  let ans = 0;
  const hm = new Map();
  for (let i = 0; i < n; i++) {
    if (A[i] == 0) {
      ans += 1;
    }
    if (hm.has(A[i])) {
      ans += hm.get(A[i]);
      hm.set(A[i], hm.get(A[i]) + 1);
    } else {
      hm.set(A[i], 1);
    }
  }

  return ans;
}

console.log(soln([1, -1, -2, 2]));
