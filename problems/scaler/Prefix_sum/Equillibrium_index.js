/**
 * Equilibrium Index
 */

function soln(A) {
  const n = A.length;
  for (let i = 1; i < n; i++) {
    A[i] += A[i - 1];
  }

  if (A[n - 1] - A[0] === 0) return 0;

  if (A[n - 2] === 0) return n - 1;

  for (let i = 1; i < n - 1; i++) {
    if (A[i - 1] === A[n - 1] - A[i]) {
      return i;
    }
  }

  return -1;
}
