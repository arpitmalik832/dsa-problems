/**
 * Q. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
function soln(nums, k) {
  const hm = new Map();
  for (let i = 0; i < nums.length; i++) {
    if (hm.has(nums[i])) {
      hm.set(nums[i], hm.get(nums[i]) + 1);
    } else {
      hm.set(nums[i], 1);
    }
  }

  let buckets = new Array(nums.length + 1).fill(null);

  for (const [key, value] of hm) {
    if (buckets[value] == null) {
      buckets[value] = new Array();
    }
    buckets[value].push(key);
  }

  const rslt = [];

  for (let j = buckets.length - 1; j >= 0 && rslt.length < k; j--) {
    if (buckets[j] != null) {
      rslt.push(...buckets[j]);
    }
  }

  return rslt;
}

console.log(soln([1, 1, 1, 2, 2, 3], 2));
