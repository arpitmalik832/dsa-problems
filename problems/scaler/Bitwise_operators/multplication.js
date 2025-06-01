/**
 * Implement multiplication using bitwise operators.
 * 12 * 5 = 60
 */
function soln(A, B) {
  let rslt = 0;
  while (B > 0) {
    if (B & 1) {
      rslt += A;
    }
    A <<= 1;
    B >>= 1;
  }

  return rslt;
}

console.log(soln(12, 5));
