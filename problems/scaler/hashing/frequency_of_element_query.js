/**
 * Q. Frequency of element query
 *
 * SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating the least, allowing them to provide targeted support and encouragement.
 *
 * Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner, and an array B containing the learners for whom you want to check participation frequency, your task is to find the frequency of each learner from array B in the array A and return a list containing all these frequencies
 */
function soln(A, B) {
  const mp = new Map();
  for (const i of A) {
    if (mp.has(i)) {
      mp.set(i, mp.get(i) + 1);
    } else {
      mp.set(i, 1);
    }
  }
  const rslt = [];
  for (const i of B) {
    if (mp.has(i)) {
      rslt.push(mp.get(i));
    } else {
      rslt.push(0);
    }
  }

  return rslt;
}

console.log(soln([1, 2, 1, 1], [1, 2]));
