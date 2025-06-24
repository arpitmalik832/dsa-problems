/**
 * Q. Find Smallest Again
 *
 * Given an integer array A of size N.
 *
 * If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
 *
 * NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
 *
 * Problem Constraints
 * 3 <= N <= 500
 * 1 <= A[i] <= 108
 * 1 <= B <= (N*(N-1)*(N-2))/6
 */
function cnt(A, mid) {
  const n = A.length;
  let count = 0;
  for (let i = 0; i < n - 2; i++) {
    let j = i + 1;
    let k = n - 1;
    while (j < k) {
      const s = A[i] + A[j] + A[k];
      if (s <= mid) {
        count += k - j;
        j++;
      } else {
        k--;
      }
    }
  }
  return count;
}

function soln(A, B) {
  A.sort((a, b) => a - b);
  const n = A.length;
  let lo = A[0] + A[1] + A[2],
    hi = A[n - 2] + A[n - 1] + A[n - 1];
  while (lo <= hi) {
    const mid = parseInt((lo + hi) / 2);
    const count = cnt(A, mid);
    if (count < B) {
      lo = mid + 1;
    } else {
      hi = mid - 1;
    }
  }

  return lo;
}
