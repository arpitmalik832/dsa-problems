/**
 * Q. Count distinct elements
 *
 * Given an array A of N integers, return the number of unique elements in the array.
 */

function soln(A) {
  const hs = new Set();

  for (const i of A) {
    hs.add(i);
  }

  return hs.size;
}

console.log(soln([3, 4, 3, 6, 6]));
