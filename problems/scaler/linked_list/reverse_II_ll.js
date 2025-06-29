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

function soln(A, B, C) {
  if (!A || B === C) return A;

  let dummy = new Node(0);
  dummy.next = A;
  let prev = dummy;

  // Move prev to the node before position B
  for (let i = 1; i < B; i++) {
    prev = prev.next;
  }

  let curr = prev.next;
  let next = null;

  // Reverse the sublist from B to C
  for (let i = 0; i < C - B; i++) {
    next = curr.next;
    curr.next = next.next;
    next.next = prev.next;
    prev.next = next;
  }

  return dummy.next;
}

let head = createLL([1]);
printLL(head);
head = soln(head, 1, 1);
printLL(head);
