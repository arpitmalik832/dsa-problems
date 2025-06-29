package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class reverse_ll {
  /**
 * Q. Reverse Linked List
 *
 * You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
 *
 * NOTE: You have to do it in-place and in one-pass.
 */
  private static Node reverseLL(Node A) {
    Node dummy = new Node(0);
    dummy.next = A;
    Node prev = dummy;
    Node curr = prev.next;
    while(curr.next != null) {
      Node next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    Node head = create_ll.createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    head = reverseLL(head);
    print_ll.printLL(head);
  }
}
