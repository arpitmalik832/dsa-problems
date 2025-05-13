/**
 * You are given 3 sorted arrays A, B and C.
 * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 */
function minimizeMaxDiff(A, B, C) {
  let i = 0,
    j = 0,
    k = 0;
  let minMaxDiff = Infinity;

  while (i < A.length && j < B.length && k < C.length) {
    // Calculate current differences
    const diff1 = Math.abs(A[i] - B[j]);
    const diff2 = Math.abs(B[j] - C[k]);
    const diff3 = Math.abs(C[k] - A[i]);

    // Calculate current maximum difference
    const currentMaxDiff = Math.max(diff1, diff2, diff3);

    // Update minimum maximum difference if needed
    minMaxDiff = Math.min(minMaxDiff, currentMaxDiff);

    // Move the pointer pointing to the smallest value
    if (A[i] <= B[j] && A[i] <= C[k]) {
      i++;
    } else if (B[j] <= A[i] && B[j] <= C[k]) {
      j++;
    } else {
      k++;
    }
  }

  return minMaxDiff;
}

// Test cases
console.log(minimizeMaxDiff([1, 4, 10], [2, 15, 20], [10, 12])); // Output: 5
console.log(minimizeMaxDiff([3, 5, 6], [2], [3, 4])); // Output: 1
