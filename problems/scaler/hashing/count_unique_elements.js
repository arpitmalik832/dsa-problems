/**
 * Q. Count unique elements
 *
 * You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.
 */

function soln(A) {
  const mp = new Map();
  for (const i of A) {
    if (mp.has(i)) {
      mp.set(i, mp.get(i) + 1);
    } else {
      mp.set(i, 1);
    }
  }

  let rslt = 0;
  mp.forEach((v) => {
    if (v === 1) {
      rslt++;
    }
  });

  return rslt;
}

console.log(soln([3, 4, 3, 6, 6]));
