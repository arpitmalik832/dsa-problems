/**
 * Q. Double Character Trouble

You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.
 */
function soln(A) {
  let st = [];
  for (let i = 0; i < A.length; i++) {
    if (st.length === 0 || st[st.length - 1] !== A[i]) {
      st.push(A[i]);
    } else {
      st.pop();
    }
  }

  return st.join("");
}
