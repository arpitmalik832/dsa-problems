/**
 * Q. Reverse Linked List
 *
 * You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
 *
 * NOTE: You have to do it in-place and in one-pass.
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

function soln(A) {
  let curr = A;
  let prev = null;
  let next = A;
  while (curr) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }

  return prev;
}

let head = createLL([1, 2, 3, 4, 5]);
printLL(head);
head = soln(head);
printLL(head);
