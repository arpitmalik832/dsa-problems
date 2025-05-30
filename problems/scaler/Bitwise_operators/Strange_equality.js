/**
 * Strange Equality
 *
 * Given an integer A.
 * Two numbers, X and Y, are defined as follows:
 *
 * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
 * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
 *
 * Find and return the XOR of X and Y.
 *
 * NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
 *
 * NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
 */
function soln(A) {
  let n = 0;
  let temp = A;

  while (temp > 0) {
    n++;
    temp >>= 1;
  }

  let X = 0;
  for (let i = 0; i < n - 1; i++) {
    if (((1 << i) & A) === 0) {
      X |= 1 << i;
    }
  }

  return X ^ (1 << n);
}

console.log(soln(5)); // 10
