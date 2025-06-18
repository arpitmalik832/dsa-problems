/**
 * Q. Maximum height of staircase
 *
 * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
 *
 * The first stair would require only one block, and the second stair would require two blocks, and so on.
 *
 * Find and return the maximum height of the staircase.
 *
 * Problem Constraints
 * 0 <= A <= 109
 */
function soln(A) {
  /**
   * Answer would be the max where n * (n + 1) <=  2 * A
   * n ^ 2 + n - 2 * A = 0
   * => n = (-1 (+/-) Math.sqrt(1 + 8 * A)) / 2
   */
  const x1 = parseInt((-1 - Math.sqrt(1 + 8 * A)) / 2);
  const x2 = parseInt((-1 + Math.sqrt(1 + 8 * A)) / 2);
  return Math.max(x1, x2);
}
