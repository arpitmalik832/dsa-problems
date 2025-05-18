/**
 * Q8. Different Bits Sum Pairwise
 *
 * Problem Description
 *
 * We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
 * For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
 *
 * You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 2^31 - 1
 *
 */

/**
 * Time Complexity Expectations as per constraints:
 * TC             Iterations     Remarks
 * O(N^2)         10^10          TLE
 * O(N*log(N))    10^6           AC
 * O(N)           10^5           AC
 */

/**
 * Brute Force Approach
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
function countDifferentBits(x, y) {
  let count = 0;
  while (x > 0 || y > 0) {
    if ((x & 1) !== (y & 1)) {
      count++;
    }
    x >>= 1;
    y >>= 1;
  }
  return count;
}

function soln1(A) {
  const length = A.length;

  let sum = 0;
  for (let i = 0; i < length; i++) {
    for (let j = 0; j < length; j++) {
      sum = (sum + countDifferentBits(A[i], A[j])) % 1000000007;
    }
  }
  return sum;
}

/**
 * Optimized Approach
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
function soln2(A) {
  const length = A.length;
  let sum = 0;

  // For each bit position (0 to 31)
  for (let i = 0; i < 32; i++) {
    let countOnes = 0;

    // Count numbers that have 1 at current bit position
    for (let j = 0; j < length; j++) {
      if ((A[j] >> i) & 1) {
        countOnes++;
      }
    }

    // Calculate different bits at this position
    // countOnes * (length - countOnes) gives us pairs with different bits
    // Multiply by 2 because each pair is counted twice (i,j and j,i)
    sum = (sum + countOnes * (length - countOnes) * 2) % 1000000007;
  }

  return sum;
}

console.log(soln1([1, 3, 5]));
console.log(soln2([1, 3, 5]));
