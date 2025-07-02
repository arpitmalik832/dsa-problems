package com.dsa.problems.scaler.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class max_min_prob {
  private static ArrayList<Integer> nextSmallerLeft(ArrayList<Integer> A) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    final int n = A.size();

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
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    final int n = A.size();

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

  private static ArrayList<Integer> nextLargerLeft(ArrayList<Integer> A) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    final int n = A.size();

    for(int i = 0; i < n; i++) rslt.add(0);

    for(int i = 0; i < n; i++) {
      while(st.size() > 0 && A.get(st.peek()) <= A.get(i)) {
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

  private static ArrayList<Integer> nextLargerRight(ArrayList<Integer> A) {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> rslt = new ArrayList<>();
    final int n = A.size();

    for(int i = 0; i < n; i++) rslt.add(0);

    for(int i = n - 1; i >= 0; i--) {
      while(st.size() > 0 && A.get(st.peek()) <= A.get(i)) {
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
 * Q. MAX and MIN

Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 */
  private static int maxMinProb(ArrayList<Integer> A) {
    ArrayList<Integer> nSL = nextSmallerLeft(A);
    ArrayList<Integer> nSR = nextSmallerRight(A);
    ArrayList<Integer> nGL = nextLargerLeft(A);
    ArrayList<Integer> nGR = nextLargerRight(A);
    final int MOD = Math.max(10, 9) + 7; 
    final int n = A.size();
    int ans = 0;

    for(int i = 0; i < n; i++) {
      int maxRange = (i - nGL.get(i)) * (nGR.get(i) - i);
      int minRange = (i - nSL.get(i)) * (nSR.get(i) - i);
      ans = ((ans % MOD) + (((((maxRange % MOD) - (minRange % MOD) + MOD) % MOD) * (A.get(i) % MOD)) % MOD)) % MOD;
    }

    return ans;
  }
  public static void main(String[] args) {
    System.out.println(maxMinProb(new ArrayList<>(Arrays.asList(0))));
  }
}
