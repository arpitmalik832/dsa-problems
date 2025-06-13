/**
 * Q3. Tens Digit Sorting
 *
 * Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
 *
 * If a number has no tens digit, we can assume value to be 0.
 * If 2 numbers have same tens digit, in that case number with max value will come first
 * Solution should be based on comparator.
 */
function soln(A) {
  A.sort((a, b) => {
    const aT = (a / 10n) % 10n,
      bT = (b / 10n) % 10n;
    if (aT === bT) {
      if (a >= b) {
        return -1;
      } else {
        return 1;
      }
    } else if (aT < bT) {
      return -1;
    } else {
      return 1;
    }
  });

  return A;
}
