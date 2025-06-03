/**
 * Q. Implement Power Function
 *
 * Implement pow(A, B) % C.
 * In other words, given A, B and C, Find (A^B % C).
 * Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 */
function solnRec(A, B, C) {
  if (B === 0) {
    return 1;
  }

  const temp = BigInt(soln(A, B / 2, C));

  if (B & (1 === 0)) {
    return parseInt((temp * temp) % BigInt(C));
  } else {
    return (parseInt((temp * temp) % BigInt(C)) * (A % C)) % C;
  }
}

function soln(A, B, C) {
  if (A < 0) {
    A = ((A % C) + C) % C;
  }

  return solnRec(A, B, C);
}

console.log(soln(2, 3, 3));
