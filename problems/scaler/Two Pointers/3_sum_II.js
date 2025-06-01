/**
 *
 */
function soln(A) {
  A.sort((a, b) => a - b);

  const n = A.length;
  let rslt = [];
  for (let i = 0; i < n - 2; i++) {
    // Skip duplicate values for the first element
    if (i > 0 && A[i] === A[i - 1]) {
      continue;
    }

    let j = i + 1;
    let k = n - 1;
    while (j < k) {
      const sum = A[i] + A[j] + A[k];
      if (sum === 0) {
        if (A[j] == A[k]) {
          rslt.push([A[i], A[j], A[k]]);
          break;
        }
        let countJ = 0;
        let countK = 0;
        for (let x = j; x < k; x++) {
          if (A[x] == A[j]) {
            countJ++;
          } else {
            break;
          }
        }
        for (let x = k; x > j; x--) {
          if (A[x] == A[k]) {
            countK++;
          } else {
            break;
          }
        }
        rslt.push([A[i], A[j], A[k]]);
        j += countJ;
        k -= countK;
      } else if (sum > 0) {
        k--;
      } else {
        j++;
      }
    }
  }

  return rslt;
}

// console.log(soln([-1, 0, 1, 2, -1, -4]));
console.log(soln([2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10]));
