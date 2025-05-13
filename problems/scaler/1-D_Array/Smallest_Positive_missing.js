/**
 * Smallest Positive Missing
 *
 * You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
 *
 * Note: Positive number starts from 1. The array can have negative integers too.
 *
 * Examples:
 *
 * Input: arr[] = [2, -3, 4, 1, 1, 7]
 * Output: 3
 * Explanation: Smallest positive missing number is 3.
 *
 * Input: arr[] = [5, 3, 2, 5, 1]
 * Output: 4
 * Explanation: Smallest positive missing number is 4.
 *
 * Input: arr[] = [-8, 0, -1, -4, -3]
 * Output: 1
 * Explanation: Smallest positive missing number is 1.
 *
 * Constraints:
 * 1 <= arr.size() <= 105
 * -106 <= arr[i] <= 106
 */

/**
 * Approach:
 * The optimal way to find the smallest positive missing number from an unsorted array is to use the index marking (cyclic sort) approach, which works in O(n) time and O(1) extra space.
 *
 * Steps:
 * 1. Iterate through the array and for each element, check if it is positive and less than or equal to the size of the array.
 * 2. If it is, then swap the element with the element at the index of the current element.
 * 3. After swapping, the element at the current index will be in the correct position.
 * 4. After the loop, iterate through the array and find the first element that is not in the correct position.
 * 5. Return the first element that is not in the correct position.
 */

const smallestPositiveMissing = (A) => {
  const size = A.length;

  for (let i = 0; i < size; i++) {
    if (A[i] <= 0) {
      A[i] = size + 2;
    }
  }

  for (let i = 0; i < size; i++) {
    const val = Math.abs(A[i]);
    if (val >= 1 && val <= size + 1) {
      A[val - 1] = -Math.abs(A[val - 1]);
    }
  }

  for (let i = 0; i < size; i++) {
    if (A[i] > 0) {
      return i + 1;
    }
  }

  return size + 1;
};

console.log(smallestPositiveMissing([2, -3, 4, 1, 1, 7])); // 3
console.log(smallestPositiveMissing([5, 3, 2, 5, 1])); // 4
console.log(smallestPositiveMissing([-8, 0, -1, -4, -3])); // 1
