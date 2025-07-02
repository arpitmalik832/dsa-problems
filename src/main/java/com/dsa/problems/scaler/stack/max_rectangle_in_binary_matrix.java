package com.dsa.problems.scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class max_rectangle_in_binary_matrix {
  private static ArrayList<Integer> nextSmallerLeft(ArrayList<Integer> A) {
    final int n = A.size();
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();

    for(int i = 0; i < n; i++) rslt.add(0);

    for(int i = 0; i < n; i++) {
      while(st.size() > 0 && A.get(st.peek()) >= A.get(i)) {
        st.pop();
      }
      if(st.size() == 0) {
        rslt.set(i, -1);
      } else {
        rslt.set(i, st.peek());
      }
      st.push(i);
    }

    return rslt;
  }

  private static ArrayList<Integer> nextSmallerRight(ArrayList<Integer> A) {
    final int n = A.size();
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();

    for(int i = 0; i < n; i++) rslt.add(0);
    
    for(int i = n - 1; i >= 0; i--) {
      while(st.size() > 0 && A.get(st.peek()) >= A.get(i)) {
        st.pop();
      }
      if(st.size() == 0) {
        rslt.set(i, -1);
      } else {
        rslt.set(i, st.peek());
      }
      st.push(i);
    }

    return rslt;
  }

  /**
 * Q. Max Rectangle in Binary Matrix

Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
 */
  private static int maxRectangleInBinaryMatrix(ArrayList<ArrayList<Integer>> A) {
    final int n = A.size();
    final int m = A.get(0).size();

    for(int j = 0; j < m; j++) {
      for(int i = 1; i < n; i++) {
        if(A.get(i).get(j) != 0) {
          A.get(i).set(j, A.get(i - 1).get(j) + 1);
        }
      }
    }

    ArrayList<ArrayList<Integer>> nSL = new ArrayList<>();
    ArrayList<ArrayList<Integer>> nSR = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      nSL.add(nextSmallerLeft(A.get(i)));
      nSR.add(nextSmallerRight(A.get(i)));
    }

    int ans = 0;

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        ans = Math.max(ans, (nSR.get(i).get(j) - nSL.get(i).get(j)) * A.get(i).get(j));
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();

    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0)));
    A.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1)));
    A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1)));

    System.out.println(maxRectangleInBinaryMatrix(A));
  }
}
