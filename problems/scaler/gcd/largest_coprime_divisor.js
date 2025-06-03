/**
 * Largest Coprime Divisor
 *
 * You are given two positive numbers A and B. You need to find the maximum valued integer X such that:
 *
 * X divides A i.e. A % X = 0
 * X and B are co-prime i.e. gcd(X, B) = 1
 *
 * For example,
 */
function soln(A, B) {
  function gcd(n, m) {
    if (m === 0) {
      return n;
    }
    return gcd(m, n % m);
  }

  function findFactors(n) {
    const rslt = [];
    for (let i = 1; i * i <= n; i++) {
      if (n % i === 0) {
        if (n / i === i) {
          rslt.push(i);
        } else {
          rslt.push(i, n / i);
        }
      }
    }

    return rslt;
  }

  const factors = findFactors(A);

  let ans = 0;
  for (let i = 0; i < factors.length; i++) {
    if (factors[i] >= B && gcd(factors[i], B) === 1) {
      ans = Math.max(ans, factors[i]);
    } else if (gcd(B, factors[i]) === 1) {
      ans = Math.max(ans, factors[i]);
    }
  }

  return ans;
}

console.log(soln(30, 12));
