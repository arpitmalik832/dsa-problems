/**
 * Q. Find nth Magic Number
 *
 * Given an integer A, find and return the Ath magic number.
 * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 */
function checkBit(A, B) {
  return ((A >> B) & 1) == 1;
}

function soln(A) {
  let rslt = 0;
  for (let i = 0; i < 32; i++) {
    if (checkBit(A, i)) {
      rslt += Math.pow(5, i + 1);
    }
  }

  return rslt;
}

console.log(soln(1));
console.log(soln(3));
console.log(soln(4));
