/**
 * Implement a recursive function to print numbers from N to 1 in decreasing order.
 */
function soln(n) {
  if (n === 1) {
    console.log(1);
    return;
  }
  console.log(n);
  soln(n - 1);
}

console.log(soln(5)); // 5 4 3 2 1
