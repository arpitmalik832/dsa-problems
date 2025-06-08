package com.dsa.problems.scaler.hashing;

import java.util.*;

public class common_elements {
  /**
   * Q. Common Elements
   *
   * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
   *
   * NOTE:
   *
   * Each element in the result should appear as many times as it appears in both arrays.
   * The result can be in any order.
   */ 
  private static ArrayList<Integer> commonElements(ArrayList<Integer> A, ArrayList<Integer> B) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i = 0; i < A.size(); i++) {
      if(hm.containsKey(A.get(i))) {
        hm.put(A.get(i), hm.get(A.get(i)) + 1);
      } else {
        hm.put(A.get(i), 1);
      }
    }

    ArrayList<Integer> rslt = new ArrayList<>();
    for(int i = 0; i < B.size(); i++) {
      if(hm.containsKey(B.get(i))) {
        if(hm.get(B.get(i)) > 1) {
          hm.put(B.get(i), hm.get(B.get(i)) - 1);
        } else {
          hm.remove(B.get(i));
        }
        rslt.add(B.get(i));
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(commonElements(new ArrayList<>(Arrays.asList(1,2,2,3,4,5)), new ArrayList<>(Arrays.asList(2,3,4, 2))));
  }
}
