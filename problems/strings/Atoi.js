function soln(s) {
  const strArr = Array.from(s.trim());
  const isNegative = strArr[0] === "-";

  let num = 0;
  for (let i = 0; i < strArr.length; i++) {
    if (strArr[i].match(/\d/)) {
      num = num * 10 + Number(strArr[i]);
    }
  }

  if (num > 0 && isNegative) num = -num;

  const upperLimit = Math.pow(2, 31) - 1;
  const lowerLimit = -Math.pow(2, 31);
  if (num > upperLimit) {
    return upperLimit;
  }
  if (num < lowerLimit) {
    return lowerLimit;
  }

  return num;
}

console.log(soln("-0012gfg4")); // -12
