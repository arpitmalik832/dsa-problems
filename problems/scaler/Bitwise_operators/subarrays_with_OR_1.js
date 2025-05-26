/**
 * Q. Subarrays with OR 1
 *
 * You are given a binary array A of length N where each element is either 0 or 1.
 *
 * Your task is to count the number of subarrays where the bitwise OR of all the elements in the subarray is 1.
 *
 * Problem Constraints
 *
 * 1 <= N <= 10^4
 * A[i] is either 0 or 1
 *
 */
function soln(A) {
  const n = A.length;
  const totalSubarrays = (n * (n + 1)) / 2;

  let zeroCount = 0;

  let tempCount = 0;
  for (const i of A) {
    if (i === 0) {
      tempCount++;
    } else {
      zeroCount += (tempCount * (tempCount + 1)) / 2;
      tempCount = 0;
    }
  }
  zeroCount += (tempCount * (tempCount + 1)) / 2;

  return totalSubarrays - zeroCount;
}

console.log(soln([1, 0, 1])); // 5
