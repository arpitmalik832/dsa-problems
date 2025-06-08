/**
 * Q. First Repeating element
 *
 * Given an integer array A of size N, find the first repeating element in it.
 *
 * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
 *
 * If there is no repeating element, return -1.
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 *
 * Input Format
 * The first and only argument is an integer array A of size N.
 *
 * Output Format
 * Return an integer denoting the first repeating element.
 */
/** Approach 1 */
function soln(A) {
  const n = A.length;
  const hm = new Map();
  let ans = Infinity;
  for (let i = 0; i < n; i++) {
    if (hm.has(A[i])) {
      ans = Math.min(ans, hm.get(A[i]));
    } else {
      hm.set(A[i], i);
    }
  }

  if (ans === Infinity) {
    return -1;
  }
  return A[ans];
}

/** Approach 2 */
function soln2(A) {
  const n = A.length;
  const hm = new Map();
  for (let i = 0; i < n; i++) {
    if (hm.has(A[i])) {
      hm.set(A[i], hm.get(A[i]) + 1);
    } else {
      hm.set(A[i], 1);
    }
  }

  for (let i = 0; i < n; i++) {
    if (hm.get(A[i]) > 1) {
      return A[i];
    }
  }

  return -1;
}

console.log(soln([10, 5, 3, 4, 3, 5, 6]));
console.log(soln2([10, 5, 3, 4, 3, 5, 6]));
