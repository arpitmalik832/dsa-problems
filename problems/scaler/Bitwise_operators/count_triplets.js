/**
 * Count Triplets That Can Form Two Arrays of Equal XOR
 *
 * Given an array of integers arr.
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 *
 * Let's define a and b as follows:
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * Note that ^ denotes the bitwise-xor operation.
 * Return the number of triplets (i, j and k) Where a == b.
 */
function soln(arr) {
  for (let i = 1; i < arr.length; i++) {
    arr[i] ^= arr[i - 1];
  }

  let count = 0;
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      for (let k = j; k < arr.length; k++) {
        let xorij = 0;
        if (i === 0) {
          xorij = arr[j - 1];
        } else {
          xorij = arr[j - 1] ^ arr[i - 1];
        }
        let xorjk = arr[k] ^ arr[j - 1];
        if ((xorij ^ xorjk) === 0) {
          count++;
        }
      }
    }
  }

  return count;
}

function soln2(arr) {
  for (let i = 1; i < arr.length; i++) {
    arr[i] ^= arr[i - 1];
  }

  let count = 0;
  for (let i = 0; i < arr.length - 1; i++) {
    for (let k = i + 1; k < arr.length; k++) {
      let xor = 0;
      if (i === 0) {
        xor = arr[k];
      } else {
        xor = arr[k] ^ arr[i - 1];
      }
      if (xor === 0) {
        count += k - i;
      }
    }
  }

  return count;
}

console.log(soln([2, 3, 1, 6, 7]));
console.log(soln2([2, 3, 1, 6, 7]));
