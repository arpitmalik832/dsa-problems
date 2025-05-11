/**
 * Given A[n] of sorted elements. Check if there exists a pair (i, j) such that A[i] + A[j] = k and i != j.
 */

/**
 * Approach: Brute force
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
const soln = (A, B) => {
  const n = A.length;
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      if (A[j] + A[i] === B) {
        return true;
      }
    }
  }

  return false;
};

/**
 * Approach: Hashmap
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
const soln2 = (A, B) => {
  const n = A.length;
  const map = new Map();
  for (let i = 0; i < n; i++) {
    const complement = B - A[i];
    if (map.has(complement)) {
      return true;
    }
    map.set(A[i], i);
  }

  return false;
};

/**
 * Approach: Two pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
const soln3 = (A, B) => {
  const n = A.length;
  let i = 0;
  let j = n - 1;
  while (i < j) {
    const sum = A[i] + A[j];
    if (sum === B) {
      return true;
    } else if (sum < B) {
      i++;
    } else {
      j--;
    }
  }

  return false;
};

// Test cases
console.log("Brute Force:");
console.log(soln([1, 2, 3, 4, 5], 5)); // true
console.log(soln([1, 1, 1], 2)); // true

console.log("\nHashmap:");
console.log(soln2([1, 2, 3, 4, 5], 5)); // true
console.log(soln2([1, 1, 1], 2)); // true

console.log("\nTwo pointers:");
console.log(soln3([1, 2, 3, 4, 5], 5)); // true
console.log(soln3([1, 1, 1], 2)); // true
