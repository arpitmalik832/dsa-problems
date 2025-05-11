/**
 * Given an array of integers A of size N, where A[i] represents the height of the ith wall. Find the maximum amount of water that can be trapped in the walls.
 *
 * The amount of water that can be trapped in the walls is the difference between the height of the wall and the height of the water level.
 *
 * The water level is the minimum of the height of the wall and the height of the water level.
 *
 */

/**
 * Approach: using two pointers
 */
function soln(A) {
  const n = A.length;
  let i = 0;
  let j = n - 1;
  let maxWater = 0;
  while (i < j) {
    maxWater = Math.max(maxWater, Math.min(A[i], A[j]) * (j - i));
    if (A[i] < A[j]) {
      i++;
    } else {
      j--;
    }
  }
  return maxWater;
}

console.log(soln([1, 8, 6, 2, 5, 4, 8, 3, 7])); // 49
