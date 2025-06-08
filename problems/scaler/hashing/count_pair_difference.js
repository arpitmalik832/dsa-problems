/**
 * Q. Count Pair Difference
 *
 * You are given an array A of N integers and an integer B.
 * Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
 *
 * Since the answer can be very large, return the remainder after dividing the count with 109+7.
 */
function soln(A, B) {
  const MOD = Math.pow(10, 9) + 7;
  let mp = new Map();
  let rslt = 0;
  for (let i of A) {
    i = parseInt(i);
    const comp1 = B + i;
    const comp2 = i - B;
    if (mp.has(comp1)) {
      rslt = ((rslt % MOD) + (mp.get(comp1) % MOD)) % MOD;
    }
    if (mp.has(comp2)) {
      rslt = ((rslt % MOD) + (mp.get(comp2) % MOD)) % MOD;
    }
    if (mp.has(i)) {
      mp.set(i, mp.get(i) + 1);
    } else {
      mp.set(i, 1);
    }
  }

  return rslt;
}

console.log(soln([3, 5, 1, 2], 4));
