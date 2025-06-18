/**
 * Q. Search for a Range
 *
 * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
 *
 * Return an array of size 2, such that
 * First element = Left most index of B in A
 * Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 *
 * Note : The time complexity of your algorithm must be O(log n)..
 */
function soln(A, B) {
  let min = -1,
    max = -1;
  const n = A.length;
  let i = 0,
    j = n - 1;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m] === B) {
      min = m;
      j = m - 1;
    } else if (A[m] > B) {
      j = m - 1;
    } else {
      i = m + 1;
    }
  }
  i = 0;
  j = n - 1;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m] === B) {
      max = m;
      i = m + 1;
    } else if (A[m] > B) {
      j = m - 1;
    } else {
      i = m + 1;
    }
  }

  return [min, max];
}
