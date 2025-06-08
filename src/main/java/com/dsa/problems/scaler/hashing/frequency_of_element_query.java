package com.dsa.problems.scaler.hashing;

import java.util.*;

public class frequency_of_element_query {
  /**
   * Q. Frequency of element query
   *
   * SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating the least, allowing them to provide targeted support and encouragement.
   *
   * Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner, and an array B containing the learners for whom you want to check participation frequency, your task is to find the frequency of each learner from array B in the array A and return a list containing all these frequencies
   */
  private static ArrayList<Integer> getFrequencyForQuery(ArrayList<Integer> A, ArrayList<Integer> Q) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int a : A) {
      if(hm.containsKey(a)) {
        hm.put(a, hm.get(a) + 1);
      } else {
        hm.put(a, 1);
      }
    }

    ArrayList<Integer> rslt = new ArrayList<>();
    for(int q : Q) {
      if(hm.containsKey(q)) {
        rslt.add(hm.get(q));
      } else {
        rslt.add(-1);
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(getFrequencyForQuery(new ArrayList<>(Arrays.asList(1, 2, 1, 1)), new ArrayList<>(Arrays.asList(1,2))));
  }
}
