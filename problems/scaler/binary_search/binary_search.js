/**
 * Binary Search
 */
function soln(A, B) {
  const n = A.length;
  let i = 0,
    j = n - 1;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m] === B) {
      return m;
    } else if (A[m] > B) {
      j = m - 1;
    } else {
      i = m + 1;
    }
  }

  return -1;
}
