package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class subsets_II {
  public static ArrayList<ArrayList<Integer>> soln(ArrayList<Integer> A) {
    Collections.sort(A);
    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();
    HashSet<String> seen = new HashSet<>();
    
    for(int i = 0; i < 1 << A.size(); i++) {
      ArrayList<Integer> subset = new ArrayList<>();
      for(int j = 0; j < A.size(); j++) {
        if((i & (1 << j)) != 0) {
          subset.add(A.get(j));
        }
      }
      final String subsetStr = subset.toString();
      if(!seen.contains(subsetStr)) {
        seen.add(subsetStr);
        rslt.add(subset);
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 2, 2))));
  }
}
