function getIndices(A, B, i, arr) {
  if (i === A.length) {
    return;
  }

  if (A[i] === B) {
    arr.push(i);
  }

  getIndices(A, B, i + 1, arr);
}

function soln(A, B) {
  let rslt = [];
  getIndices(A, B, 0, rslt);
  return rslt;
}

console.log(soln([1, 2, 3, 4, 5], 3));
