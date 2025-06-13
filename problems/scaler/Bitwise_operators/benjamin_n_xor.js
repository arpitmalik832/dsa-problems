/**
 * Benjamin and XOR
 *
 * In the picturesque town of Bitville, nestled amidst rolling hills and shimmering lakes, the residents had a deep fascination with the world of bits and binary operations. The townsfolk were avid mathematicians, always seeking new puzzles to unravel and insights to gain.
 * One sunny morning, the town's esteemed professor of mathematics, Dr. Benjamin, presented a captivating challenge to his students. He introduced them to an array A of N integers, representing a sequence of numbers with each element holding a special significance.
 * Dr. Benjamin explained that the students' task was to analyze the array and determine the count of pairs that satisfied a unique condition. The condition revolved around the XOR operation on the ith bit of the pair's elements. The goal was to count the pairs for which the xor of the ith bit resulted in one. You have to answer for Q queries given in array B, each query B[i] denotes the index for which you need to find the count of pairs with xor of that index equals 1.
 * Can you solve the task given by Dr. Benjamin?
 * Please read the examples given below for better understanding of the problem.
 * HINT : Look at the binary representation of given numbers
 *
 * Problem Constraints
 *
 * 1 <= N <= 4 * 104
 * 1 <= A[i] <= 109
 * 1 <= Q <= 100
 * 0 <= B[i] < 32
 */
function soln(A, B) {
  function checkBit(n, i) {
    return (n >> i) & 1;
  }
  let bits = new Array(32).fill(0);
  for (let b = 0; b < bits.length; b++) {
    for (let i = 0; i < A.length; i++) {
      if (checkBit(A[i], b)) {
        bits[b]++;
      }
    }
  }

  let rslt = [];
  for (let j = 0; j < B.length; j++) {
    rslt.push(bits[B[j]] * (A.length - bits[B[j]]));
  }

  return rslt;
}
