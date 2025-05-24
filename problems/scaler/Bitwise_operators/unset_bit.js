/**
 * Q. Unset the ith bit in integer n.
 */
function soln(A, B) {
  return A & ~(1 << B);
}

console.log(soln(3, 1));
