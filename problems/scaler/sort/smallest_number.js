/**
 * Q. Smallest Number
 *
 * An integer is given to you in the form of an array, with each element being a separate digit.
 *
 * Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.
 *
 * Note - Do not use any sorting algorithm or library's sort method.
 */
function soln(A) {
  const freq = new Array(10).fill(0);
  for (const a of A) {
    freq[a]++;
  }

  let i = 0;
  for (let j = 0; j < 10; j++) {
    for (let x = 0; x < freq[j]; x++) {
      A[i] = j;
      i++;
    }
  }

  return A;
}

console.log(soln([6, 3, 4, 2, 7, 2, 1]));
