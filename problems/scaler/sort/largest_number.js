/**
 * Q1. Largest Number
 *
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
function soln(A) {
  A.sort((a, b) => {
    if (
      BigInt(a.toString() + b.toString()) >= BigInt(b.toString() + a.toString())
    ) {
      return -1;
    } else {
      return 1;
    }
  });
  if (A[0] === 0) {
    return "0";
  }

  return A.join("");
}
