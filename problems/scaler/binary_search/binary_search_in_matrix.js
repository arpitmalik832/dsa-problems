function binarySearch(A, B) {
  const n = A.length;
  let i = 0,
    j = n - 1;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m] === B) {
      return 1;
    } else if (A[m] > B) {
      j = m - 1;
    } else {
      i = m + 1;
    }
  }
  return 0;
}

function soln(A, B) {
  const n = A.length;
  if (n == 1) {
    return binarySearch(A[0], B);
  } else if (n === 2) {
    if (A[1][0] === B) {
      return 1;
    } else if (A[1][0] > B) {
      return binarySearch(A[0], B);
    } else {
      return binarySearch(A[1], B);
    }
  }

  let i = 1,
    j = n - 2;
  let rslt = -1;
  while (i <= j) {
    const m = parseInt((i + j) / 2);
    if (A[m][0] > B && A[m - 1][0] <= B) {
      rslt = m - 1;
    } else if (A[m + 1][0] > B && A[m][0] <= B) {
      rslt = m;
    } else if (A[m + 1][0] < B) {
      rslt = m + 1;
    }

    if (A[m][0] === B) {
      return 1;
    } else if (A[m][0] > B) {
      j = m - 1;
    } else {
      i = m + 1;
    }
  }

  if (rslt != -1) {
    return binarySearch(A[rslt], B);
  }
  return 0;
}

console.log(
  soln(
    [
      [3, 3, 11, 12, 14],
      [16, 17, 30, 34, 35],
      [45, 48, 49, 50, 52],
      [56, 59, 63, 63, 65],
      [67, 71, 72, 73, 79],
      [80, 84, 85, 85, 88],
      [88, 91, 92, 93, 94],
    ],
    94
  )
);
