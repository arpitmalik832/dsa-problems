function checkPalindrome(n) {
  if ([0, 1].includes(n.length)) {
    return 1;
  }

  if (n[0] == n[n.length - 1]) {
    return checkPalindrome(n.substring(1, n.length - 1));
  }

  return 0;
}

function soln(A) {
  return checkPalindrome(A);
}

function checkPalindrome(n) {
  if ([0, 1].includes(n.length)) {
    return 1;
  }

  if (n[0] == n[n.length - 1]) {
    return checkPalindrome(n.substring(1, n.length - 1));
  }

  return 0;
}

function soln(A) {
  return checkPalindrome(A);
}

console.log(soln("abba"));
console.log(soln("abbaa"));
