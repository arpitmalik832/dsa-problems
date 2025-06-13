/**
 * Q. Count Sort
 *
 * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 105
 */
function soln(A) {
  let freq = new Array(100001).fill(0);
  for (const a of A) {
    freq[a]++;
  }

  let i = 0;
  for (let j = 0; j < 100001; j++) {
    for (let x = 0; x < freq[j]; x++) {
      A[i] = j;
      i++;
    }
  }

  return A;
}

console.log(soln([1, 3, 1]));
