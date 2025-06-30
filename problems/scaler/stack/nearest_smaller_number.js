/**
 * Q2. Nearest Smaller Element

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]
Elements for which no smaller element exist, consider the next smaller element as -1.
 */
function soln(A) {
  let stack = [];
  let rslt = [];
  for (let i = 0; i < A.length; i++) {
    if (stack.length == 0) {
      rslt.push(-1);
    } else if (stack[stack.length - 1] < A[i]) {
      rslt.push(stack[stack.length - 1]);
    } else {
      while (stack.length && stack[stack.length - 1] >= A[i]) {
        stack.pop();
      }
      if (stack.length == 0) {
        rslt.push(-1);
      } else {
        rslt.push(stack[stack.length - 1]);
      }
    }
    stack.push(A[i]);
  }

  return rslt;
}
