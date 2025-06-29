package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class deletion_in_ll {
  /**
 * Q. Delete in Linked List
 *
 * You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
 *
 * Note : Follow 0-based indexing for the node numbering.
 */
  private static Node deletionInLL(Node A, int B) {
    if(B == 0) {
      return A.next;
    }
    Node temp = A;
    for(int i = 1; i < B; i++) {
      temp = temp.next;
    }
    temp.next = temp.next.next;

    return A;
  }

  public static void main(String[] args) {
    Node head = create_ll.createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
    head = deletionInLL(head, 0);
    head = deletionInLL(head, 3);
    print_ll.printLL(head);
  }
}
