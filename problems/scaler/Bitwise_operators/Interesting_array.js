/**
 * Q. Interesting Array
 *
 * You have an array A with N elements. We have two types of operation available on this array :
 * We can split an element B into two elements, C and D, such that B = C + D.
 * We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
 * You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^6
 *
 * Example Input
 * Input 1:
 *  A = [9, 17]
 * Input 2:
 *  A = [1]
 *
 * Example Output
 * Output 1:
 *  Yes
 * Output 2:
 *  No
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Approach:
 * 1. Calculate sum of all elements
 * 2. If sum is even, we can make array sum to 0
 * 3. If sum is odd, we cannot make array sum to 0
 *
 * Why this works:
 * - When we split a number B into C and D, their sum remains B (C + D = B)
 * - When we merge two numbers P and Q, their XOR (P ^ Q) will have the same parity as their sum
 * - To get 0 as final result, we need the sum to be even
 */
function soln1(A) {
  const sum = A.reduce((acc, curr) => acc + curr, 0);
  return sum % 2 === 0 ? "Yes" : "No";
}

console.log(soln1([9, 17])); // Yes (sum = 26, even)
console.log(soln1([1])); // No (sum = 1, odd)
