/**
 * Merge Intervals - 2
 *
 * You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Problem Constraints
 *
 * 0 <= |intervals| <= 105
 *
 * Input Format
 *
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 * Output Format
 *
 * Return the vector of intervals after merging
 *
 * Example Input
 *
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 *
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 * Example Output
 *
 * Output 1:
 *
 * [ [1, 5], [6, 9] ]
 *
 * Output 2:
 *
 * [ [1, 9] ]
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 *
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 *
 */

function soln(A, B) {
  const n = A.length;
  let newA = A;
  let isInserted = false;
  for (let i = 0; i < n; i++) {
    if (B[0] < A[i][0] || (B[0] === A[i][0] && B[1] <= A[i][1])) {
      newA = [...newA.slice(0, i), B, ...newA.slice(i)];
      isInserted = true;
      break;
    }
  }
  if (!isInserted) {
    newA = [...newA, B];
  }

  const rslt = [];
  const N = newA.length;
  let current = newA[0];

  for (let i = 1; i < N; i++) {
    if (current[1] >= newA[i][0]) {
      current[1] = Math.max(current[1], newA[i][1]);
    } else {
      rslt.push(current);
      current = newA[i];
    }
  }
  rslt.push(current);

  return rslt;
}

console.log(
  soln(
    [
      [1, 3],
      [6, 9],
    ],
    [2, 5]
  )
);
console.log(
  soln(
    [
      [3, 5],
      [8, 10],
    ],
    [1, 12]
  )
);
console.log(
  soln(
    [
      [6037774, 6198243],
      [6726550, 7004541],
      [8842554, 10866536],
      [11027721, 11341296],
      [11972532, 14746848],
      [16374805, 16706396],
      [17557262, 20518214],
      [22139780, 22379559],
      [27212352, 28404611],
      [28921768, 29621583],
      [29823256, 32060921],
      [33950165, 36418956],
      [37225039, 37785557],
      [40087908, 41184444],
      [41922814, 45297414],
      [48142402, 48244133],
      [48622983, 50443163],
      [50898369, 55612831],
      [57030757, 58120901],
      [59772759, 59943999],
      [61141939, 64859907],
      [65277782, 65296274],
      [67497842, 68386607],
      [70414085, 73339545],
      [73896106, 75605861],
      [79672668, 84539434],
      [84821550, 86558001],
      [91116470, 92198054],
      [96147808, 98979097],
    ],
    [36210193, 61984219]
  )
);
