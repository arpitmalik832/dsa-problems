/**
 * Q4. A, B and Modulo
 *
 * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
 */

function soln(A, B) {
  if (A === B) {
    return A;
  }

  return Math.abs(A - B);
}

console.log(soln(10, 4));
console.log(soln(15, 3));
