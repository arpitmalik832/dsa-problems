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
import printLL from "./print_ll.js";

class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
    this.random = null;
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

function soln(A) {
  let temp = A;
  while (temp) {
    const nn = new Node(temp.data);
    nn.next = temp.next;
    temp.next = nn;
    temp = temp.next.next;
  }

  let orig = head;
  let dupl = orig.next;
  while (orig) {
    dupl = orig.next;
    let rand = orig.random;
    if (rand) {
      let randDupl = rand.next;
      dupl.random = randDupl;
    }
    orig = dupl.next;
  }

  orig = head;
  let newHead = orig.next;
  dupl = orig.next;
  while (orig) {
    dupl = orig.next;
    let next = dupl.next;
    if (next) {
      let nextDupl = next.next;
      orig.next = next;
      dupl.next = nextDupl;
      orig = orig.next;
    } else {
      break;
    }
  }

  return newHead;
}

let head = createLL([1, 3, 2, 4, 4, 3, 5]);
printLL(head);
head = soln(head);
printLL(head);
