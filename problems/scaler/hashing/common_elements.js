/**
 * Q. Common Elements
 *
 * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
 *
 * NOTE:
 *
 * Each element in the result should appear as many times as it appears in both arrays.
 * The result can be in any order.
 */

function soln(A, B) {
  // Just write your code below to complete the function. Required input is available to you as the function arguments.
  // Do not print the result or any output. Just return the result via this function.
  const mp = new Map();
  for (const i of A) {
    if (mp.has(i)) {
      mp.set(i, mp.get(i) + 1);
    } else {
      mp.set(i, 1);
    }
  }

  let rslt = [];
  for (const i of B) {
    if (mp.has(i)) {
      rslt.push(i);
      if (mp.get(i) === 1) {
        mp.delete(i);
      } else {
        mp.set(i, mp.get(i) - 1);
      }
    }
  }

  return rslt;
}

console.log(soln([1, 2, 2, 1], [2, 3, 1, 2]));
