/**
 * Count pairs with sum k
 * Given an array A[n] and an integer B. Count all pairs (i, j) such that A[i] + A[j] = B and i != j.
 */

/**
 * Approach: Brute force
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
const soln = (A, B) => {
  const n = A.length;
  let count = 0;
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      if (A[i] + A[j] === B) {
        count++;
      }
    }
  }
  return count;
};

/**
 * Approach: Hashmap
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
const soln2 = (A, B) => {
  const n = A.length;
  const map = new Map();
  let count = 0;

  for (let i = 0; i < n; i++) {
    const complement = B - A[i];
    if (map.has(complement)) {
      count += map.get(complement);
    }
    map.set(A[i], (map.get(A[i]) || 0) + 1);
  }

  return count;
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
  let count = 0;
  while (i < j) {
    const sum = A[i] + A[j];
    if (sum === B) {
      if (A[i] === A[j]) {
        count += j - i + 1;
        break;
      } else {
        let counti = 0;
        for (let k = i; k < j; k++) {
          if (A[k] === A[i]) {
            counti++;
          } else {
            break;
          }
        }
        let countj = 0;
        for (let k = j; k > i; k--) {
          if (A[k] === A[j]) {
            countj++;
          } else {
            break;
          }
        }
        count += counti * countj;
        i += counti;
        j -= countj;
      }
    } else if (sum < B) {
      i++;
    } else {
      j--;
    }
  }

  return count;
};

// Test cases
console.log("Brute Force:");
console.log(soln([1, 2, 3, 4, 5], 5)); // 2 pairs: (1,4) and (2,3)
console.log(soln([1, 1, 1], 2)); // 3 pairs: (1,1) appears 3 times

console.log("\nHashmap:");
console.log(soln2([1, 2, 3, 4, 5], 5)); // 2 pairs: (1,4) and (2,3)
console.log(soln2([1, 1, 1], 2)); // 3 pairs: (1,1) appears 3 times

console.log("\nTwo pointers:");
console.log(soln3([1, 2, 3, 4, 5], 5)); // 2 pairs: (1,4) and (2,3)
console.log(soln3([1, 1, 1], 2)); // 3 pairs: (1,1) appears 3 times
