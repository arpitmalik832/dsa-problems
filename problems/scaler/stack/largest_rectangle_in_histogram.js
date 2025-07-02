/**
 * Q. Largest Rectangle in Histogram

Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000
*/
function soln(A) {
  function nextSmallerOnLeft(arr) {
    let stack = [];
    const n = arr.length;
    let rslt = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
      while (stack.length && arr[stack[stack.length - 1]] >= arr[i]) {
        stack.pop();
      }
      if (stack.length === 0) {
        rslt[i] = -1;
      } else {
        rslt[i] = stack[stack.length - 1];
      }
      stack.push(i);
    }

    return rslt;
  }

  function nextSmallerOnRight(arr) {
    let stack = [];
    const n = arr.length;
    let rslt = new Array(n).fill(0);
    for (let i = n - 1; i >= 0; i--) {
      while (stack.length && arr[stack[stack.length - 1]] >= arr[i]) {
        stack.pop();
      }
      if (stack.length === 0) {
        rslt[i] = n;
      } else {
        rslt[i] = stack[stack.length - 1];
      }
      stack.push(i);
    }

    return rslt;
  }

  let nextSmallerOnLeftArr = nextSmallerOnLeft(A);
  let nextSmallerOnRightArr = nextSmallerOnRight(A);

  let ans = 0;
  for (let i = 0; i < A.length; i++) {
    ans = Math.max(
      ans,
      (nextSmallerOnRightArr[i] - 1 - nextSmallerOnLeftArr[i]) * A[i]
    );
  }

  return ans;
}

console.log(soln([4, 3, 2, 1]));
