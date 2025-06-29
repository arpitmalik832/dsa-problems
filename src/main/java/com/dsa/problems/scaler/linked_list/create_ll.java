package com.dsa.problems.scaler.linked_list;

import java.util.ArrayList;
import java.util.Arrays;

public class create_ll {
  public static Node createLL(ArrayList<Integer> A) {
    if(A.size() > 0) {
      Node head = new Node(A.get(0));
      Node temp = head;
      for(int i = 1; i < A.size(); i++) {
        Node nn = new Node(A.get(i));
        temp.next = nn;
        temp = temp.next;
      }
      return head;
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    Node head = createLL(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
    print_ll.printLL(head);
  }
}
