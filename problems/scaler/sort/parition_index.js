/**
 * Q. Partition Index
 *
 * Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:
 *
 * if A[i] < p then it should be present on left side of the partition
 * if A[i] > p then it should be present on right side of the partition
 * Rearrange the given array as well as return the partition index.
 *
 * Note: All elements are distinct
 */
function soln(arr) {
  const n = arr.length;
  [arr[0], arr[n - 1]] = [arr[n - 1], arr[0]];
  let l = 1;
  let r = n - 1;
  while (l <= r) {
    if (arr[l] < arr[0]) {
      l++;
    } else if (arr[r] > arr[0]) {
      r--;
    } else {
      [arr[l], arr[r]] = [arr[r], arr[l]];
      l++;
      r--;
    }
  }
  [arr[0], arr[r]] = [arr[r], arr[0]];
  return r;
}
