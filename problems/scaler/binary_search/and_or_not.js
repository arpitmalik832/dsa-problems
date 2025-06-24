/**
 * Q3. ADD OR NOT
 *
 * Given an array of integers A of size N and an integer B.
 *
 * In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
 *
 * Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
 * If there are several such numbers, your task is to find the minimum one.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 * 0 <= B <= 109
 */

function isPossible(A, B, pf, i, elem) {
  let sum = 0;
  if (i - elem < 0) {
    sum = pf[i];
  } else {
    sum = pf[i] - pf[i - elem];
  }
  if (elem * A[i] - sum <= B) {
    return true;
  }

  return false;
}

function soln(A, B) {
  A.sort((a, b) => a - b);
  const n = A.length;
  const pf = [...A];
  for (let i = 1; i < n; i++) {
    pf[i] += pf[i - 1];
  }

  const ans = [-1, -1];
  for (let i = 0; i < n; i++) {
    let lo = 1,
      hi = i + 1;
    let temp = -1;
    while (lo <= hi) {
      const mid = parseInt((lo + hi) / 2);
      if (isPossible(A, B, pf, i, mid)) {
        temp = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    if (ans[0] < temp) {
      ans[0] = temp;
      ans[1] = A[i];
    }
  }

  return ans;
}

console.log(soln([3, 1, 2, 2, 1], 3));
