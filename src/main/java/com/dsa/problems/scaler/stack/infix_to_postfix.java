package com.dsa.problems.scaler.stack;

import java.util.Stack;

public class infix_to_postfix {
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
private static String infixToPostFix(String A) {
  Stack<Character> st = new Stack<>();
  String rslt = "";
  for(int i = 0; i < A.length(); i++) {
    Character a = A.charAt(i);
    if(a != '(' && a != '+' && a != '-' && a != '*' && a != '/' && a != '^' && a != ')') {
      rslt += a;
    } else {
      if (!st.isEmpty() && (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/' || st.peek() == '^') && (a == '+' || a == '-')) {
        while(!(st.isEmpty() || st.peek() == '(')) {
          rslt += st.pop();
        }
        st.push(a);
      } else if (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/' || st.peek() == '^') && (a == '*' || a == '/')) {
        while(!(st.isEmpty() || st.peek() == '+' || st.peek() == '-' || st.peek() == '(')) {
          rslt += st.pop();
        }
        st.push(a);
      } else if (!st.isEmpty() && (st.peek() == '^') && (a == '^')) {
        while(!(st.isEmpty() || st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/' || st.peek() == '(')) {
          rslt += st.pop();
        }
        st.push(a);
      } else if(a == ')') {
        while(st.peek() != '(') {
          rslt += st.pop();
        }
        st.pop();
      } else {
        st.push(a);
      }
    }
  }

  while(st.size() > 0) {
    rslt += st.pop();
  }

  return rslt;
}

public static void main(String[] args) {
  System.out.println(infixToPostFix("x^y/(a*z)+b"));
  System.out.println(infixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
}
}
