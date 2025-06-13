/**
 * Q. Max Chunks To Make Sorted
 *
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 */
function soln(A) {
  let max = A[0];
  let rslt = 0;
  for (let i = 0; i < A.length; i++) {
    max = Math.max(max, A[i]);
    if (max === i) {
      rslt++;
    }
  }

  return rslt;
}
