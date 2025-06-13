/**
 * Q. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
/**
 * Approach: reversal along horizontal axis and transpose of the matrix.
 */

function soln(A) {
  const n = A.length;
  let i = 0;

  while (i < parseInt(n / 2)) {
    [A[i], A[n - 1 - i]] = [A[n - 1 - i], A[i]];
    i++;
  }

  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      [A[i][j], A[j][i]] = [A[j][i], A[i][j]];
    }
  }
}

// let A = [
//   [1, 2, 3],
//   [4, 5, 6],
//   [7, 8, 9],
// ];
let A = [
  [5, 1, 9, 11],
  [2, 4, 8, 10],
  [13, 3, 6, 7],
  [15, 14, 12, 16],
];
soln(A);
console.log(A);
