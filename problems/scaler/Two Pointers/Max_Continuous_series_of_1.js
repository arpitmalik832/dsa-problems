/**
 * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
 * For this problem, return the indices of maximum continuous series of 1s in order.
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */

function maxContinuousSeriesOf1s(A, B) {
  let left = 0;
  let right = 0;
  let zeroCount = 0;
  let maxLength = 0;
  let startIndex = 0;

  // Sliding window approach
  while (right < A.length) {
    // If we encounter a 0, increment zeroCount
    if (A[right] === 0) {
      zeroCount++;
    }

    // If zeroCount exceeds B, shrink window from left
    while (zeroCount > B) {
      if (A[left] === 0) {
        zeroCount--;
      }
      left++;
    }

    // Update maxLength and startIndex if current window is larger
    if (right - left + 1 > maxLength) {
      maxLength = right - left + 1;
      startIndex = left;
    }

    right++;
  }

  // Generate the result array with indices
  const result = [];
  for (let i = startIndex; i < startIndex + maxLength; i++) {
    result.push(i);
  }

  return result;
}

// Test cases
console.log(maxContinuousSeriesOf1s([1, 1, 0, 1, 1, 0, 0, 1, 1, 1], 1)); // Should return [0, 1, 2, 3, 4]
console.log(maxContinuousSeriesOf1s([1, 0, 0, 0, 1], 2)); // Should return [0, 1, 2, 3, 4]
