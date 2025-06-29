/**
 * Q. Delete in Linked List
 *
 * You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
 *
 * Note : Follow 0-based indexing for the node numbering.
 */
import printLL from "./print_ll.js";

class Node {
  constructor(A) {
    this.data = A;
    this.next = null;
  }
}

function createLL(A) {
  let head = null;
  let temp = null;
  for (const a of A) {
    const nn = new Node(a);
    if (!head) {
      head = nn;
      temp = nn;
    } else {
      temp.next = nn;
      temp = temp.next;
    }
  }

  return head;
}

function soln(A, B) {
  let temp = A;
  if (B == 0) {
    A = A.next;
    return A;
  }
  for (let i = 1; i < B; i++) {
    temp = temp.next;
  }
  temp.next = temp.next.next;
  return A;
}

let head = createLL([1, 2, 3, 4, 5, 6]);
printLL(head);
head = soln(head, 4);
printLL(head);
head = soln(head, 0);
printLL(head);
