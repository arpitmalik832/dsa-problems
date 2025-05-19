/**
 * Continuous Sum Query
 *
 * There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some all the beggars sitting after them.
 *
 * Given the amount P donated by each devotee to the beggars starting from L index, where 1 <= L <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
 * For ith devotee B[i][0] = L, B[i][1] = P, given by the 2D array B
 *
 * Problem Constraints
 * 1 <= A <= 2 * 105
 * 1 <= L <= A
 * 1 <= P <= 103
 * 0 <= len(B) <= 105
 *
 * Input Format
 * The first argument is a single integer A.
 * The second argument is a 2D integer array B.
 *
 * Output Format
 * Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
 *
 * Example Input
 *
 * Input 1:-
 * A = 5
 * B = [[1, 10], [2, 20], [2, 25]]
 *
 * Example Output
 *
 * Output 1:-
 * 10 55 45 25 25
 *
 * Example Explanation
 *
 * Explanation 1:-
 * First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
 * Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
 * Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
 */

package com.dsa.problems.scaler.One_D_Array;

import java.util.*;

public class Continuous_Array_Query {

  /**
   * Optimized Solution using prefix sum
   * Time Complexity: O(N + Q)
   * Space Complexity: O(N)
   */
  public static ArrayList<Integer> soln2(int N, ArrayList<ArrayList<Integer>> Q) {
    ArrayList<Integer> A = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      A.add(0);
    }

    final int qSize = Q.size();
    for (int i = 0; i < qSize; i++) {
      int start = Q.get(i).get(0) - 1;
      int value = Q.get(i).get(1);
      A.set(start, A.get(start) + value);
    }

    for (int i = 1; i < N; i++) {
      A.set(i, A.get(i) + A.get(i - 1));
    }

    return A;
  }

  public static void main(String[] args) {
    int N = 5;
    ArrayList<ArrayList<Integer>> Q = new ArrayList<>();
    Q.add(new ArrayList<>(Arrays.asList(1, 10)));
    Q.add(new ArrayList<>(Arrays.asList(2, 20)));
    Q.add(new ArrayList<>(Arrays.asList(2, 25)));

    System.out.println(soln2(N, Q));
  }
}
