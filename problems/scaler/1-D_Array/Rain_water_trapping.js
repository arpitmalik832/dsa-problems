/**
 * Rain Water Trapping
 */

function getPfm(A) {
  const n = A.length;
  const pfm = new Array(n).fill(0);

  pfm[0] = A[0];

  for (let i = 1; i < n; i++) {
    pfm[i] = Math.max(pfm[i - 1], A[i]);
  }

  return pfm;
}

function getSfm(A) {
  const n = A.length;
  const sfm = new Array(n).fill(0);

  sfm[n - 1] = A[n - 1];

  for (let i = n - 2; i >= 0; i--) {
    sfm[i] = Math.max(sfm[i + 1], A[i]);
  }

  return sfm;
}

function soln(A) {
  const n = A.length;
  const pfm = getPfm(A);
  const sfm = getSfm(A);

  let water = 0;

  for (let i = 0; i < n; i++) {
    water += Math.min(pfm[i], sfm[i]) - A[i];
  }

  return water;
}

console.log(soln([2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1])); // 8
