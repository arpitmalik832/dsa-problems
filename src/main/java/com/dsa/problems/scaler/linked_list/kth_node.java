package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class kth_node {
  /**
   * Q. kth Node in a List
   *
   * You are given a singly linked list and an integer k. Your task is to access the node at the k-th index (0-based indexing) in the list and return its value. If the index is out of bounds, return -1.
   *
   * Problem Constraints
   * k<=10^6
   */
  private static int kthNode(Node A, int B) {
    if(B == 0) {
      return A.data;
    }
    Node temp = A;
    for(int i = 1; i < B && temp.next != null; i++) {
      temp = temp.next;
    }
    if(temp.next != null) 
      return temp.next.data;
    else return -1;
  }

  public static void main(String[] args) {
    Node temp = create_ll.createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    System.out.println(kthNode(temp, 0));
    System.out.println(kthNode(temp, 3));
    System.out.println(kthNode(temp, 30));
    System.out.println(kthNode(temp, 5));
  }
}
