/**
 * Implement a recursive function to calculate the sum of digits of a number.
 */
function soln(n) {
  if (n === 0) return 0;
  return soln(n / 10) + (n % 10);
}

console.log(soln(123)); // 6
