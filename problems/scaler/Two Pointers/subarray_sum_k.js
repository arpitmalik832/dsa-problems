/**
 * Given an integer array A and an integer B, find the subarray in A with sum equal to B.
 * If no such subarray is found, return an array with a single element -1.
 */

/**
 * Approach: using two pointers
 */
function soln(A, B) {
  const n = A.length;
  let i = 0;
  let j = 0;
  let sum = A[0];
  while (j < n) {
    if (sum === B) {
      return A.slice(i, j + 1);
    } else if (sum < B) {
      j++;
      sum += A[j];
    } else {
      sum -= A[i];
      i++;
    }
  }
  return [-1];
}

console.log(soln([1, 2, 3, 4, 5], 5)); // [2, 3]
console.log(soln([1, 2, 3, 4, 5], 12)); // [-1]
