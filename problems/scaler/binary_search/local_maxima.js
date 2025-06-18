function soln(A) {
  const n = A.length;
  if (n === 1) return A[0];
  if (A[0] > A[1]) return A[0];
  if (A[n - 1] > A[n - 2]) return A[n - 1];
  let i = 1,
    j = n - 2;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m] >= A[m - 1] && A[m] >= A[m + 1]) {
      return A[m];
    } else if (A[m] >= A[m - 1] && A[m] < A[m + 1]) {
      i = m + 1;
    } else {
      j = m - 1;
    }
  }
}

// console.log([1, 2, 3, 4, 5]);
console.log(soln([5, 17, 100, 11]));
