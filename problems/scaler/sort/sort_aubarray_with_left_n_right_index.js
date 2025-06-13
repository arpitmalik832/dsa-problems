/**
 * Q. Sort subarray with left and right index
 *
 * You are given an array A of integers of length N and two indices, B and C.
 *
 * Your task is to sort the subarray [B, C] within the given array. The rest of the array should remain unchanged.
 *
 * Problem Constraints
 * 1 ≤ N ≤ 105
 * 0 ≤ A[i] ≤ 109
 * 0 ≤ B ≤ C ≤ N - 1
 */
function merge(arr, s, m, e) {
  let i = s,
    j = m + 1,
    k = 0;
  let temp = new Array(e - s + 1).fill(0);
  while (i <= m && j <= e) {
    if (arr[i] <= arr[j]) {
      temp[k] = arr[i];
      k++;
      i++;
    } else {
      temp[k] = arr[j];
      k++;
      j++;
    }
  }
  while (i <= m) {
    temp[k] = arr[i];
    k++;
    i++;
  }
  while (j <= e) {
    temp[k] = arr[j];
    k++;
    j++;
  }

  i = s;
  for (let x = 0; x < e - s + 1; x++) {
    arr[i] = temp[x];
    i++;
  }
}

function mergeSort(arr, s, e) {
  if (s == e) {
    return;
  }
  const mid = parseInt((s + e) / 2);
  mergeSort(arr, s, mid);
  mergeSort(arr, mid + 1, e);
  merge(arr, s, mid, e);
}

function soln(A, B, C) {
  mergeSort(A, B, C);
  return A;
}
