/**
 * Q. Subarray Sum Equals K
 *
 * Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.
 *
 * Problem Constraints
 * 1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 *
 * Output Format
 * Return the total number of subarrays having sum equals to B.
 */
function soln(A, B) {
  const n = A.length;
  for (let i = 1; i < n; i++) {
    A[i] = A[i - 1] + A[i];
  }

  let ans = 0;
  let hm = new Map();
  for (let i = 0; i < n; i++) {
    if (hm.has(A[i] - B)) {
      ans += hm.get(A[i] - B);
    }
    if (A[i] === B) {
      ans++;
    }

    if (!hm.has(A[i])) {
      hm.set(A[i], 1);
    } else {
      hm.set(A[i], hm.get(A[i]) + 1);
    }
  }

  return ans;
}

console.log(soln([1, 0, 1], 1));
