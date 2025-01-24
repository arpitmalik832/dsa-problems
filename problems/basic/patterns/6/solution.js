/**
 * Given an integer n, create a function that returns a 2D array of strings
 * where each row is a string of n asterisks.
 *
 * @param n - The number of rows and columns in the 2D array.
 * @returns A 2D array of strings, where each row is a string of n asterisks.
 * @example
 * input: 5
 * output:
 * [
 *   ["1", "2", "3", "4", "5"],
 *   ["1", "2", "3", "4", ""],
 *   ["1", "2", "3", "", ""],
 *   ["1", "2", "", "", ""],
 *   ["1", "", "", "", ""]
 * ]
 */
var createPattern = function (n) {
  var result = [];
  for (var i = 0; i < n; i++) {
    var row = [];
    for (var j = 0; j < n - i; j++) {
      row.push((j + 1).toString());
    }
    result.push(row);
  }
  return result;
};
var solution = function () {
  var result = createPattern(5);
  console.log("Solution :");
  var resultString = result
    .map(function (row) {
      return row.join(" ");
    })
    .join("\n");
  console.log(resultString);
};
solution();
