/**
 * Q. Sort stack using another stack

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.

Problem Constraints
1 <= |A| <= 5000
0 <= A[i] <= 109
*/
function soln(A) {
  let B = [];
  while (A.length) {
    let x = A.pop();
    while (B.length && B[B.length - 1] > x) {
      A.push(B.pop());
    }
    B.push(x);
  }

  return B;
}
