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
 *   ["*", " ", " ", " ", " ", " ", " ", " ", "*"],
 *   ["*", "*", " ", " ", " ", " ", " ", "*", "*"],
 *   ["*", "*", "*", " ", " ", " ", "*", "*", "*"],
 *   ["*", "*", "*", "*", " ", "*", "*", "*", "*"],
 *   ["*", "*", "*", "*", "*", "*", "*", "*", "*"],
 *   ["*", "*", "*", "*", " ", "*", "*", "*", "*"],
 *   ["*", "*", "*", " ", " ", " ", "*", "*", "*"],
 *   ["*", "*", " ", " ", " ", " ", " ", "*", "*"],
 *   ["*", " ", " ", " ", " ", " ", " ", " ", "*"]
 * ]
 */
var createPattern = function (n) {
    var result = [];
    for (var i = 0; i < n; i++) {
        var row = [];
        for (var j = 0; j < i + 1; j++) {
            row.push("*");
        }
        for (var j = 0; j < 2 * (n - i - 1); j++) {
            row.push(" ");
        }
        for (var j = 0; j < i + 1; j++) {
            row.push("*");
        }
        result.push(row);
    }
    for (var i = 0; i < n - 1; i++) {
        var row = [];
        for (var j = 0; j < n - i - 1; j++) {
            row.push("*");
        }
        for (var j = 0; j < 2 * (i + 1); j++) {
            row.push(" ");
        }
        for (var j = 0; j < n - i - 1; j++) {
            row.push("*");
        }
        result.push(row);
    }
    return result;
};
var solution = function () {
    var result = createPattern(5);
    console.log("Solution :");
    var resultString = result.map(function (row) { return row.join(" "); }).join("\n");
    console.log(resultString);
};
solution();
