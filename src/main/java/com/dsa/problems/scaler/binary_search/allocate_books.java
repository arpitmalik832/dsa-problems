package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class allocate_books {
  /**
   * Q. Allocate Books
   *
   * Given an array of integers A of size N and an integer B.
   *
   * The College library has N books. The ith book has A[i] number of pages.
   *
   * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
   *
   * A book will be allocated to exactly one student.
   * Each student has to be allocated at least one book.
   * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
   * Calculate and return that minimum possible number.
   *
   * NOTE: Return -1 if a valid assignment is not possible.
   */
  private static int allocateBooks(ArrayList<Integer> A, int B) {
    final int n = A.size();
    if(B > n) {
      return -1;
    }
    int lo = 0, hi = 0;
    for(int a : A) {
      lo = Math.max(lo, a);
      hi = hi + a;
    }

    int rslt = 0;
    while(lo <= hi) {
      final int mid = lo + (hi - lo) / 2;
      if(isPossible(A, B, mid)) {
        rslt = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return rslt;
  }

  private static boolean isPossible(ArrayList<Integer> A, int B, int pages) {
    int count = 1;
    int curr = A.get(0);
    for(int i = 1; i < A.size(); i++) {
      curr += A.get(i);
      if(curr > pages) {
        count++;
        curr = A.get(i);
      }
      if(count > B) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(allocateBooks(new ArrayList<>(Arrays.asList(32,324,34,332,43,42,234)), 4));
  }
}
