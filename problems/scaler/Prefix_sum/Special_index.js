/**
 * Given an array, find the count of array indices such that removing an element from these indices
 * makes the sum of even-indexed and odd-indexed array elements equal.
 *
 * @param {number[]} A - Input array
 * @return {number} - Count of special indices
 */
function countSpecialIndices(A) {
  const n = A.length;
  const evenPrefix = new Array(n).fill(0);
  const oddPrefix = new Array(n).fill(0);

  evenPrefix[0] = A[0];
  oddPrefix[0] = 0;

  // Calculate prefix sums
  for (let i = 1; i < n; i++) {
    if (i % 2 === 0) {
      evenPrefix[i] = evenPrefix[i - 1] + A[i];
      oddPrefix[i] = oddPrefix[i - 1];
    } else {
      evenPrefix[i] = evenPrefix[i - 1];
      oddPrefix[i] = oddPrefix[i - 1] + A[i];
    }
  }

  let count = 0;
  // Check each index
  for (let i = 0; i < n; i++) {
    let evenSum = 0;
    let oddSum = 0;

    // Calculate even sum after removing element at index i
    if (i === 0) {
      evenSum = oddPrefix[n - 1];
      oddSum = evenPrefix[n - 1] - A[0];
    } else {
      evenSum = evenPrefix[i - 1] + (oddPrefix[n - 1] - oddPrefix[i]);
      oddSum = oddPrefix[i - 1] + (evenPrefix[n - 1] - evenPrefix[i]);
    }

    if (evenSum === oddSum) {
      count++;
    }
  }

  return count;
}

// Test cases
console.log(countSpecialIndices([2, 1, 6, 4])); // Output: 1
console.log(countSpecialIndices([1, 1, 1])); // Output: 3
console.log(countSpecialIndices([1, 2, 3, 7, 1, 2, 3])); // Output: 1
