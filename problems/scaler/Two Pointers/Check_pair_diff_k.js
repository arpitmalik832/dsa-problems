/**
 * Given an array A[n] and an integer B. Check if there exists a pair (i, j) such that A[i] - A[j] = B and i != j.
 */

/**
 * Approach: Brute force
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
function soln(A, B) {
  const n = A.length;
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      if (Math.abs(A[i] - A[j]) === B) {
        return true;
      }
    }
  }

  return false;
}

/**
 * Approach: Hashmap
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
function soln2(A, B) {
  const n = A.length;
  const map = new Map();

  for (let i = 0; i < n; i++) {
    // Check for both A[i] - B and A[i] + B as possible complements
    const complement1 = A[i] - B;
    const complement2 = A[i] + B;

    if (map.has(complement1) || map.has(complement2)) {
      return true;
    }

    map.set(A[i], i);
  }

  return false;
}

/**
 * Approach: Two pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
function soln3(A, B) {
  const n = A.length;
  let i = 0;
  let j = 1;
  while (j < n) {
    if (Math.abs(A[j] - A[i]) === B) {
      return true;
    } else if (Math.abs(A[j] - A[i]) < B) {
      j++;
    } else {
      i++;
      if (i === j) {
        j++;
      }
    }
  }

  return false;
}

// Test cases
console.log("Brute Force:");
console.log(soln([1, 2, 3, 4, 5], 1)); // true
console.log(soln([1, 2, 3, 4, 5], 2)); // true
console.log(soln([1, 2, 3, 4, 5], 3)); // true

console.log("\nHashmap (Corrected):");
console.log(soln2([1, 2, 3, 4, 5], 1)); // true
console.log(soln2([1, 2, 3, 4, 5], 2)); // true
console.log(soln2([1, 2, 3, 4, 5], 3)); // true

console.log("\nTwo Pointers:");
console.log(soln3([1, 2, 3, 4, 5], 1)); // true
console.log(soln3([1, 2, 3, 4, 5], 2)); // true
console.log(soln3([1, 2, 3, 4, 5], 3)); // true
