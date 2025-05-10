/**
 * Flip
 *
 * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
 *
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 *
 * Problem Constraints
 *
 * 1 <= size of string <= 100000
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 * Output Format
 *
 * Return an array of integers denoting the answer.
 *
 * Example Input
 *
 * Input 1:
 *
 * A = "010"
 *
 * Input 2:
 *
 * A = "111"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [1, 1]
 *
 * Output 2:
 *
 * []
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * A = "010"
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | "110"
 * [1 2]          | "100"
 * [1 3]          | "101"
 * [2 2]          | "000"
 * [2 3]          | "001"
 *
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 *
 * Explanation 2:
 *
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */

/**
 * Brute Force Approach
 * Complexity: O(N^3)
 * Space: O(N)
 */
function soln(A) {
  const N = A.length;
  let arr = A.split("");
  let maxCount = arr.filter((i) => i === "1").length;
  let rslt = [];

  for (let i = 0; i < N; i++) {
    for (let j = i; j < N; j++) {
      arr = A.split("");
      for (let k = i; k <= j; k++) {
        if (arr[k] === "0") {
          arr[k] = "1";
        } else {
          arr[k] = "0";
        }
      }

      const count = arr.filter((i) => i === "1").length;
      if (maxCount < count) {
        maxCount = count;
        rslt = [i + 1, j + 1];
      }
    }
  }

  return rslt;
}

/**
 * Optimized Approach using Kadane's Algorithm
 * Complexity: O(N)
 * Space: O(N)
 */
function soln2(A = "") {
  const arr = A.split("").map((i) => (i === "1" ? -1 : 1));
  const N = arr.length;

  let i = 0;
  let maxI = 0;
  let maxJ = 0;
  let maxSoFar = arr[0];
  let maxEndingHere = arr[0];

  for (let k = 1; k < N; k++) {
    if (maxEndingHere >= 0) {
      maxEndingHere += arr[k];
    } else {
      maxEndingHere = arr[k];
      i = k;
    }
    if (maxSoFar < maxEndingHere) {
      maxSoFar = maxEndingHere;
      maxI = i;
      maxJ = k;
    }
  }

  return maxSoFar > 0 ? [maxI + 1, maxJ + 1] : [];
}

// console.log(soln("010")); // [1, 1]
// console.log(soln("111")); // []
// console.log(soln2("010")); // [1, 1]
// console.log(soln2("111")); // []
console.log(soln2("1101010001")); // [3, 9]
