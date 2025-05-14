function soln(A) {
  let num = 1;
  let sq = A * A;
  let left = 0;
  let top = 0;
  let right = A - 1;
  let bottom = A - 1;
  const rslt = new Array(A);

  for (let i = 0; i < A; i++) {
    rslt[i] = new Array(A).fill(0);
  }

  while (left <= right && top <= bottom && num <= sq) {
    for (let j = left; j <= right; j++) {
      rslt[top][j] = num;
      num++;
    }
    top++;

    for (let i = top; i <= bottom; i++) {
      rslt[i][right] = num;
      num++;
    }
    right--;

    if (left <= right) {
      for (let j = right; j >= left; j--) {
        rslt[bottom][j] = num;
        num++;
      }
      bottom--;
    }

    if (top <= bottom) {
      for (let i = bottom; i >= top; i--) {
        rslt[i][left] = num;
        num++;
      }
      left++;
    }
  }

  return rslt;
}

console.log(soln(3));
