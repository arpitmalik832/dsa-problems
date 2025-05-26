/**
 * Q. Single Number II
 *
 * Given an array of integers, every element appears thrice except for one, which occurs once.
 *
 * Find that element that does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 */

function checkBit(n, i) {
  return (n & (1 << i)) !== 0;
}

function soln(A) {
  let ans = 0;
  for (let i = 0; i < 32; i++) {
    let count = 0;
    for (let j = 0; j < A.length; j++) {
      count += checkBit(A[j], i);
    }
    if (count % 3 != 0) {
      ans |= 1 << i;
    }
  }
  return ans;
}

console.log(soln([1, 2, 4, 3, 3, 2, 2, 3, 1, 1])); // 4
