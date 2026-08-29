package com.dsa.problems.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Insertion of element in O(log N) time
 * Extraction of the minimum element in O(log N) time
 */

public class OwnHeap {
    private static void swap(ArrayList<Integer> minHeap, int i, int j) {
        int temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }

    private static void insert(ArrayList<Integer> minHeap, int n) {
        minHeap.add(n);
        heapifyUp(minHeap);
    }

    private static int extractMin(ArrayList<Integer> minHeap) {
        if (minHeap.isEmpty()) {
            throw new IllegalArgumentException("MinHeap is already empty.");
        }

        swap(minHeap, 0, minHeap.size() - 1);

        int result = minHeap.remove(minHeap.size() - 1);
        heapifyDown(minHeap);
        return result;
    }

    private static void heapifyUp(ArrayList<Integer> minHeap) {
        int i = minHeap.size() - 1;
        while(i > 0) {
            int parent = (i - 1) / 2;

            if (minHeap.get(i) < minHeap.get(parent)) {
                swap(minHeap, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private static void heapifyDown(ArrayList<Integer> minHeap) {
        int i = 0;
        while(2 * i + 1 < minHeap.size()) {
            int index = 2 * i + 1;
            if (2 * i + 2 < minHeap.size()) {
                if (minHeap.get(2 * i + 2) < minHeap.get(2 * i + 1)) {
                    index = 2 * i + 2;
                } 
            }

            if (minHeap.get(index) < minHeap.get(i)) {
                swap(minHeap, i, index);
                i = index;
            } else {
                break;
            }
        }
    }

    private static int menu(ArrayList<Integer> minHeap, Scanner sc) {
        System.out.println("The heap is: " + minHeap);
        System.out.println("You can perform following heap operations: ");
        System.out.println("1. Insertion: ");
        System.out.println("2. Extract Min: ");
        System.out.println("Please Enter selected option: ");
        int option = sc.nextInt();
        return option;
    } 

    public static void main(String[] args) {
        /**
         *              5
         *            /   \
         *          12     20
         *         /  \   /  \
         *        25  13 24   22
         *       /
         *      35
         */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> minHeap = new ArrayList<>(List.of(5, 12, 20, 25, 13, 24, 22, 35));
        int option = menu(minHeap, sc);

        while(true) {
            switch(option) {
                case 1:
                    System.out.println("Please enter the number that need to be inserted: ");
                    int n = sc.nextInt();
                    insert(minHeap, n);
                    option = menu(minHeap, sc);
                    break;
                case 2:
                    int result = extractMin(minHeap);
                    System.out.println("Min is: " + result);
                    option = menu(minHeap, sc);
                    break;
                default:
                    System.out.println("Plese enter a valid option!");
                    throw new IllegalArgumentException("Please enter a valid option");
            }
        }
    }
}
