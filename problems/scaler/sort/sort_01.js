/**
 * Q. Sort 01
 *
 * Given an array A of 0s and 1s of length N. Sort this array.
 *
 * Note - Do not use any sorting algorithm or library's sort method.
 */
function soln(A) {
  const arr = [0, 0];
  for (let i = 0; i < A.length; i++) {
    arr[A[i]]++;
  }

  let j = 0;
  for (let i = 0; i < arr.length; i++) {
    for (let k = 1; k <= arr[i]; k++) {
      A[j++] = i;
    }
  }

  return A;
}
