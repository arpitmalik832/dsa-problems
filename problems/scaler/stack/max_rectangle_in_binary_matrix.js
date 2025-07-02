/**
 * Q. Max Rectangle in Binary Matrix

Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
 */
function soln(A) {
  function nextSmallerLeft(arr) {
    let n = arr.length;
    let rslt = new Array(n).fill(0);
    let st = [];
    for (let i = 0; i < n; i++) {
      while (st.length && arr[st[st.length - 1]] >= arr[i]) {
        st.pop();
      }
      if (st.length === 0) {
        rslt[i] = -1;
      } else {
        rslt[i] = st[st.length - 1];
      }
      st.push(i);
    }

    return rslt;
  }

  function nextSmallerRight(arr) {
    let n = arr.length;
    let rslt = new Array(n).fill(0);
    let st = [];
    for (let i = n - 1; i >= 0; i--) {
      while (st.length && arr[st[st.length - 1]] >= arr[i]) {
        st.pop();
      }
      if (st.length === 0) {
        rslt[i] = n;
      } else {
        rslt[i] = st[st.length - 1];
      }
      st.push(i);
    }

    return rslt;
  }

  const n = A.length;
  const m = A[0].length;
  for (let i = 1; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (A[i][j] !== 0) {
        A[i][j] += A[i - 1][j];
      }
    }
  }

  let nSL = [];
  let nSR = [];
  for (let i = 0; i < n; i++) {
    nSL[i] = nextSmallerLeft(A[i]);
    nSR[i] = nextSmallerRight(A[i]);
  }

  let ans = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      let range = nSR[i][j] - nSL[i][j] - 1;
      ans = Math.max(ans, range * A[i][j]);
    }
  }

  return ans;
}

// console.log(
//   soln([
//     [1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1],
//     [1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//     [0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1],
//     [1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1],
//     [1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0],
//     [1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1],
//     [1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1],
//     [1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1],
//     [1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1],
//   ])
// );

console.log(
  soln([
    [0, 0],
    [1, 1],
    [1, 0],
    [1, 0],
    [0, 1],
    [0, 1],
    [0, 1],
  ])
);
