/**
 * Q. Inversion count in an array
 *
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 *
 * Problem Constraints
 * 1 <= length of the array <= 105
 * 1 <= A[i] <= 109
 */
function soln(A) {
  let count = 0;
  let MOD = Math.pow(10, 9) + 7;
  function merge(arr, s, m, e) {
    let i = s;
    let j = m + 1;
    let k = 0;
    let tempArr = new Array(e - s + 1).fill(0);
    while (i <= m && j <= e) {
      if (arr[i] <= arr[j]) {
        tempArr[k] = arr[i];
        k++;
        i++;
      } else {
        tempArr[k] = arr[j];
        k++;
        j++;
        count = ((count % MOD) + ((m - i + 1) % MOD)) % MOD;
      }
    }
    while (i <= m) {
      tempArr[k] = arr[i];
      k++;
      i++;
    }
    while (j <= e) {
      tempArr[k] = arr[j];
      k++;
      j++;
    }

    k = s;
    for (let x = 0; x < e - s + 1; x++) {
      arr[k] = tempArr[x];
      k++;
    }
  }

  function mergeSort(arr, s, e) {
    if (s === e) return;
    const mid = parseInt((s + e) / 2);
    mergeSort(arr, s, mid);
    mergeSort(arr, mid + 1, e);
    merge(arr, s, mid, e);
  }

  mergeSort(A, 0, A.length - 1);
  return count;
}
