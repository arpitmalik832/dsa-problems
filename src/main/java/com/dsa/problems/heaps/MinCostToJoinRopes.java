package com.dsa.problems.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of size N representing sizes of different ropes. In a single operation,
 * you can connect two ropes and the cost of connecting those two ropes is the sum of the 
 * size of the ropes. Find the minimum cost for connecting all the ropes. 
 * 
 * Example:
 * arr = [2, 5, 3, 2, 6]
 */

public class MinCostToJoinRopes {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(2, 5, 3, 2, 6));

        System.out.println(solve(nums));
    }

    private static int solve(ArrayList<Integer> nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int rslt = 0;

        for(int n : nums) {
            minHeap.offer(n);
        }

        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            rslt += a + b;
            minHeap.offer(a + b);
        }

        return rslt;
    }
}
