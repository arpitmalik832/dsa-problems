/**
 *  Min XOR value
 *
 * Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 *
 * Problem Constraints
 * 2 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 * Input Format
 * First and only argument of input contains an integer array A.
 *
 * Output Format
 * Return a single integer denoting minimum xor value.
 */
function soln(A) {
  A.sort((a, b) => a - b);

  let minXor = A[0] ^ A[1];

  for (let i = 2; i < A.length; i++) {
    minXor = Math.min(minXor, A[i] ^ A[i - 1]);
  }

  return minXor;
}

console.log(soln([0, 2, 5, 7])); // 1
console.log(soln([0, 4, 7, 9])); // 3
