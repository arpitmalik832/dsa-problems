/**
 * Q. Perform division between two integers without using division operator.
 */
function soln(A, B) {
  // Handle edge cases
  if (B === 0) return Infinity;
  if (A === 0) return 0;
  if (B === A) return 1;

  const INTMAX = ~(1 << 31);

  // Handle negative numbers
  let isNegative = false;
  if (A < 0) {
    A = -A;
    isNegative = !isNegative;
  }
  if (B < 0) {
    B = -B;
    isNegative = !isNegative;
  }

  // Handle overflow if A is greater than 2^31 - 1
  let isDecremented = false;
  if (A > INTMAX) {
    A = INTMAX;
    isDecremented = true;
  }

  let quotient = 0;
  let temp = 0;

  // Start from bit 30 to avoid sign bit
  for (let i = 30; i >= 0; i--) {
    // Check if shifting B by i positions would exceed A
    if (B > A >> i) continue;

    // Now it's safe to shift B
    let shiftedB = B << i;
    if (temp + shiftedB <= A) {
      temp += shiftedB;
      quotient |= 1 << i;
    }
  }

  // Handle special case where B is 1, 2, or 4
  if (isDecremented && [1, 2, 4].includes(B)) {
    quotient += 1;
  }

  // Handle overflow if quotient is greater than 2^31 - 1
  if (!isNegative && quotient > INTMAX) {
    return INTMAX;
  }

  // Return with correct sign
  return isNegative ? -quotient : quotient;
}

// Test cases
console.log(soln(10, 3)); // Expected: 3
console.log(soln(7, -3)); // Expected: -2
console.log(soln(-10, 3)); // Expected: -3
console.log(soln(0, 5)); // Expected: 0
console.log(soln(100, 7)); // Expected: 14
console.log(soln(2147483647, 2)); // Expected: 1073741823
console.log(soln(-2147483648, -1)); // 2147483647
console.log(soln(-2147483648, 2)); // -1073741824
console.log(soln(-2147483648, 3)); // -1073741824
console.log(soln(2147483647, 3));
