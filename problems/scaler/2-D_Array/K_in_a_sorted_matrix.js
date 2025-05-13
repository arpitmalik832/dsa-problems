/**
 * Find out if k is there in the sorted matrix
 */

/**
 * Approach: Brute force approach
 */
function findKInSortedMatrix(A, B) {
  const n = A.length;
  const m = A[0].length;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (A[i][j] === B) {
        return 1;
      }
    }
  }

  return -1;
}

/**
 * Optimized Approach using benefit of the sorted matrix
 */
function findKInSortedMatrixOptimized(A, B) {
  const n = A.length;
  const m = A[0].length;

  let i = 0;
  let j = m - 1;
  while (i < n && j >= 0) {
    if (A[i][j] === B) {
      return 1;
    }
    if (A[i][j] >= B) {
      j--;
    } else {
      i++;
    }
  }

  return -1;
}

console.log(
  findKInSortedMatrix(
    [
      [1, 2, 3],
      [4, 5, 6],
      [7, 8, 9],
    ],
    5
  )
);
console.log(
  findKInSortedMatrixOptimized(
    [
      [1, 2, 3],
      [4, 5, 6],
      [7, 8, 9],
    ],
    5
  )
);
