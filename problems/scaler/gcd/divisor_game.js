/**
 * Divisor game
 *
 * Scooby has 3 three integers A, B, and C.
 *
 * Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.
 */

function soln(A, B, C) {
  function gcd(n, m) {
    if (m === 0) {
      return n;
    }
    return gcd(m, n % m);
  }

  const gcdVal = B > C ? gcd(B, C) : gcd(C, B);
  const lcm = parseInt(BigInt(B * C) / BigInt(gcdVal));
  return Math.floor(A / lcm);
}

console.log(soln(12, 2, 3));
