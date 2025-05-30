function soln(A) {
  function arr(n) {
    if (n.length == 1) {
      return `${n[0]}`;
    }
    const len = n.length;
    const curr = n[len - 1];
    const nN = n.slice(0, len - 1);
    return `${arr(nN)} ${curr}`;
  }

  console.log(`${arr(A)} `);
}

soln([1, 2, 3, 4, 5]);
