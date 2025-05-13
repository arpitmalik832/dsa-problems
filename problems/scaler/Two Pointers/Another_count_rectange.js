/**
 * Given a sorted array of distinct integers A and an integer B, find and return how many rectangles
 * with distinct configurations can be created using elements of this array as length and breadth
 * whose area is lesser than B.
 *
 * @param {number[]} A - Sorted array of distinct integers
 * @param {number} B - Maximum area allowed
 * @return {number} - Number of distinct rectangle configurations with area < B
 */
function countRectangles(A, B) {
  const MOD = 1000000007;
  let count = 0;
  let left = 0;
  let right = A.length - 1;

  // Since A is sorted, we can use two pointers
  while (left <= right) {
    const area = A[left] * A[right];

    if (area < B) {
      // If area is less than B, all rectangles from left to right are valid
      // We need to count both (left,right) and (right,left) as distinct configurations
      count = (count + 2 * (right - left + 1) - 1) % MOD;
      left++;
    } else {
      right--;
    }
  }

  return count;
}

// Test cases
console.log(countRectangles([1, 2], 5)); // Output: 4
console.log(countRectangles([1, 2], 1)); // Output: 0
console.log(countRectangles([1, 2, 3], 10)); // Output: 9
console.log(countRectangles([1, 2, 3, 4, 5], 5)); // Output: 8
