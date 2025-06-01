/**
 * Given a number A, check if it is a magic number or not.
 * A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
 */
function sum(m) {
  if (m === 0) {
    return 0;
  }
  return parseInt(sum(parseInt(m / 10)) + (m % 10));
}

function totalSum(n) {
  if (parseInt(n / 10) === 0) {
    return n;
  }

  return totalSum(sum(n));
}

function soln(A) {
  if (totalSum(A) === 1) {
    return 1;
  } else {
    return 0;
  }
}

console.log(soln(83557));
