package com.dsa.problems.scaler.stack;

import java.util.Stack;

public class double_character_trouble {
  /**
 * Q. Double Character Trouble

You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.
 */
  private static String doubleCharacterTrouble(String str) {
    Stack<Character> st = new Stack<>();
    for(int i = 0; i < str.length(); i++) {
      char x = str.charAt(i);
      if(st.size() != 0 && st.peek() == x) {
        st.pop();
      } else {
        st.push(x);
      }
    }
    StringBuilder sb = new StringBuilder();
    while(st.size() > 0) {
      sb.append(st.pop());
    }
    sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(doubleCharacterTrouble("aaacbbcc"));
  }
}
