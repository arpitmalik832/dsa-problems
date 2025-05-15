/**
 * Anagram - Optimized version using single frequency array
 * Time Complexity: O(n)
 * Space Complexity: O(1) - using single array of fixed size 26
 */
function soln(A, B) {
  const n = A.length;
  const m = B.length;

  if (n !== m) return 0;

  // Single frequency array
  const freq = new Array(26).fill(0);

  // Increment count for chars in A, decrement for chars in B
  for (let i = 0; i < n; i++) {
    freq[A[i].charCodeAt(0) - "a".charCodeAt(0)]++;
    freq[B[i].charCodeAt(0) - "a".charCodeAt(0)]--;
  }

  // If strings are anagrams, all frequencies should be 0
  for (let i = 0; i < 26; i++) {
    if (freq[i] !== 0) return 0;
  }

  return 1;
}

console.log(soln("abc", "acb")); // 1
console.log(soln("abc", "acd")); // 0
console.log(soln("geeks", "kseeg")); // 1
