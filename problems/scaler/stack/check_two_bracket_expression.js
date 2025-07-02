/**
 * Q2. Check two bracket expressions

Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
 */
function soln(A, B) {
  function resolveBrackets(str) {
    let st = [];
    let rslt = "";
    const n = str.length;
    for (let i = 0; i < n; i++) {
      if (str[i] === "(") {
        if (st.length && st[st.length - 1] === "-") {
          if (str[i - 1] === "-") {
            st.push("+");
          } else if (str[i - 1] === "+") {
            st.push("-");
          }
        } else if (i > 0) {
          st.push(str[i - 1]);
        } else {
          st.push("+");
        }
      } else if (str[i] === ")") {
        st.pop();
      } else if (str[i] === "-") {
        if (rslt.endsWith("+") || rslt.endsWith("-")) {
          rslt = rslt.substring(0, rslt.length - 1);
        }
        if (st.length && st[st.length - 1] === "-") {
          if (rslt.length) {
            rslt += "+";
          }
        } else {
          rslt += "-";
        }
      } else if (str[i] === "+") {
        if (rslt.endsWith("+") || rslt.endsWith("-")) {
          rslt = rslt.substring(0, rslt.length - 1);
        }
        if (st.length && st[st.length - 1] === "-") {
          rslt += "-";
        } else {
          if (rslt.length) {
            rslt += "+";
          }
        }
      } else {
        rslt += str[i];
      }
    }
    return rslt;
  }

  function sortByChar(str) {
    let signArr = new Array(26).fill(0);
    let i = 0;
    if (["-"].includes(str[i])) {
      i++;
    }
    while (i < str.length) {
      if (i > 0 && str[i - 1] === "-") {
        signArr[str.charCodeAt(i) - "a".charCodeAt(0)] = 1;
      } else {
        signArr[str.charCodeAt(i) - "a".charCodeAt(0)] = 2;
      }
      i += 2;
    }

    str = "";
    for (let i = 0; i < 26; i++) {
      if (signArr[i] === 1) {
        str += "-" + String.fromCharCode(i + "a".charCodeAt(0));
      } else if (signArr[i] === 2) {
        str += "+" + String.fromCharCode(i + "a".charCodeAt(0));
      }
    }

    return str;
  }

  const rA = sortByChar(resolveBrackets(A));
  const rB = sortByChar(resolveBrackets(B));

  console.log(rA, rB);
  return rA === rB ? 1 : 0;
}

// console.log(soln("(a+b-c-d+e-f+g+h+i)", "a+b-c-d+e-f+g+h+i"));
console.log(soln("-(-(-(-a+b)-d+c)-q)", "a-b-d+c+q"));
// console.log(soln("-(a-(-z-(b-(c+t)-x)+l)-q)", "-a+l-b-(z-(c+t)-x-q)"));
// console.log(soln("-(a)", "a"));
