/**
 * Q. Subarray with given sum
 *
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 * If the answer does not exist return an array with a single integer "-1".
 * First sub-array means the sub-array for which starting index in minimum.
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".
 */
function soln(A, B) {
  const n = A.length;
  const pf = [...A];
  for (let i = 1; i < n; i++) {
    pf[i] = pf[i - 1] + pf[i];
  }

  let x = Infinity;
  let rslt = [];
  const hm = new Map();
  for (let i = 0; i < n; i++) {
    if (pf[i] === B) {
      x = 0;
      rslt = A.slice(0, i + 1);
    }
    if (hm.has(pf[i] - B) && hm.get(pf[i] - B) < x) {
      x = hm.get(pf[i] - B);
      rslt = A.slice(x + 1, i + 1);
    }
    if (!hm.has(pf[i])) {
      hm.set(pf[i], i);
    }
  }

  if (x === Infinity) {
    return [-1];
  }
  return rslt;
}

console.log(soln([1, 2, 3, 4, 5], 5));
