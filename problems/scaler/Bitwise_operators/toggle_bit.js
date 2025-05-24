/**
 * Q. Toggle the ith bit in integer n.
 */
function soln(n, i) {
  return n ^ (1 << i);
}

console.log(soln(3, 0));
console.log(soln(5, 1));
console.log(soln(5, 0));
