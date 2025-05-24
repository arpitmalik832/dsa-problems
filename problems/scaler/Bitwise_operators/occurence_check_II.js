/**
 * Q. Given an integer array where every number is occurring twice except two. Find the numbers which are occurring once.
 */
function checkBit(n, i) {
  return (n & (1 << i)) !== 0;
}
function soln(A) {
  // first computing xor of the complete array, it will give us xor of both of those numbers.
  let xor = A[0];
  for (let i = 1; i < A.length; i++) {
    xor ^= A[i];
  }
  // finding index, where the bit of xor is set, i.e., where the bits of the numbers is different.
  let index = -1;
  for (let i = 0; i < 32; i++) {
    if (checkBit(xor, i)) {
      index = i;
      break;
    }
  }

  // basis on the bit we are diving the array into two parts and computing xor over each part that will give us those numbers.
  let num1 = 0;
  let num2 = 0;
  for (let i = 0; i < A.length; i++) {
    if (checkBit(A[i], index)) {
      num1 ^= A[i];
    } else {
      num2 ^= A[i];
    }
  }

  if (num1 < num2) {
    return [num1, num2];
  } else {
    return [num2, num1];
  }
}

console.log(soln([1, 2, 3, 4, 5, 1, 2, 3]));
console.log(soln([1, 2, 3, 7, 5, 1, 2, 3]));
