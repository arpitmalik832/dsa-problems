/**
 * Return the first non-repeating character in a string
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(1) as we use fixed size array of 26 chars
 * Assumption: String contains only lowercase letters
 */
function soln(A) {
  const n = A.length;

  // Create fixed size array for lowercase letters (a-z)
  const freq = new Array(26).fill(0);

  // Count frequency of each character
  for (let i = 0; i < n; i++) {
    freq[A.charCodeAt(i) - "a".charCodeAt(0)]++;
  }

  // Find first char with frequency 1
  for (let i = 0; i < n; i++) {
    if (freq[A.charCodeAt(i) - "a".charCodeAt(0)] === 1) {
      return A[i];
    }
  }

  return "$";
}

// Test cases
console.log(soln("abcabd")); // "c"
console.log(soln("abcabc")); // "$"
console.log(soln("abcd")); // "a"
