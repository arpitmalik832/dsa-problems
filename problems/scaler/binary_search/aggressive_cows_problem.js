/**
 * Aggressive cows Problem
 *
 * You are given n towns in the form of an array with their locations.
 * You are given number of cows to be placed.
 * You need to maximize the minimum distance between any two adjacent cows.
 */
/**
 *
 * @param {array} A - locations of each town
 * @param {int} B - no of cows to be placed
 */
function soln(A, B) {
  // Here first we'll need to sort the array the value of each element represents the location of the town.
  A.sort((a, b) => a - b);
  const n = A.length;
  // First we'll find the minimum and maximum such distance which can we achieved
  let lo = 1,
    hi = A[n - 1] - A[0];
  let rslt = 0;
  while (lo <= hi) {
    const mid = parseInt((lo + hi) / 2);
    if (isPossible(A, B, mid)) {
      rslt = mid;
      lo = mid + 1;
    } else {
      hi = mid - 1;
    }
  }

  return rslt;
}

function isPossible(A, B, dist) {
  let count = 1;
  let lastLocation = 0;
  for (let i = 1; i < A.length; i++) {
    if (A[i] - A[lastLocation] >= dist) {
      count++;
      lastLocation = i;
    }
    if (count === B) {
      return true;
    }
  }
  return false;
}
