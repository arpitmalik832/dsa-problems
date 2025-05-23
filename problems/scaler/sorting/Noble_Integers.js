/**
 * Noble Integers
 *
 * Noble Integers are the ones for whom count of the integers less than it is equal to the integer value.
 */

function soln(A) {
  A.sort((a, b) => a - b);

  let rslt = 0;
  for (const i in A) {
    if (i + 1 === A[i]) {
      rslt++;
    }
  }

  return rslt;
}

console.log(soln([1, 2, 3, 5, 5]));
