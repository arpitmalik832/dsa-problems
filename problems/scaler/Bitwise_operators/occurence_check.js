/**
 * Q. Given an integer array where every number is occurring twice except one. Find the number which is occurring once.
 */
function soln(A) {
  let rslt = A[0];
  for (let i = 1; i < A.length; i++) {
    rslt ^= A[i];
  }
  return rslt;
}

console.log(soln([1, 3, 2, 1, 3]));
console.log(soln([1, 3, 5, 1, 3]));
