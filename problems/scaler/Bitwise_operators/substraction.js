/**
 * Implement Substraction operation using bitwise operators
 */
function soln(A, B) {
  while (B !== 0) {
    // Calculate borrow
    let borrow = ~A & B;

    // Calculate difference without borrow
    A = A ^ B;

    // Shift borrow to left by 1 position
    B = borrow << 1;
  }

  return A;
}

console.log(soln(1, 2)); // -1
console.log(soln(10, 15)); // -5
console.log(soln(23, 45)); // -22
