package com.dsa.problems.scaler.stack;

import java.util.Stack;

public class sort_stack_using_another_stack {
  /**
 * Q. Sort stack using another stack

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.

Problem Constraints
1 <= |A| <= 5000
0 <= A[i] <= 109
*/
  private static Stack<Integer> sortStackUsingAnotherStack(Stack<Integer> A) {
    Stack<Integer> B = new Stack<>();

    while(A.size() > 0) {
      int x = A.pop();
      while(B.size() > 0 && B.peek() > x) {
        A.push(B.pop());
      }
      B.push(x);
    }

    return B;
  }

  public static void main(String[] args) {
    Stack<Integer> A = new Stack<>();
    A.push(5);
    A.push(3);
    A.push(4);
    A.push(1);
    A.push(2);
    System.out.println(sortStackUsingAnotherStack(A));
  }
}
