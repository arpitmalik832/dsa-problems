/**
 * Reverse Bits
 * Given an integer A.
 * Return the number in binary without leading zeros.
 * For example, if A = 5, the binary representation is "101".
 * So the function should return 5.
 */
function toUnsigned32(n) {
  return n >>> 0;
}

function checkBit(n, i) {
  return (n & (1 << i)) !== 0;
}

function soln(n) {
  let rslt = 0;
  n = toUnsigned32(n);
  for (let i = 0; i < 32; i++) {
    rslt = rslt << 1;
    rslt |= checkBit(n, i);
  }
  rslt = toUnsigned32(rslt);
  return rslt;
}

console.log(soln(5)); // 5
