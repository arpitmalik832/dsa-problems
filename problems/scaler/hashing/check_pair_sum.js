/**
 * Q. Check Pair Sum
 *
 * Given an Array of integers B, and a target sum A.
 * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 */
function soln(A, B) {
  const hm = new Set();

  for (let i = 0; i < A.length; i++) {
    const comp = B - A[i];
    if (hm.has(comp)) {
      return 1;
    } else {
      hm.add(A[i]);
    }
  }

  return 0;
}

console.log(soln([1, 2, 3, 4, 5], 9));
console.log(soln([23, 52, 95, 29, 9, 47, 49, 55, 96, 4], 100));
