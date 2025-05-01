/**
 * Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
 *
 * Note: Consider the array as circular.
 *
 * Examples :
 *
 * Input: arr[] = [1, 2, 3, 4, 5], d = 2
 * Output: [3, 4, 5, 1, 2]
 * Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
 *
 * Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
 * Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
 * Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
 *
 * Input: arr[] = [7, 3, 9, 1], d = 9
 * Output: [3, 9, 1, 7]
 * Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.
 *
 * Constraints:
 * 1 <= arr.size(), d <= 105
 * 0 <= arr[i] <= 105
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Reverse the entire array
 * 2. Reverse the first n-d elements
 * 3. Reverse the remaining d elements
 */
function rotateArray(arr, d) {
  const n = arr.length;
  d = d % n; // Handle cases where d > n

  // Helper function to reverse a portion of the array
  const reverse = (start, end) => {
    while (start < end) {
      [arr[start], arr[end]] = [arr[end], arr[start]];
      start++;
      end--;
    }
  };

  // Reverse the entire array
  reverse(0, n - 1);
  // Reverse the first n-d elements
  reverse(0, n - d - 1);
  // Reverse the remaining d elements
  reverse(n - d, n - 1);

  return arr;
}

console.log(rotateArray([1, 2, 3, 4, 5], 2));
