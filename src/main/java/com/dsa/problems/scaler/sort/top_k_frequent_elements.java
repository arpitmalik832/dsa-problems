package com.dsa.problems.scaler.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class top_k_frequent_elements {
  /**
   * Q. Top K Frequent Elements
   *
   * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
   *
   * Example 1:
   *
   * Input: nums = [1,1,1,2,2,3], k = 2
   * Output: [1,2]
   */
  private static ArrayList<Integer> topKFrequentElements(ArrayList<Integer> A, int B) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int a : A) {
      if(hm.containsKey(a)) {
        hm.put(a,hm.get(a) + 1);
      } else {
        hm.put(a, 1);
      }
    }

    ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
    for(int i = 0; i <= A.size(); i++) {
      buckets.add(null);
    }

    hm.forEach((key, value) -> {
      if (buckets.get(value) == null) {
        buckets.set(value, new ArrayList<>());
      }
      buckets.get(value).add(key);
    });

    ArrayList<Integer> result = new ArrayList<>();
    for (int j = buckets.size() - 1; j >= 0 && result.size() < B; j--) {
      if (buckets.get(j) != null) {
        result.addAll(buckets.get(j));
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    System.out.println(topKFrequentElements(new ArrayList<>(Arrays.asList(1,1,1,2,2,3)),2));
  }
}
