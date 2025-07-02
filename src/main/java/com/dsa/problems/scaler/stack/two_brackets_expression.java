package com.dsa.problems.scaler.stack;

import java.util.ArrayList;
import java.util.Stack;

public class two_brackets_expression {
  private static String sortByChar(String str) {
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0; i < 26; i++) {
      arr.add(0);
    }

    int i = 0;
    if(str.charAt(i) == '-' || str.charAt(i) == '+') {
      i++;
    }
    while(i < str.length()) {
      if(i > 0 && str.charAt(i - 1) == '-') {
        arr.set((int)(str.charAt(i) - 'a'), 1);
      } else {
        arr.set((int)(str.charAt(i) - 'a'), 2);
      }
      i += 2;
    }
    StringBuilder sb = new StringBuilder();
    for(i = 0; i < arr.size(); i++) {
      if(arr.get(i) == 1) {
        sb.append('-');
        sb.append((char)(i + (int)'a'));
      } else if(arr.get(i) == 2) {
        sb.append('+');
        sb.append((char)(i + (int)'a'));
      }
    }

    return sb.toString();
  }

  private static String resolveBrackets(String str) {
    Stack<Character> st = new Stack<>();
    final int n = str.length();
    StringBuilder rslt = new StringBuilder();
    for(int i = 0; i < n; i++) {
      if(str.charAt(i) == '(') {
        if(!st.empty() && st.peek() == '-') {
          if(str.charAt(i - 1) == '-') {
            st.push('+');
          } else {
            st.push('-');
          }
        } else if(i > 0) {
          st.push(str.charAt(i - 1));
        } else {
          st.push('+');
        }
      } else if(str.charAt(i) == ')') {
        st.pop();
      } else if(str.charAt(i) == '+') {
        if(rslt.length() != 0 && (rslt.charAt(rslt.length() - 1) == '+' || rslt.charAt(rslt.length() - 1) == '-')) {
          rslt.deleteCharAt(rslt.length() - 1);
        }
        if(st.size() != 0 && st.peek() == '-') {
          rslt.append('-');
        } else {
          if(rslt.length() != 0) {
            rslt.append('+');
          }
        }
      } else if(str.charAt(i) == '-') {
        if(rslt.length() != 0 && (rslt.charAt(rslt.length() - 1) == '+' || rslt.charAt(rslt.length() - 1) == '-')) {
          rslt.deleteCharAt(rslt.length() - 1);
        }
        if(st.size() != 0 && st.peek() == '-') {
          if(rslt.length() != 0) {
            rslt.append('+');
          }
        } else {
          rslt.append('-');
        }
      } else {
        rslt.append(str.charAt(i));
      }
    }

    return rslt.toString();
  }
  /**
 * Q. Check two bracket expressions

Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
 */
  private static int twoBracketsExpression(String A, String B) {

    String rA = sortByChar(resolveBrackets(A));
    String rB = sortByChar(resolveBrackets(B));
  
    System.out.println(rA + ' ' + rB);
    return rA.equals(rB) ? 1 : 0;
  }

  public static void main(String[] args) {
    System.out.println(twoBracketsExpression("-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"));
  }
}
