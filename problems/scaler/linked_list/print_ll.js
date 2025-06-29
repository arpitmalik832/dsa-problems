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

function soln(A) {
  let temp = A;
  let str = "";
  while (temp) {
    str = `${str} ${temp.data}`;
    temp = temp.next;
  }
  console.log(str.trim());
}

// const head = createLL([1, 2, 3, 5, 3, 2]);
// soln(head);

export default soln;
