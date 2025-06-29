package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class copy_ll {
  /**
 * Q. Copy List
 * 
 * You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)


Problem Constraints

0 <= |A| <= 106
 */
  private static Node copyLL(Node head) {
    Node temp = head;
    while(temp != null) {
      Node nn = new Node(temp.data);
      nn.next = temp.next;
      temp.next = nn;
      temp = temp.next.next;
    }

    Node curr = head;
    Node currDupl = head.next;
    while(curr != null) {
      Node random = head.random;
      if(random != null) {
        Node randomDupl = random.next;
        currDupl.random = randomDupl;
      }
      curr = currDupl.next;
    }

    Node newHead = head.next;
    curr = head;
    currDupl = head.next;
    Node next = currDupl.next;
    while(next != null) {
      currDupl = curr.next;
      next = currDupl.next;
      Node nextDupl = next.next;
      curr.next = next;
      currDupl.next = nextDupl;
      curr = curr.next;
    }

    return newHead;
  }

  public static void main(String[] args) {
    Node head = create_ll.createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    print_ll.printLL(head);
    head = copyLL(head);
    print_ll.printLL(head);
  }
}
