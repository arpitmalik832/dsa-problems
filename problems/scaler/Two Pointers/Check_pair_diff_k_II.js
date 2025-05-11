/**
 * Given a sorted array A[n] and an integer B. Count the number of pairs (i, j) such that A[i] - A[j] = B and i != j.
 */

/**
 * Approach: Brute force
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
function soln(A, B) {
  const n = A.length;
  let count = 0;
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      if (Math.abs(A[i] - A[j]) === B) {
        count++;
      }
    }
  }

  return count;
}

/**
 * Approach: Hashmap
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
function soln2(A, B) {
  const n = A.length;
  const map = new Map();
  let count = 0;
  for (let i = 0; i < n; i++) {
    // Check for both A[i] - B and A[i] + B as possible complements
    const complement1 = A[i] + B;
    const complement2 = A[i] - B;

    if (map.has(complement1) || map.has(complement2)) {
      count++;
    }

    map.set(A[i], i);
  }

  return count;
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
  let count = 0;

  while (j < n) {
    const diff = A[j] - A[i];

    if (diff === B) {
      if (A[i] === A[j]) {
        while (j < n && A[i] === A[j]) {
          j++;
          i++;
          count++;
        }
      } else {
        // Count all pairs with same difference
        let counti = 0;
        let countj = 0;

        // Count duplicates of A[i]
        for (let k = i; k < j; k++) {
          if (A[k] === A[i]) {
            counti++;
          } else {
            break;
          }
        }

        // Count duplicates of A[j]
        for (let k = j; k < n; k++) {
          if (A[k] === A[j]) {
            countj++;
          } else {
            break;
          }
        }

        // Add all possible pairs
        count += counti * countj;

        // Move both pointers
        i += counti;
        j += countj;
      }
    } else if (diff < B) {
      j++;
    } else {
      i++;
      if (i === j) {
        j++;
      }
    }
  }

  return count;
}

// Test cases
console.log("Brute Force:");
console.log(soln([1, 2, 3, 4, 5], 1)); // 4 pairs: (1,2), (2,3), (3,4), (4,5)
console.log(soln([1, 2, 3, 4, 5], 2)); // 3 pairs: (1,3), (2,4), (3,5)
console.log(soln([1, 2, 3, 4, 5], 3)); // 2 pairs: (1,4), (2,5)

console.log("\nHashmap:");
console.log(soln2([1, 2, 3, 4, 5], 1)); // 4 pairs
console.log(soln2([1, 2, 3, 4, 5], 2)); // 3 pairs
console.log(soln2([1, 2, 3, 4, 5], 3)); // 2 pairs

console.log("\nTwo Pointers:");
console.log(soln3([1, 2, 3, 4, 5], 1)); // 4 pairs
console.log(soln3([1, 2, 3, 4, 5], 2)); // 3 pairs
console.log(soln3([1, 2, 3, 4, 5], 3)); // 2 pairs

// Additional test cases with duplicates
console.log("\nTest cases with duplicates:");
console.log(soln([1, 1, 1, 2, 2], 1)); // 6 pairs: (1,2) appears 6 times
console.log(soln2([1, 1, 1, 2, 2], 1)); // 6 pairs: (1,2) appears 6 times
console.log(soln3([1, 1, 1, 2, 2], 1)); // 6 pairs: (1,1) appears 6 times
