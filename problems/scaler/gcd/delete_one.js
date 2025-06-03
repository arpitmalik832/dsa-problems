/**
 * Q. Delete one
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 * Problem Constraints
 *
 * 2 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 */

function getGcd(A, B) {
  if (B === 0) {
    return A;
  }

  return getGcd(B, A % B);
}

function soln(A) {
  const n = A.length;
  const pGcd = [...A];
  const sGcd = [...A];
  for (let i = 1; i < n; i++) {
    pGcd[i] = getGcd(pGcd[i - 1], A[i]);
  }

  for (let i = n - 2; i >= 0; i--) {
    sGcd[i] = getGcd(sGcd[i + 1], A[i]);
  }

  let rslt = Math.max(sGcd[1], pGcd[n - 2]);

  for (let i = 1; i < n - 1; i++) {
    rslt = Math.max(rslt, getGcd(pGcd[i - 1], sGcd[i + 1]));
  }

  return rslt;
}

console.log(soln([12, 15, 18]));
