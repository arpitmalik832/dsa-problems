package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class reverse_II_ll {
  /**
 * Q. Reverse Link List II
 *
 * Reverse a linked list A from position B to C.
 *
 * NOTE: Do it in-place and in one-pass.
 *
 * Problem Constraints
 * 1 <= |A| <= 106
 * 1 <= B <= C <= |A|
 */
  private static Node reverseIILL(Node A, int B, int C) {
    Node dummy = new Node(0);
    dummy.next = A;
    Node prev = dummy;
    for(int i = 1; i < B; i++) {
      prev = prev.next;
    }

    Node curr = prev.next;

    for(int i = 0; i < C - B; i++) {
      Node next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Node head = create_ll.createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    head = reverseIILL(head, 1, 4);
    print_ll.printLL(head);
  }
}
