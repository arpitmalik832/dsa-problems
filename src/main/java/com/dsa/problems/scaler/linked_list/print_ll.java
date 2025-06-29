package com.dsa.problems.scaler.linked_list;

public class print_ll {
  public static void printLL(Node A) {
    Node temp = A;
    while(temp != null) {
      System.out.print(temp.data);
      System.out.print(" ");
      temp = temp.next;
    }
    System.out.println();
  }
}
