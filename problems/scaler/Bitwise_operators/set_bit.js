/**
 * Q. Set the ith bit in an integer n.
 */
function soln(n, i) {
  return n | (1 << i);
}

console.log(soln(5, 1));
