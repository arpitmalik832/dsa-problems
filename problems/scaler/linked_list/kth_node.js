/**
 * Q. kth Node in a List
 *
 * You are given a singly linked list and an integer k. Your task is to access the node at the k-th index (0-based indexing) in the list and return its value. If the index is out of bounds, return -1.
 *
 * Problem Constraints
 * k<=10^6
 */

// Definition for singly-linked list.
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

function soln(A, B) {
  let temp = A;
  while (B-- && temp.next) {
    temp = temp.next;
  }
  if (B >= 0) {
    return -1;
  }
  return temp.data;
}

const head = createLL([
  90, 14, 83, 66, 45, 26, 29, 14, 52, 24, 29, 22, 97, 95, 98, 65, 90, 98, 51,
  80, 62, 10, 66, 86, 57,
]);
soln(head, 18);
