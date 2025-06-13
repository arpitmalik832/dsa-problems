/**
 * Q. Merge Two Sorted Arrays
 *
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 *
 * Note: A linear time complexity is expected and you should avoid use of any library function.
 */
function soln(A, B) {
  let i = 0;
  let j = 0;
  let k = 0;
  const n = A.length;
  const m = B.length;
  const rslt = new Array(n + m).fill(0);
  while (i < n && j < m) {
    if (A[i] <= B[j]) {
      rslt[k] = A[i];
      i++;
      k++;
    } else {
      rslt[k] = B[j];
      k++;
      j++;
    }
  }
  while (i < n) {
    rslt[k] = A[i];
    k++;
    i++;
  }
  while (j < m) {
    rslt[k] = B[j];
    k++;
    j++;
  }

  return rslt;
}

console.log(soln([4, 7, 9], [2, 11, 19]));
