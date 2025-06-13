/**
 * Q3. Quick Sort
 *
 * Given an integer array A, sort the array using Quick Sort.
 */

function soln(A) {
  function partition(arr, s, e) {
    let pivot = s;
    const mid = parseInt((s + e) / 2);
    if (
      (arr[s] <= arr[mid] && arr[s] >= arr[e]) ||
      (arr[s] <= arr[e] && arr[s] >= arr[mid])
    ) {
      pivot = s;
    } else if (
      (arr[mid] <= arr[s] && arr[mid] >= arr[e]) ||
      (arr[mid] <= arr[e] && arr[mid] >= arr[s])
    ) {
      pivot = mid;
    } else {
      pivot = e;
    }
    [arr[s], arr[pivot]] = [arr[pivot], arr[s]];
    pivot = s;
    let l = pivot + 1;
    let r = e;
    while (l <= r) {
      if (arr[l] < arr[pivot]) {
        l++;
      } else if (arr[r] > arr[pivot]) {
        r--;
      } else {
        [arr[l], arr[r]] = [arr[r], arr[l]];
        l++;
        r--;
      }
    }
    [arr[pivot], arr[r]] = [arr[r], arr[pivot]];

    return r;
  }

  function quickSort(arr, s, e) {
    if (s >= e) {
      return;
    }

    const pivot = partition(arr, s, e);
    quickSort(arr, s, pivot - 1);
    quickSort(arr, pivot + 1, e);
  }

  quickSort(A, 0, A.length - 1);
  return A;
}

console.log(
  soln([
    -58, 32, 10, 42, 82, -12, 88, 17, 35, 8, -72, -32, -48, 76, -48, -8, -69,
    -1, 54, 52, 37, -1, 95, 0, -32, 38, 62, 68, 68, -71, 62, -58, -25, 55, -11,
    2,
  ])
);
