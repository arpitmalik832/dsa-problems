package com.dsa.problems.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Multiple ways to convert array into heap. 
 * One would be inserting each element of the array into a complete new heap.
 * It would take O(N * log N) time complexity.
 * Another approach would be to consider the existing array heap only.
 * So, all the leaf nodes would follow the heap property. 
 * Then from the very first parent at the bottom upto the root of the heap,
 * we'll start calling the heapify down function to make the array follow the heap property.
 * As a result, we would be having a heap in O(N) time complexity.
 */

public class ConvertArrayIntoHeap {
    private static void heapify(ArrayList<Integer> arr, int i) {
        int n = arr.size();

        while(2 * i + 1 < n) {
            int i1 = 2 * i + 1;
            int i2 = 2 * i + 2;
            
            int index = i;
            if (i2 < n && arr.get(i2) < arr.get(index)) {
                index = i2;
            }
            
            if (arr.get(i1) < arr.get(index)) {
                index = i1;
            }

            if (index != i) {
                int temp = arr.get(index);
                arr.set(index, arr.get(i));
                arr.set(i, temp);
                i = index;
            } else {
                break;
            }
        }
    }

    private static void genHeap(ArrayList<Integer> arr) {
        int n = arr.size();
        int i = (n - 2) / 2;

        while (i >= 0) {
            heapify(arr, i);
            i--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(10, 4, 9, 8, 2, 10));

        genHeap(arr);

        System.out.println(arr);
    }
    
}
