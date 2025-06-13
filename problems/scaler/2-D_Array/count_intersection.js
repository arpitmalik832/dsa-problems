/**
 * Count Intersection
 *
 * You are given a 2D array A of length N*3 consisting of N intervals.
 *
 * where interval from A[i][1] to A[i][2] is defined below
 *
 * 1. if A[i][0] = 1 then both A[i][1] and A[i][2] is included in interval
 * 2. if A[i][0] = 2 then A[i][1] is included and and A[i][2] is excluded in interval
 * 3. if A[i][0] = 3 then A[i][1] is excluded and and A[i][2] is included in interval
 * 4. if A[i][0] = 4 then both A[i][1] and A[i][2] is excluded in interval
 *
 * Your task is to find How many pairs of intervals are so their intersection is not null.
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 1000
 * 1 <= A[i][0] <= 4
 * 1 <= A[i][1] <A[i][2] <= 109
 */
function soln(A) {
  const X = [];
  for (let i = 0; i < A.length; i++) {
    let l = A[i][1];
    let r = A[i][2];

    if ([3, 4].includes(A[i][0])) {
      l += 0.5;
    }
    if ([2, 4].includes(A[i][0])) {
      r -= 0.5;
    }

    X.push([l, r]);
  }

  let count = 0;
  for (let i = 0; i < X.length; i++) {
    for (let j = i + 1; j < X.length; j++) {
      if (!(X[j][1] < X[i][0] || X[i][1] < X[j][0])) {
        count++;
      }
    }
  }

  return count;
}
