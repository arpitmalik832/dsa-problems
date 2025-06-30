/**
 * Q2. Next Greater

Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:
G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.
 */
function soln(A) {
  let st = [];
  let rslt = new Array(A.length).fill(0);
  for (let i = A.length - 1; i >= 0; i--) {
    if (st.length === 0) {
      rslt[i] = -1;
    } else if (st[st.length - 1] > A[i]) {
      rslt[i] = st[st.length - 1];
    } else {
      while (st.length && st[st.length - 1] <= A[i]) {
        st.pop();
      }
      if (st.length == 0) {
        rslt[i] = -1;
      } else {
        rslt[i] = st[st.length - 1];
      }
    }
    st.push(A[i]);
  }

  return rslt;
}
