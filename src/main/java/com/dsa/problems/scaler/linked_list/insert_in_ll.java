package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class insert_in_ll {
  /**
   * Q. Insert in Linked List
   *
   * You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.
   *
   * Notes:
   * In case the position is more than length of linked list, simply insert the new node at the tail only.
   * In case the pos is 0, simply insert the new node at head only.
   * Follow 0-based indexing for the node numbering.
   */
  private static Node insertInLL(Node A, int B, int C) {
    Node nn = new Node(B);
    if(C == 0) {
      nn.next = A;
      return nn;
    }
    Node temp = A;
    int i = 1;
    for(i = 1; i < C && temp.next != null; i++) {
      temp = temp.next;
    }
    nn.next = temp.next;
    temp.next = nn;
    return A;
  }

  public static void main(String[] args) {
    Node head = create_ll.createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
    head = insertInLL(head, 6, 0);
    head = insertInLL(head, 7, 3);
    head = insertInLL(head, 8, 30);
    print_ll.printLL(head);
  }
}
