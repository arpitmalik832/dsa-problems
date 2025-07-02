/**
 * Q. MAX and MIN

Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 */
function soln(A) {
  function nextSmallerLeft(A) {
    const n = A.length;
    let rslt = new Array(n).fill(0);
    let st = [];
    for (let i = 0; i < n; i++) {
      while (st.length && A[st[st.length - 1]] >= A[i]) {
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

  function nextSmallerRight(A) {
    const n = A.length;
    let rslt = new Array(n).fill(0);
    let st = [];
    for (let i = n - 1; i >= 0; i--) {
      while (st.length && A[st[st.length - 1]] >= A[i]) {
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

  function nextLargerLeft(A) {
    const n = A.length;
    let rslt = new Array(n).fill(0);
    let st = [];
    for (let i = 0; i < n; i++) {
      while (st.length && A[st[st.length - 1]] <= A[i]) {
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

  function nextLargerRight(A) {
    const n = A.length;
    let rslt = new Array(n).fill(0);
    let st = [];
    for (let i = n - 1; i >= 0; i--) {
      while (st.length && A[st[st.length - 1]] <= A[i]) {
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

  const MOD = Math.pow(10, 9) + 1;
  let n = A.length;
  let nSL = nextSmallerLeft(A);
  let nSR = nextSmallerRight(A);
  let nLL = nextLargerLeft(A);
  let nLR = nextLargerRight(A);

  let ans = 0;
  for (let i = 0; i < n; i++) {
    const maxCount = (i - nLL[i]) * (nLR[i] - i);
    const minCount = (i - nSL[i]) * (nSR[i] - i);
    ans =
      ((ans % MOD) +
        (((((maxCount % MOD) - (minCount % MOD) + MOD) % MOD) * (A[i] % MOD)) %
          MOD)) %
      MOD;
  }

  return ans;
}

console.log(soln([4, 7, 3, 8]));
