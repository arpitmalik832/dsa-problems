/**
 * Q. Minimise cost to empty the array A[N]. Given A[N] integers, objective is to minimise the cost of emptying the array. The cost of removing an element is sum of all remaining elements in the array at the time of removal.
 */

function soln(A) {
  const n = A.length;
  A.sort((a, b) => b - a);
  let cost = 0;

  for (let i = 0; i < n; i++) {
    cost += A[i] * (i + 1);
  }

  return cost;
}
