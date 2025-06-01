/**
 * Tower of Hanoi is a problem where we have three rods and n disks.
 * We need to move the disks from the source rod to the destination rod using the auxiliary rod.
 * We can only move one disk at a time and we can't place a larger disk on a smaller disk.
 */

function moveDiscs(n, start, dest, buffer, arr) {
  if (n == 1) {
    arr.push([n, start, dest]);
    return;
  }

  moveDiscs(n - 1, start, buffer, dest, arr);
  arr.push([n, start, dest]);
  moveDiscs(n - 1, buffer, dest, start, arr);
}

function soln(A) {
  let rslt = [];
  moveDiscs(A, 1, 2, 3, rslt);
  return rslt;
}

console.log(soln(3));
