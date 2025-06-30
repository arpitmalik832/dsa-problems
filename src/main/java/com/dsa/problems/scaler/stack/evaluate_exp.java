package com.dsa.problems.scaler.stack;

import java.util.Stack;

public class evaluate_exp {
  /**
 * Q. Evaluate Expression

An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
 */
  private static int evaluateExp(String A) {
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < A.length(); i++) {
      Character a = A.charAt(i);
      int num = (int)(a - '0');
      if(num >= 0 && num <= 9) {
        st.push(num);
      } else {
        int var2 = st.pop();
        int var1 = st.pop();
        if(a == '+') {
          st.push(var1 + var2);
        } else if(a == '-') {
          st.push(var1 - var2);
        } else if(a == '*') {
          st.push(var1 * var2);
        } else if(a == '/') {
          st.push(var1 / var2);
        }
      }
    }

    return st.peek();
  }

  public static void main(String[] args) {
    System.out.println(evaluateExp("21+3*"));
  }
}
