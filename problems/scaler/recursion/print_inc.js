/**
 * Implement a recursive function to print numbers from 1 to N in increasing order.
 */
function soln(n) {
  if (n === 1) {
    console.log(1);
    return;
  }
  soln(n - 1);
  console.log(n);
}

console.log(soln(5)); // 1 2 3 4 5
