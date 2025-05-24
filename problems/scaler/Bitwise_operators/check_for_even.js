/**
 * Q. Given an integer. Return true if it is an even integer.
 */
function soln(A) {
  return (A & 1) === 0;
}

console.log(soln(2));
console.log(soln(3));
