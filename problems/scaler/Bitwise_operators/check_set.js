/**
 * Q. Given two positive integers n & i. Check if the ith bit in 0-based indexing from the end in n is set or not.
 */
function soln(n, i) {
  return (n & (1 << i)) !== 0;
}

console.log(soln(3, 1));
console.log(soln(5, 2));
console.log(soln(5, 1));
