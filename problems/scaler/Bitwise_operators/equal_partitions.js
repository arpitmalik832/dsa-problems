/**
 * Partition Array into Two Equal Product Subsets
 *
 * You are given an integer array nums containing distinct positive integers and an integer target.
 *
 * Determine if you can partition nums into two non-empty disjoint subsets, with each element belonging to exactly one subset, such that the product of the elements in each subset is equal to target.
 *
 * Return true if such a partition exists and false otherwise.
 *
 * A subset of an array is a selection of elements of the array.
 */

// Original solution - O(n * 2^n)
function soln(nums, target) {
  const n = nums.length;
  const total = 1 << n;

  let totalProd = 1;
  for (const i of nums) {
    if (i > target) return false;
    totalProd *= i;
  }

  if (totalProd !== target * target) return false;

  for (let i = 1; i < total / 2; i++) {
    let prod = 1;
    let isOverFlowed = false;
    for (let j = 0; j < n; j++) {
      if (i & (1 << j)) {
        prod *= nums[j];
        if (prod > target) {
          isOverFlowed = true;
          break;
        }
      }
    }
    if (isOverFlowed) continue;
    if (prod == target) return true;
  }

  return false;
}

console.log("Original solution:", soln([3, 1, 6, 8, 4], 24));
