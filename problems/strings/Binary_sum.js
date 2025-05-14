/**
 * Given two binary strings A and B, return their sum (also a binary string).
 *
 * Example:
 * Input: A = "100", B = "11"
 * Output: "111"
 */

function soln(A, B) {
  let aArr = Array.from(A);
  let bArr = Array.from(B);
  let k = 0;
  while (k < aArr.length && aArr[k] === "0") {
    k++;
  }
  if (k > 0) {
    aArr.splice(0, k);
  }
  k = 0;
  while (k < bArr.length && bArr[k] === "0") {
    k++;
  }
  if (k > 0) {
    bArr.splice(0, k);
  }

  const n = aArr.length;
  const m = bArr.length;

  let i = n - 1;
  let j = m - 1;
  let carry = 0;
  let finalSum = "";
  while (i >= 0 || (j >= 0) | (carry > 0)) {
    let sum = carry;
    if (i >= 0) {
      sum += Number(aArr[i]);
      i--;
    }
    if (j >= 0) {
      sum += Number(bArr[j]);
      j--;
    }

    if (sum > 1) {
      carry = 1;
      sum = sum % 2;
    } else {
      carry = 0;
    }

    finalSum = sum.toString() + finalSum;
  }

  return finalSum;
}

console.log(soln("100", "11")); // "111"
console.log(soln("1101", "111")); // "10100"
console.log(soln("01001001", "0110101")); // "10111010"
