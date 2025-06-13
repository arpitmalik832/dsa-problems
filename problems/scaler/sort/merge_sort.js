/**
 * Q. Merge Sort
 *
 * Given an integer array A, sort the array using Merge Sort.
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 * 1 <= A[i] <= 109} arr
 */
function merge(arr, s, m, e) {
  let i = s,
    j = m + 1,
    k = 0;
  let temp = new Array(e - s + 1).fill(0);
  while (i <= m && j <= e) {
    if (arr[i] <= arr[j]) {
      temp[k] = arr[i];
      i++;
      k++;
    } else {
      temp[k] = arr[j];
      j++;
      k++;
    }
  }
  while (i <= m) {
    temp[k] = arr[i];
    i++;
    k++;
  }
  while (j <= e) {
    temp[k] = arr[j];
    j++;
    k++;
  }

  let x = s;
  for (let i = 0; i < e - s + 1; i++) {
    arr[x] = temp[i];
    x++;
  }
}

function mergeSort(arr, s, e) {
  if (s === e) {
    return;
  }

  const mid = parseInt((s + e) / 2);
  mergeSort(arr, s, mid);
  mergeSort(arr, mid + 1, e);
  merge(arr, s, mid, e);
}

function soln(A) {
  mergeSort(A, 0, A.length - 1);
  return A;
}

console.log(soln([10, 12, 21, 4, 5, 7]));
