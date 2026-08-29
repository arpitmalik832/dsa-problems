package com.dsa.problems.heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
  /**
   * We need to sort the array using heaps.
   * <p>
   * 1. The first approach is using the min heap to sort the array in to the ascending order.
   * Here the root of the heap will give us the minimum item. So, first we'll build the heap 
   * from the array that would take O(N) time complexity. Then, we'll pop each item from it.
   * That will take O(log N) time complexity for each for N times. So, the overall time
   * complexity would be O (N * log N). But here we are using an additional space to
   * build the heap. So, the space complexity would also be O(N) here.
   * <p>
   * 2. The second and optimal approach would be using max heap. As for extracting the root
   * of the heap. First, we swap the root with the last item of the heap. So, by doing
   * this for n times, we can start storing the max item time at the end of the heap.
   * As a result, we'll have the sorted array in O(N * log N) time complexity and O(1)
   * space complexity.
   */
  public static class MaxHeap {
    public ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int n) {
      this.heap.add(n);
      heapifyUp(heap.size() - 1);
    }

    private void swap(int i1, int i2) {
      int temp = heap.get(i1);
      heap.set(i1, heap.get(i2));
      heap.set(i2, temp);
    }

    public void heapifyUp(int i) {
      while(i > 0) {
        int parent = (i - 1) / 2;
        if (heap.get(parent) < heap.get(i)) {
          swap(i, parent);
          i = parent;
        } else {
          break;
        }
      }
    }

    public void remove(int n) {
      swap(0, n - 1);
      heapifyDown(0, n - 1);
    }

    public void heapifyDown(int i, int n) {
      while(2 * i + 1 < n) {
        int index = i;
        if (2 * i + 2 < n && heap.get(2 * i + 2) > heap.get(index)) {
          index = 2 * i + 2;
        }
        if(heap.get(2 * i + 1) > heap.get(index)) {
          index = 2 * i + 1;
        }

        if (index != i) {
          swap(i, index);
          i = index;
        } else {
          break;
        }
      }
    }
  }

  private static void heapSort(ArrayList<Integer> arr) {
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.heap = arr;

    int i = (maxHeap.heap.size() - 2) / 2;
    while(i >= 0) {
      maxHeap.heapifyDown(i, maxHeap.heap.size());
      i--;
    }

    i = maxHeap.heap.size() - 1;
    while (i >= 0) {
      maxHeap.remove(i + 1);
      i--;
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(List.of(5,8,4,7,5,2,1,10));

    System.out.println("Array: " + arr);
    heapSort(arr);
    System.out.println("Array: " + arr);
  }
}
