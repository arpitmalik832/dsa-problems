package com.dsa.problems.scaler.stack;

import java.util.Stack;

public class redundant_braces {
  private static int redundantBraces(String A) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < A.length(); i++) {
      char a = A.charAt(i);
      if (a == '(' || a == '+' || a == '-' || a == '*' || a == '/') {
        st.push(a);
      } else if (a == ')') {
        if (!st.isEmpty() && (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/')) {
          st.pop();
          st.pop();
        } else {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public static void main(String[] args) {
    System.out.println(redundantBraces("((a+b))"));
    System.out.println(redundantBraces("((a+b)*c)"));
  }
}
