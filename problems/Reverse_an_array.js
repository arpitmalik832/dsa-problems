/**
 * You are given an array of integers arr[]. Your task is to reverse the given array.
 *
 * Note: Modify the array in place.
 *
 * Examples:
 *
 * Input: arr = [1, 4, 3, 2, 6, 5]
 * Output: [5, 6, 2, 3, 4, 1]
 * Explanation: The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is 5 6 2 3 4 1.
 *
 * Input: arr = [4, 5, 2]
 * Output: [2, 5, 4]
 * Explanation: The elements of the array are 4 5 2. The reversed array will be 2 5 4.
 *
 * Input: arr = [1]
 * Output: [1]
 * Explanation: The array has only single element, hence the reversed array is same as the original.
 *
 * Constraints:
 * 1<=arr.size()<=105
 * 0<=arr[i]<=105
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Initialize two pointers, left and right
 * 2. Swap the elements at the left and right pointers
 * 3. Move the left pointer to the right and the right pointer to the left
 * 4. Repeat until the left pointer is greater than the right pointer
 */
const reverseArray = (arr) => {
  let left = 0;
  let right = arr.length - 1;
  while (left < right) {
    [arr[left], arr[right]] = [arr[right], arr[left]];
    left++;
    right--;
  }
  return arr;
};

console.log(reverseArray([1, 4, 3, 2, 6, 5]));
console.log(reverseArray([4, 5, 2]));
console.log(reverseArray([1]));
