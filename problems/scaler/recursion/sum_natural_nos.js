/**
 * Implement a recursive function to calculate the sum of first N natural numbers.
 */
function soln(n) {
  if (n === 1) return 1;
  return soln(n - 1) + n;
}

console.log(soln(5)); // 15
