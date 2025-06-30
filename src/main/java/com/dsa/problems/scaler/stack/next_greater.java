package com.dsa.problems.scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class next_greater {
  /**
 * Q2. Next Greater

Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:
G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.
 */
  private static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt= new ArrayList<>();

    for(int i = 0; i < A.size(); i++) {
      rslt.add(0);
    }

    for(int i = A.size() - 1; i >= 0; i--) {
      if(st.isEmpty()) {
        rslt.set(i, -1);
      } else if(st.peek() > A.get(i)) {
        rslt.set(i, st.peek());
      } else {
        while(st.size() > 0 && st.peek() <= A.get(i)) {
          st.pop();
        }
        if(st.isEmpty()) {
          rslt.set(i, -1);
        } else {
          rslt.set(i, st.peek());
        }
      }
      st.push(A.get(i));
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(nextGreater(new ArrayList<>(Arrays.asList(1,5,3,7,1))));
  }
}
