function soln(A, B) {
  const n = A.length;
  let i = 0,
    j = n - 1;
  while (i <= j) {
    const m = (i + j) / 2;
    if (A[m] === B) {
      return m;
    } else if (A[m] > B) {
      return (j = m - 1);
    } else {
      return (i = m + 1);
    }
  }

  return i;
}
