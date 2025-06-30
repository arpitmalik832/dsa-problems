/**
 * Q. Evaluate Expression

An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
 */
function soln(A) {
  let stack = [];
  for (const a of A) {
    if (!isNaN(parseInt(a))) {
      stack.push(parseInt(a));
    } else {
      let val2 = stack.pop();
      let val1 = stack.pop();
      if (a == "+") {
        stack.push(val1 + val2);
      } else if (a == "-") {
        stack.push(val1 - val2);
      } else if (a == "*") {
        stack.push(val1 * val2);
      } else if (a == "/") {
        stack.push(parseInt(val1 / val2));
      }
    }
  }

  return stack[0];
}
