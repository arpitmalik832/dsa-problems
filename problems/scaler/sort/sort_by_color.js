/**
 * Q. Sort by Color
 *
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will represent the colors as,
 *
 * red -> 0
 * white -> 1
 * blue -> 2
 *
 * Note: Using the library sort function is not allowed.
 */
function soln(A) {
  let freq = [0, 0, 0];
  for (const a of A) {
    freq[a]++;
  }
  let i = 0;
  for (let x = 0; x < 3; x++) {
    for (let k = 0; k < freq[x]; k++) {
      A[i] = x;
      i++;
    }
  }

  return A;
}

console.log(soln([0, 1, 2, 0, 1, 2]));
