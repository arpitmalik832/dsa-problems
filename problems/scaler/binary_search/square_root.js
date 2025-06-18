/**
 * Find The square root of the given number.
 */
function soln(A) {
  let i = 1,
    j = A,
    rslt = 0;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (m * m <= A) {
      rslt = m;
      i = m + 1;
    } else {
      j = m - 1;
    }
  }

  return rslt;
}
