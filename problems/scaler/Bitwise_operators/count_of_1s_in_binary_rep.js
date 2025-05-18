/**
 * Count of 1s in binary representation of a number
 */

/**
 * Brute force approach
 */
function soln(A) {
  let count = 0;
  const binary = A.toString(2);
  for (let i = 0; i < binary.length; i++) {
    if (binary[i] === "1") {
      count++;
    }
  }
  return count;
}

/**
 * Optimized approach
 */
function soln2(A) {
  let count = 0;
  while (A > 0) {
    count += A & 1;
    A >>= 1;
  }
  return count;
}

console.log(soln(10));
console.log(soln2(10));
