/**
 * Q. SUBARRAY OR
 *
 * You are given an array of integers A of size N.
 *
 * The value of a subarray is defined as BITWISE OR of all elements in it.
 *
 * Return the sum of value of all subarrays of A % 109 + 7.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 108
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * Output Format
 * Return the sum of Value of all subarrays of A % 109 + 7.
 *
 * Example Input
 *
 * Input 1:
 *  A = [1, 2, 3, 4, 5]
 *
 * Input 2:
 *  A = [7, 8, 9, 10]
 *
 * Example Output
 *
 * Output 1:
 *  71
 *
 * Output 2:
 *  110
 */
function soln(A) {
  const MOD = Math.pow(10, 9) + 7;
  const n = A.length;
  const total = ((n * (n + 1)) / 2) % MOD;

  let rslt = 0;
  for (let i = 0; i < 32; i++) {
    let zeroCount = 0;
    let temp = 0;
    for (const j of A) {
      if ((j & (1 << i)) === 0) {
        temp++;
      } else {
        zeroCount = (zeroCount + (temp * (temp + 1)) / 2) % MOD;
        temp = 0;
      }
    }

    zeroCount = (zeroCount + (temp * (temp + 1)) / 2) % MOD;
    let curr = (total - zeroCount + MOD) % MOD;
    curr = (curr * (1 << i)) % MOD;
    rslt = (rslt + curr) % MOD;
  }

  return rslt;
}

console.log(soln([1, 2, 3, 4, 5])); // 71
console.log(soln([7, 8, 9, 10])); // 110
