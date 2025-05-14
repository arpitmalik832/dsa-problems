/**
 * Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges
 * the numbers into the lexicographically next greater permutation. If no such permutation exists,
 * rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
 *
 * Examples:
 * Input: arr = [2, 4, 1, 7, 5, 0]
 * Output: [2, 4, 5, 0, 1, 7]
 *
 * Input: arr = [3, 2, 1]
 * Output: [1, 2, 3]
 *
 * Input: arr = [3, 4, 2, 5, 1]
 * Output: [3, 4, 5, 1, 2]
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Find the first pair from right where arr[i] < arr[i+1]
 * 2. If no such pair is found, reverse the array
 * 3. If such a pair is found, find the smallest number greater than arr[i]
 * 4. Swap the numbers
 * 5. Reverse the suffix after i
 */
function nextPermutation(arr) {
  const n = arr.length;
  let i = n - 2;

  // Find the first pair from right where arr[i] < arr[i+1]
  while (i >= 0 && arr[i] >= arr[i + 1]) {
    i--;
  }

  if (i >= 0) {
    let j = n - 1;
    // Find the smallest number greater than arr[i]
    while (j > i && arr[j] <= arr[i]) {
      j--;
    }
    // Swap the numbers
    [arr[i], arr[j]] = [arr[j], arr[i]];
  }

  // Reverse the suffix after i
  let left = i + 1;
  let right = n - 1;
  while (left < right) {
    [arr[left], arr[right]] = [arr[right], arr[left]];
    left++;
    right--;
  }

  return arr;
}

// Test cases
console.log(nextPermutation([2, 4, 1, 7, 5, 0])); // [2, 4, 5, 0, 1, 7]
console.log(nextPermutation([3, 2, 1])); // [1, 2, 3]
console.log(nextPermutation([3, 4, 2, 5, 1])); // [3, 4, 5, 1, 2]
