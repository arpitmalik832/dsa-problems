package com.dsa.problems.heaps;

import java.util.*;

public class MergeSortedArrays {
    public static class Pair {
        public int val;
        public int arrInd;
        public int index;

        public Pair(int val, int arrInd, int index) {
            this.val = val;
            this.arrInd = arrInd;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrOfArrays = new ArrayList<>();

        arrOfArrays.add(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        arrOfArrays.add(new ArrayList<>(List.of(16, 34, 86, 91, 100)));
        arrOfArrays.add(new ArrayList<>(List.of(64, 344, 800, 913, 1003)));

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(A -> A.val));

        for(int i = 0; i < arrOfArrays.size(); i++) {
            minHeap.offer(new Pair(arrOfArrays.get(i).get(0), i, 0));
        }

        ArrayList<Integer> rslt = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            rslt.add(pair.val);
            int arrInd = pair.arrInd;
            int index = pair.index;

            if (index + 1 < arrOfArrays.get(arrInd).size()) {
                minHeap.offer(
                        new Pair(arrOfArrays.get(arrInd).get(index + 1), arrInd, index + 1)
                );
            }
        }

        System.out.println(rslt);
    }
}
