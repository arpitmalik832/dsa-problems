/**
 * Q. Count Pair Sum
 *
 * You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.
 *
 * Since the answer can be very large, return the remainder after dividing the count with 109+7.
 *
 * Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
 */
function soln(A, B) {
  const MOD = Math.pow(10, 9) + 7;
  const mp = new Map();

  let rslt = 0;
  for (const i of A) {
    const comp = parseInt(B) - parseInt(i);
    if (mp.has(comp)) {
      rslt = ((rslt % MOD) + (mp.get(comp) % MOD)) % MOD;
    }
    if (mp.has(i)) {
      mp.set(i, mp.get(i) + 1);
    } else {
      mp.set(i, 1);
    }
  }

  return rslt;
}

console.log(soln([1, 2, 1, 2], 3));
