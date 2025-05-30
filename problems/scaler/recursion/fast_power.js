function soln(A, B) {
  if (B === 0) {
    return 1;
  }

  const t = soln(A, B / 2);

  if ((B & 1) === 0) {
    return t * t;
  }

  return t * t * A;
}

console.log(soln(2, 10));
