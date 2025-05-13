const soln = (A, B, C) => {
  const aSize = A.length;
  const bSize = B.length;
  let i = 0;
  let j = bSize - 1;
  let rsltSum = Infinity;
  let rslt = [1000000001, 1000000001];
  while (i < aSize && j >= 0) {
    if (Math.abs(C - (A[i] + B[j])) < Math.abs(C - rsltSum)) {
      rsltSum = A[i] + B[j];
      rslt = [A[i], B[j]];
    } else if (Math.abs(C - (A[i] + B[j])) == Math.abs(C - rsltSum)) {
      if (A[i] < rslt[0] || (A[i] === rslt[0] && B[j] < rslt[1])) {
        rslt = [A[i], B[j]];
      }
    }
    if (A[i] + B[j] < C) {
      i++;
    } else {
      j--;
    }
  }

  return rslt;
};

console.log(soln([1, 2, 3, 4, 5], [2, 4, 6, 8], 9)); // Output: [1, 8]
