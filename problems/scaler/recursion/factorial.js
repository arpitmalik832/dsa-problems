/**
 * Implement a recursive function to calculate the factorial of a number.
 */
function soln(n) {
  if ([0, 1].includes(n)) return n;
  return soln(n - 1) * n;
}

console.log(soln(5)); // 120
