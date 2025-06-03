/**
 * Q. Mod Sum
 *
 * Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
 * 1 <= A[i] <= 1000
 *
 */

function soln(A) {
  const MOD = Math.pow(10, 9) + 7;
  const freq = new Array(1000).fill(0);

  for (const i of A) {
    freq[i - 1]++;
  }

  let ans = 0;
  for (let i = 0; i < 1000; i++) {
    for (let j = 0; j < A.length; j++) {
      ans =
        ((ans % MOD) + (((((i + 1) % A[j]) % MOD) * (freq[i] % MOD)) % MOD)) %
        MOD;
    }
  }

  return ans;
}

console.log(soln([1, 2, 3]));
console.log(soln([17, 100, 11]));
