/**
 * Q. Longest Substring Without Repeat
 *
 * Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
 * Your task is to return an integer representing the "GOOD"ness of string A.
 * Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
 *
 * Problem Constraints
 * 1 <= size(A) <= 10^6
 *
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 *
 * Input Format
 * Single Argument representing string A.
 *
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 */
function soln(A) {
  const hs = new Set();
  let i = 0,
    j = 0;
  let n = A.length;
  let ans = 0;
  while (j < n) {
    if (!hs.has(A[j])) {
      hs.add(A[j]);
    } else {
      while (hs.has(A[j])) {
        hs.delete(A[i]);
        i++;
      }
      hs.add(A[j]);
    }
    ans = Math.max(ans, hs.size);
    j++;
  }

  return ans;
}

console.log(soln("abcabcd"));
