/**
 * Q. Factors sort
 *
 * You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.
 *
 * Note: You cannot use any extra space
 */
function soln(A) {
  function noOfFactors(n) {
    let count = 0;
    for (let i = 1; i * i <= n; i++) {
      if (n % i === 0) {
        if (Math.floor(n / i) === i) {
          count++;
        } else {
          count += 2;
        }
      }
    }

    return count;
  }

  A.sort((a, b) => {
    const aF = noOfFactors(a);
    const bF = noOfFactors(b);
    if (aF === bF) {
      return a <= b ? -1 : 1;
    } else if (aF > bF) {
      return 1;
    } else {
      return -1;
    }
  });

  return A;
}
