/**
 *  Boundary Traversal
 */

function soln(A) {
  const n = A.length;
  const m = A[0].length;

  const boundary = [];

  let top = 0;
  let bottom = n - 1;
  let left = 0;
  let right = m - 1;

  let count = 0;
  while (count < m + (n - 1) + (m - 1) + (n - 2)) {
    for (let i = left; i <= right; i++) {
      boundary.push(A[top][i]);
      count++;
    }
    top++;

    for (let i = top; i <= bottom; i++) {
      boundary.push(A[i][right]);
      count++;
    }
    right--;

    if (left <= right) {
      for (let i = right; i >= left; i--) {
        boundary.push(A[bottom][i]);
        count++;
      }
      bottom--;
    }

    if (top <= bottom) {
      for (let i = bottom; i >= top; i--) {
        boundary.push(A[i][left]);
        count++;
      }
      left++;
    }
  }

  return boundary;
}

console.log(
  soln([
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12],
  ])
); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
