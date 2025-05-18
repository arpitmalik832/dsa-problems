/**
 * Equilibrium Index
 *
 * Problem Description
 * Given an array A of N integers.
 *
 * Find the equilibrium index of the given array.
 *
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 */

function soln(A) {
  const n = A.length;
  for (let i = 1; i < n; i++) {
    A[i] += A[i - 1];
  }

  if (A[n - 1] - A[0] === 0) return 0;


  for (let i = 1; i < n - 1; i++) {
    if (A[i - 1] === A[n - 1] - A[i]) {
      return i;
    }
  }

  if (A[n - 2] === 0) return n - 1;

  return -1;
}
