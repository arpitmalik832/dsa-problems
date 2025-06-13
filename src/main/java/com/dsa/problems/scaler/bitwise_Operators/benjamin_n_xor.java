package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class benjamin_n_xor {
  private static boolean checkBit(int n, int i) {
    return ((n >> i) & 1) == 1;
  }
  /**
   * Benjamin and XOR
   *
   * In the picturesque town of Bitville, nestled amidst rolling hills and shimmering lakes, the residents had a deep fascination with the world of bits and binary operations. The townsfolk were avid mathematicians, always seeking new puzzles to unravel and insights to gain.
   * One sunny morning, the town's esteemed professor of mathematics, Dr. Benjamin, presented a captivating challenge to his students. He introduced them to an array A of N integers, representing a sequence of numbers with each element holding a special significance.
   * Dr. Benjamin explained that the students' task was to analyze the array and determine the count of pairs that satisfied a unique condition. The condition revolved around the XOR operation on the ith bit of the pair's elements. The goal was to count the pairs for which the xor of the ith bit resulted in one. You have to answer for Q queries given in array B, each query B[i] denotes the index for which you need to find the count of pairs with xor of that index equals 1.
   * Can you solve the task given by Dr. Benjamin?
   * Please read the examples given below for better understanding of the problem.
   * HINT : Look at the binary representation of given numbers
   *
   * Problem Constraints
   *
   * 1 <= N <= 4 * 104
   * 1 <= A[i] <= 109
   * 1 <= Q <= 100
   * 0 <= B[i] < 32
   */
  private static int countXor1(ArrayList<Integer> A, ArrayList<Integer> Q) {
    ArrayList<Integer> B = new ArrayList<>();
    for(int i = 0; i < 32; i++) {
      B.add(0);
    }

    int n = A.size();

    for(int j = 0; j < B.size(); j++) {
      for(int i = 0; i < n; i++) {
        if(checkBit(A.get(i), j)) {
          B.set(j, B.get(j) + 1);
        }
      }
    }

    int rslt = 0;
    for(int i = 0; i < Q.size(); i++) {
      int temp = B.get(Q.get(i));
      rslt +=  temp * (n - temp);
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(countXor1(new ArrayList<>(Arrays.asList(2,424,23,43,42,4343,2)), new ArrayList<>(Arrays.asList(1,3,4,5,23,3,2,2,4))));
  }
}
