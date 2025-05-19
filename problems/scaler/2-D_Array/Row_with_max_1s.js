/**
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1s.
 */

function soln(A) {
  const n = A.length;
  const m = A[0].length;

  let i = 0;
  let j = m - 1;
  let max1s = -1;
  let rslt = -1;
  while (i < n && j >= 0) {
    if (max1s < m - j) {
      max1s = m - j;
      rslt = i;
    }
    if (j > 0 && A[i][j - 1] === 1) {
      j--;
    } else {
      i++;
    }
  }

  return rslt;
}

console.log(
  soln([
    [0, 1, 1],
    [0, 0, 1],
    [0, 1, 1],
  ])
); // 0
console.log(
  soln([
    [0, 0, 1, 1],
    [0, 0, 1, 1],
    [0, 0, 1, 1],
    [1, 1, 1, 1],
  ])
); // 3
