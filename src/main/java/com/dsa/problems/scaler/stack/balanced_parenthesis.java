package com.dsa.problems.scaler.stack;

import java.util.Stack;

public class balanced_parenthesis {
  /**
 * Q. Balanced Parenthesis

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
private static int balancedParenthesis(String A) {
  Stack<Character> st = new Stack<>();
  for(int i = 0; i < A.length(); i++) {
    char a = A.charAt(i);
    if(st.isEmpty() && (a == ')' || a == '}' || a == ']')) {
      return 0;
    } else if(a == '(' || a == '{' || a == '[') {
      st.push(a);
    } else if(st.peek() == '(' && a == ')' || st.peek() == '{' && a == '}' || st.peek() == '[' && a == ']') {
      st.pop();
    } else {
      return 0;
    }
  }

  if(st.isEmpty()) {
    return 1;
  } else {
    return 0;
  }
}

public static void main(String[] args) {
  System.out.println(balancedParenthesis("({)}"));
  System.out.println(balancedParenthesis("({})"));
}
}
