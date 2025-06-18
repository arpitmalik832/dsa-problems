package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class local_maxima {
  private static int localMaxima(ArrayList<Integer> A) {
    final int n = A.size();
    if(n == 1) {
      return A.get(0);
    }
    if(A.get(0) > A.get(1)) return A.get(0);
    if(A.get(n - 1) > A.get(n - 2)) return A.get(n - 1);

    int i = 1, j = n - 2;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m) >= A.get(m - 1) && A.get(m) >= A.get(m + 1)) {
        return A.get(m);
      } else if( A.get(m) > A.get(m - 1) && A.get(m) < A.get(m + 1)) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(localMaxima(new ArrayList<>(Arrays.asList(5, 17, 100, 11))));    
  }
}
