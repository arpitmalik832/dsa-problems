package com.dsa.problems.scaler.binary_search;

import java.util.*;

public class binary_Search_in_matrix {
  private static int binarySearch(ArrayList<Integer> A, int B) {
    final int n = A.size();
    int i = 0, j = n - 1;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m) == B) {
        return 1;
      } else if(A.get(m) < B) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    return 0;
  }

  private static int binarySearchInMatrix(ArrayList<ArrayList<Integer>> A, int B) {
    final int n = A.size();

    if(n == 1) {
      return binarySearch(A.get(0), B);
    } else if(n == 2) {
      if(A.get(1).get(0) == B) {
        return 1;
      } else if(A.get(1).get(0) < B) {
        return binarySearch(A.get(1), B);
      } else {
        return binarySearch(A.get(0), B);
      }
    }

    int i = 1, j = n - 2;
    int rslt = -1;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m).get(0) == B) {
        return 1;
      } else if(A.get(m - 1).get(0) == B) {
        return 1;
      } else if(A.get(m).get(0) < B && A.get(m + 1).get(0) > B) {
        return binarySearch(A.get(m), B);
      } else if(A.get(m).get(0) > B && A.get(m - 1).get(0) < B) {
        return binarySearch(A.get(m - 1), B);
      } else if(A.get(m).get(0) < B) {
        rslt = m + 1;
      }

      if (A.get(m).get(0) == B) {
        return 1;
      } else if (A.get(m).get(0) > B) {
        j = m - 1;
      } else {
        i = m + 1;
      }
    }

    if (rslt != -1) {
      return binarySearch(A.get(rslt), B);
    }
    return 0;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    A.add(new ArrayList<>(Arrays.asList(3,3,11,12,14)));
    A.add(new ArrayList<>(Arrays.asList(16, 17, 30, 34, 35)));
    A.add(new ArrayList<>(Arrays.asList(45,48,49,50,52)));
    A.add(new ArrayList<>(Arrays.asList(56,59,63,63,65)));
    A.add(new ArrayList<>(Arrays.asList(67,71,72,73,79)));
    A.add(new ArrayList<>(Arrays.asList(80,84,85,85,88)));
    A.add(new ArrayList<>(Arrays.asList(88,91,92,93,94)));
    System.out.println(binarySearchInMatrix(A, 94));
  }
}
