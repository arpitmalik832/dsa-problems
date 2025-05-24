/**
 * Q. Help From Sam
 *
 * Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
 * Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want to take much help from Sam.
 *
 * Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.
 */
function checkBit(A, i) {
  return ((A >> i) & 1) == 1;
}
function soln(A) {
  // by taking help from sam, 1 will be added. so, that many numbers of bits are set. So, we just need to calculate the number of set bits.
  let rslt = 0;
  for (let i = 0; i < 32; i++) {
    rslt += checkBit(A, i);
  }

  return rslt;
}

console.log(soln(4));
console.log(soln(3));
console.log(soln(5));
