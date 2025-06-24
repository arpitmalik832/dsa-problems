/**
 * Q. Allocate Books
 *
 * Given an array of integers A of size N and an integer B.
 *
 * The College library has N books. The ith book has A[i] number of pages.
 *
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 *
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 *
 * NOTE: Return -1 if a valid assignment is not possible.
 */
function soln(A, B) {
  if (B > A.length) {
    return -1;
  }

  let lo = 0,
    hi = 0;
  for (const a of A) {
    lo = Math.max(a, lo);
    hi += a;
  }

  let rslt = -1;
  while (lo <= hi) {
    const mid = parseInt((lo + hi) / 2);
    if (isPossible(A, B, mid)) {
      rslt = mid;
      hi = mid - 1;
    } else {
      lo = mid + 1;
    }
  }

  return rslt;
}

function isPossible(A, B, pages) {
  const n = A.length;
  let count = 1;
  let curr = A[0];
  for (let i = 1; i < n; i++) {
    curr += A[i];
    if (curr > pages) {
      curr = A[i];
      count++;
    }
    if (count > B) {
      return false;
    }
  }

  return true;
}

// console.log(soln([12, 34, 67, 90], 12));
console.log(soln([73, 58, 30, 72, 44, 78, 23, 9], 5));
