/**
 * Implement Addition operation using bitwise operators
 */
function soln(A, B) {
  while (B !== 0) {
    // Calculate carry
    let carry = A & B;

    // Calculate sum without carry
    A = A ^ B;

    // Shift carry to left by 1 position
    B = carry << 1;
  }

  return A;
}

console.log(soln(1, 2)); // 3
console.log(soln(10, 15)); // 25
console.log(soln(23, 45)); // 68
