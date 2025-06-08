/**
 * Q. Longest Subarray Zero Sum
 *
 * Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 * If there is no subarray which sums to zero then return 0.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 *
 * Input Format
 * Single argument which is an integer array A.
 *
 * Output Format
 * Return an integer
 */
function soln(A) {
  const n = A.length;
  for (let i = 1; i < n; i++) {
    A[i] = A[i - 1] + A[i];
  }

  let ans = 0;
  const hm = new Map();
  for (let i = 0; i < n; i++) {
    if (A[i] === 0) {
      ans = Math.max(ans, i + 1);
    }
    if (hm.has(A[i])) {
      ans = Math.max(ans, i - hm.get(A[i]));
    } else {
      hm.set(A[i], i);
    }
  }

  return ans;
}

console.log(soln([9, -20, -11, -8, -4, 2, -12, 14, 1]));
console.log(soln([-16, 16, 3]));
