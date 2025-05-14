/**
 * Boyer-Moore Voting Algorithm
 *
 * Given an array of integers where each number represents a vote to a candidate,
 * return the candidates that have votes greater than one-third of the total votes.
 * If there's no majority vote, return an empty array.
 *
 * Examples:
 * Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 * Output: [5, 6]
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: []
 */

/**
 * Using Boyer-Moore Voting Algorithm
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Initialize two candidates and their counts
 * 2. Iterate through the array and update the candidates and their counts
 * 3. After the first pass, verify the candidates
 * 4. Add the candidates that meet the threshold to the result
 * 5. Sort the result in increasing order
 */
function majorityElement(arr) {
  const n = arr.length;
  const threshold = Math.floor(n / 3);
  const result = [];

  // Initialize candidates and their counts
  let candidate1 = null,
    candidate2 = null;
  let count1 = 0,
    count2 = 0;

  // First pass: Find potential candidates
  for (const num of arr) {
    if (num === candidate1) {
      count1++;
    } else if (num === candidate2) {
      count2++;
    } else if (count1 === 0) {
      candidate1 = num;
      count1 = 1;
    } else if (count2 === 0) {
      candidate2 = num;
      count2 = 1;
    } else {
      count1--;
      count2--;
    }
  }

  // Second pass: Verify candidates
  count1 = 0;
  count2 = 0;

  for (const num of arr) {
    if (num === candidate1) count1++;
    else if (num === candidate2) count2++;
  }

  // Add candidates that meet the threshold
  if (count1 > threshold) result.push(candidate1);
  if (count2 > threshold) result.push(candidate2);

  // Sort the result in increasing order
  return result.sort((a, b) => a - b);
}

// Test cases
console.log(majorityElement([2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6])); // [5, 6]
console.log(majorityElement([1, 2, 3, 4, 5])); // []
console.log(majorityElement([1, 1, 1, 3, 3, 2, 2, 2])); // [1, 2]
console.log(majorityElement([1, 3])); // [1, 3]
