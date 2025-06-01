/**
 * Given an integer array A of size N denoting collection of numbers , return all possible subsets.
 * NOTE: Array can contain duplicate elements.
 */
function soln(A) {
  const n = A.length;
  const rslt = [];
  const seen = new Set();
  for (let i = 0; i < 1 << n; i++) {
    const subset = [];
    for (let j = 0; j < n; j++) {
      if (i & (1 << j)) {
        subset.push(A[j]);
      }
    }
    const subsetStr = JSON.stringify(subset);
    if (!seen.has(subsetStr)) {
      rslt.push(subset);
      seen.add(subsetStr);
    }
  }
  return rslt;
}

console.log(soln([1, 2, 2]));
