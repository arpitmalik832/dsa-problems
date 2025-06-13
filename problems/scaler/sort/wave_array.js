/**
 * Q. Wave Array
 *
 * Given an array of integers A, sort the array into a wave-like array and return it.
 * In other words, arrange the elements into a sequence such that
 *
 * a1 >= a2 <= a3 >= a4 <= a5.....
 * NOTE: If multiple answers are possible, return the lexicographically smallest one.
 */
function soln(A) {
  A.sort((a, b) => a - b);

  for (let i = 0; i < A.length - 1; i += 2) {
    [A[i], A[i + 1]] = [A[i + 1], A[i]];
  }

  return A;
}
