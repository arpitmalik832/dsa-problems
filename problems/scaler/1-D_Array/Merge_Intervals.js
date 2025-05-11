/**
 * Merge Sorted Overlapping Intervals
 *
 * You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.
 *
 * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
 *
 * Problem Constraints
 *
 * 1 <= len(A) <= 100000.
 * 1 <= A[i][0] <= A[i][1] <= 100000
 *
 * A is sorted based on the start value (A[i][0])
 *
 * Input Format
 *
 * First argument is a list of intervals in 2-Dimensional Array.
 *
 * Output Format
 *
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 * Example Input
 *
 * Input 1:
 * [ [1, 3], [2, 6], [8, 10], [15, 18] ]
 *
 * Input 2:
 * [ [2, 10], [4, 9], [6, 7] ]
 *
 * Example Output
 *
 * Output 1:
 * [ [1, 6], [8, 10], [15, 18] ]
 *
 * Output 2:
 * [ [2, 10] ]
 *
 */

/** Approach 1: Brute Force Solution
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
function soln(A) {
  if (!A || A.length === 0) return [];

  // Create a copy of input array to avoid modifying original
  let intervals = [...A];
  let merged = [];
  let n = intervals.length;

  // For each interval, check if it overlaps with any other interval
  for (let i = 0; i < n; i++) {
    let current = intervals[i];
    let isMerged = false;

    // Check if current interval can be merged with any existing merged interval
    for (let j = 0; j < merged.length; j++) {
      if (current[0] <= merged[j][1] && current[1] >= merged[j][0]) {
        // Merge the intervals
        merged[j][0] = Math.min(merged[j][0], current[0]);
        merged[j][1] = Math.max(merged[j][1], current[1]);
        isMerged = true;
        break;
      }
    }

    // If not merged with any existing interval, add as new
    if (!isMerged) {
      merged.push(current);
    }
  }

  return merged;
}

/** Approach 2: Optimized Solution using Single Pass
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
function soln2(A) {
  if (!A || A.length === 0) return [];

  let result = [];
  let currentInterval = A[0];

  for (let i = 1; i < A.length; i++) {
    // If current interval overlaps with the next interval
    if (currentInterval[1] >= A[i][0]) {
      // Merge the intervals
      currentInterval[1] = Math.max(currentInterval[1], A[i][1]);
    } else {
      // No overlap, add current interval to result
      result.push(currentInterval);
      currentInterval = A[i];
    }
  }

  // Add the last interval
  result.push(currentInterval);

  return result;
}

/** Approach 3: Using Stack (Alternative Implementation)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
function soln3(A) {
  if (!A || A.length === 0) return [];

  let stack = [];
  // Sort intervals by start time (though input is already sorted)
  A.sort((a, b) => a[0] - b[0]);

  // Push first interval to stack
  stack.push(A[0]);

  for (let i = 1; i < A.length; i++) {
    let top = stack[stack.length - 1];

    // If current interval overlaps with top of stack
    if (top[1] >= A[i][0]) {
      // Update the end of top interval
      top[1] = Math.max(top[1], A[i][1]);
    } else {
      // Push current interval to stack
      stack.push(A[i]);
    }
  }

  return stack;
}

// Test cases
console.log("Brute Force Approach:");
console.log(
  soln([
    [1, 3],
    [2, 6],
    [8, 10],
    [15, 18],
  ])
); // [[1, 6], [8, 10], [15, 18]]
console.log(
  soln([
    [2, 10],
    [4, 9],
    [6, 7],
  ])
); // [[2, 10]]

console.log("\nOptimized Approach:");
console.log(
  soln2([
    [1, 3],
    [2, 6],
    [8, 10],
    [15, 18],
  ])
); // [[1, 6], [8, 10], [15, 18]]
console.log(
  soln2([
    [2, 10],
    [4, 9],
    [6, 7],
  ])
); // [[2, 10]]

console.log("\nStack Approach:");
console.log(
  soln3([
    [1, 3],
    [2, 6],
    [8, 10],
    [15, 18],
  ])
); // [[1, 6], [8, 10], [15, 18]]
console.log(
  soln3([
    [2, 10],
    [4, 9],
    [6, 7],
  ])
); // [[2, 10]]
