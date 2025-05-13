/**
 * Find the sum of all submatrices of a given matrix
 */

function soln(A) {
  const n = A.length;
  const m = A[0].length;

  let sum = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      sum += A[i][j] * (i + 1) * (j + 1) * (n - i) * (m - j);
    }
  }

  return sum;
}

console.log(
  soln([
    [1, 1],
    [1, 1],
  ])
);
