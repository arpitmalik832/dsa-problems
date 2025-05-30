/**
 * Implement a recursive function to calculate the Nth Fibonacci number.
 */
function soln(n) {
  if ([0, 1].includes(n)) return n;
  return soln(n - 1) + soln(n - 2);
}

console.log(soln(5)); // 5
console.log(soln(10)); // 55
