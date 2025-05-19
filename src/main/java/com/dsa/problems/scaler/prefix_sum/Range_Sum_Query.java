package com.dsa.problems.scaler.prefix_sum;

import java.util.ArrayList;

public class Range_Sum_Query {
  public ArrayList<Long> prefixSum(ArrayList<Integer> A) {
    ArrayList<Long> prefixSum = new ArrayList<>();

    int n = A.size();
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        prefixSum.add((long) A.get(i));
      } else {
        prefixSum.add(prefixSum.get(i - 1) + A.get(i));
      }
    }

    return prefixSum;
  }

  public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
    int m = B.size();
    ArrayList<Long> prefixSum = prefixSum(A);
    ArrayList<Long> rslt = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int start = B.get(i).get(0);
      int end = B.get(i).get(1);
      if (start == 0) {
        rslt.add(prefixSum.get(end));
      } else {
        rslt.add(prefixSum.get(end) - prefixSum.get(start - 1));
      }
    }

    return rslt;
  }

}
