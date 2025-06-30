package com.dsa.problems.scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class nearest_smaller_number {
  /**
 * Q2. Nearest Smaller Element

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]
Elements for which no smaller element exist, consider the next smaller element as -1.
 */
  private static ArrayList<Integer> nearestSmallerNumber(ArrayList<Integer> A) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    for(int a : A) {
      if(st.size() == 0) {
        rslt.add(-1);
      } else if(st.peek() < a) {
        rslt.add(st.peek());
      } else {
        while(st.size() > 0 && st.peek() >= a) {
          st.pop();
        }
        if(st.size() == 0) {
          rslt.add(-1);
        } else {
          rslt.add(st.peek());
        }
      }
      st.add(a);
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(nearestSmallerNumber(new ArrayList<>(Arrays.asList(1,7,3,5,1))));
  }
}
