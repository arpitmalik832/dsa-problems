package com.dsa.problems.scaler.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Three_sum_II {
  public static ArrayList<ArrayList<Integer>> soln(ArrayList<Integer> A) {
    Collections.sort(A);
    int n = A.size();
    ArrayList<ArrayList<Integer>> rslt = new ArrayList<>();

    for(int i = 0; i < n - 2; i++) {
      if(i > 0 && A.get(i).equals(A.get(i - 1))) {
        continue;
      }
      
      int j = i + 1;
      int k = n - 1;
      while(j < k) {
        int sum = A.get(i) + A.get(j) + A.get(k);
        if(sum == 0) {
          if(A.get(j).equals(A.get(k))) {
            rslt.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k))));
            break;
          }
          int countJ = 0, countK = 0;
          int x = j;
          while(A.get(x).equals(A.get(j))) {
            countJ++;
            x++;
          }
          x = k;
          while(A.get(x).equals(A.get(k))) {
            countK++;
            x--;
          }
          rslt.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k))));
          j += countJ;
          k -= countK;
        } else if(sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4))));
  }
}
