package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class occurrence_check_III {
  public static boolean checkBit(int n, int i) {
    return (n & ( 1 << i)) != 0;
  }

  public static int getOccurrenceCheckIII(ArrayList<Integer> A) {
    int ans = 0;
    
    for(int i = 0; i < 32; i++) {
      int count = 0;
      for(int j = 0; j < A.size(); j++) {
        if(checkBit(A.get(j), i)) {
          count++;
        }
      }
      if(count % 3 != 0) {
        ans |= 1 << i;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(getOccurrenceCheckIII(new ArrayList<>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1))));
  }
}
