/**
 * Factors of a number
 */

/**
 * Brute force solution
 */
function soln1(A) {
  let count = 0;
  for (let i = 1; i <= A; i++) {
    if (A % i === 0) {
      count++;
    }
  }
  return count;
}

/**
 * Optimized solution
 */
function soln2(A) {
  let count = 0;
  for (let i = 1; i * i <= A; i++) {
    if (A % i === 0) {
      if (i === A / i) {
        count++;
      } else {
        count += 2;
      }
    }
  }
  return count;
}

console.log(soln1(10));
console.log(soln2(10));
