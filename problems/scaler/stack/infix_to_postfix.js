/**
 * Q. Infix to Postfix

Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:
^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.
 */
function soln(A) {
  let st = [];
  let rslt = "";
  for (const a of A) {
    if (!["+", "-", "*", "/", "^", "(", ")"].includes(a)) {
      rslt += a;
    } else {
      if (
        ["*", "/", "+", "-", "^"].includes(st[st.length - 1]) &&
        ["+", "-"].includes(a)
      ) {
        while (st.length && st[st.length - 1] !== "(") {
          rslt += st.pop();
        }
        st.push(a);
      } else if (
        ["*", "/", "^"].includes(st[st.length - 1]) &&
        ["*", "/"].includes(a)
      ) {
        while (st.length && !["(", "+", "-"].includes(st[st.length - 1])) {
          rslt += st.pop();
        }
        st.push(a);
      } else if (["^"].includes(st[st.length - 1]) && ["^"].includes(a)) {
        while (
          st.length &&
          !["(", "+", "-", "*", "/"].includes(st[st.length - 1])
        ) {
          rslt += st.pop();
        }
        st.push(a);
      } else if (a === ")") {
        while (st[st.length - 1] != "(") {
          rslt += st.pop();
        }
        st.pop();
      } else {
        st.push(a);
      }
    }
  }
  while (st.length) {
    rslt += st.pop();
  }

  return rslt;
}
