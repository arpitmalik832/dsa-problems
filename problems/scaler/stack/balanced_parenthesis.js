/**
 * Q. Balanced Paranthesis

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.
 */
function soln(A) {
  const stack = [];
  for (const a of A) {
    if (["(", "{", "["].includes(a)) {
      stack.push(a);
    } else {
      if (stack.length === 0) {
        return 0;
      } else if (
        (stack[stack.length - 1] === "(" && a === ")") ||
        (stack[stack.length - 1] === "{" && a === "}") ||
        (stack[stack.length - 1] === "[" && a === "]")
      ) {
        stack.pop();
      } else {
        return 0;
      }
    }
  }

  if (stack.length === 0) {
    return 1;
  } else {
    return 0;
  }
}
