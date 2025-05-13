/**
 * 3 Sum
 *
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 *
 * Assume that there will only be one solution.
 *
 * Problem Constraints
 *
 * -108 <= B <= 108
 * 1 <= N <= 104
 * -108 <= A[i] <= 108
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer B denoting the sum you need to get close to.
 *
 * Output Format
 *
 * Return a single integer denoting the sum of three integers which is closest to B.
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [-1, 2, 1, -4]
 * B = 1
 *
 * Input 2:
 *
 * A = [1, 2, 3]
 * B = 6
 *
 * Example Output
 *
 * Output 1:
 *
 * 2
 *
 * Output 2:
 *
 * 6
 */

function soln(A, B) {
  A = A.sort((a, b) => a - b);
  const n = A.length;

  // Initialize with first possible sum
  let closestSum = A[0] + A[1] + A[2];

  for (let i = 0; i < n - 2; i++) {
    let j = i + 1;
    let k = n - 1;

    while (j < k) {
      const sum = A[i] + A[j] + A[k];
      // Update closest sum if current sum is closer to B
      if (Math.abs(sum - B) < Math.abs(closestSum - B)) {
        closestSum = sum;
      }

      // If we found exact match, return immediately
      if (sum === B) {
        return sum;
      }

      // Move pointers based on sum comparison
      if (sum > B) {
        k--;
      } else {
        j++;
      }
    }
  }

  return closestSum;
}

console.log(soln([-1, 2, 1, -4], 1)); // 2
console.log(soln([1, 2, 3], 6)); // 6
