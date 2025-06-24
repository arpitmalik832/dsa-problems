/**
 * Q. Sorted Insert Position
 *
 * You are given a sorted array A of size N and a target value B.
 * Your task is to find the index (0-based indexing) of the target value in the array.
 *
 * If the target value is present, return its index.
 * If the target value is not found, return the index of least element greater than equal to B.
 * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
 * Your solution should have a time complexity of O(log(N)).
 */
function soln(A, B) {
  const n = A.length;
  let i = 0,
    j = n - 1;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m] === B) {
      return m;
    } else if (A[m] > B) {
      return (j = m - 1);
    } else {
      return (i = m + 1);
    }
  }

  return i;
}
