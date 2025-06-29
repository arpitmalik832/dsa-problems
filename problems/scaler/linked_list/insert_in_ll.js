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
import printLL from "./print_ll.js";

class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

function createLL(A) {
  let head = null;
  let temp = null;
  for (let a of A) {
    const newNode = new Node(a);
    if (head === null) {
      head = newNode;
      temp = newNode;
    } else {
      temp.next = newNode;
      temp = temp.next;
    }
  }
  return head;
}

function soln(A, B, C) {
  let temp = A;
  const nn = new Node(B);
  if (C === 0) {
    nn.next = A;
    A = nn;
    return A;
  }

  for (let i = 1; i < C; i++) {
    temp = temp.next;
  }
  nn.next = temp.next;
  temp.next = nn;
  return A;
}

let head = createLL([1, 2]);
printLL(head);
head = soln(head, 3, 0);
printLL(head);
head = soln(head, 3, 1);
printLL(head);
