package com.dsa.problems.scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class largest_rectangle_in_histogram {
  private static ArrayList<Integer> nextSmallerLeft(ArrayList<Integer> A) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    for(int i = 0; i < A.size(); i++) rslt.add(0);

    for(int i = 0; i < A.size(); i++) {
      while(st.size() != 0 && A.get(st.peek()) >= A.get(i)) {
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
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    for(int i = 0; i < A.size(); i++) rslt.add(0);

    for(int i = A.size() - 1; i >= 0; i--) {
      while(st.size() != 0 && A.get(st.peek()) >= A.get(i)) {
        st.pop();
      }
      if(st.size() == 0) {
        rslt.set(i, A.size());
      } else {
        rslt.set(i, st.peek());
      }
      st.push(i);
    }

    return rslt;
  }
 
  /**
 * Q. Largest Rectangle in Histogram

Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000
*/
  private static int largestRectangleInHist(ArrayList<Integer> A) {
    ArrayList<Integer> nSL = nextSmallerLeft(A);
    ArrayList<Integer> nSR = nextSmallerRight(A);

    int ans = 0;
    for(int i = 0; i < A.size(); i++) {
      ans = Math.max(ans, (nSR.get(i) - 1 - nSL.get(i)) * A.get(i));
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(largestRectangleInHist(new ArrayList<>(Arrays.asList(4,3,2,1))));
  }
}
