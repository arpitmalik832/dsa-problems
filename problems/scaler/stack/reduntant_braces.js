function soln(A) {
  let st = [];
  for (const a of A) {
    if (["(", "+", "-", "*", "/"].includes(a)) {
      st.push(a);
    } else if (a === ")") {
      if (st.length && ["+", "-", "*", "/"].includes(st[st.length - 1])) {
        st.pop();
        st.pop();
      } else {
        return 1;
      }
    }
  }
  return 0;
}
