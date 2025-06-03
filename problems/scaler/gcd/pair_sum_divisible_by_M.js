/**
 * Q. Pair Sum divisible by M
 *
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (10^9 + 7).
 *
 * Note: Ensure to handle integer overflow when performing the calculations.
 */
function soln(A, B) {
  const MOD = Math.pow(10, 9) + 7;
  const mods = new Array(B).fill(0);

  for (const i of A) {
    mods[i % B]++;
  }

  let ans = (((mods[0] % MOD) * ((mods[0] - 1) % MOD)) / 2) % MOD;
  let i = 1;
  let j = B - 1;

  while (i < j) {
    ans = ((ans % MOD) + (((mods[i] % MOD) * (mods[j] % MOD)) % MOD)) % MOD;
    i++;
    j--;
  }
  if (i == j) {
    ans =
      ((ans % MOD) + ((((mods[i] % MOD) * ((mods[i] - 1) % MOD)) / 2) % MOD)) %
      MOD;
  }

  return ans;
}

console.log(soln([1, 2, 3, 4, 5], 2));
