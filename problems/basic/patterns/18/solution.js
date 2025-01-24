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
 *   ["E", " ", " ", " ", " "],
 *   ["D", "E", " ", " ", " "],
 *   ["C", "D", "E", " ", " "],
 *   ["B", "C", "D", "E", " "],
 *   ["A", "B", "C", "D", "E"]
 * ]
 */
var createPattern = function (n) {
    var result = [];
    for (var i = 0; i < n; i++) {
        var row = [];
        for (var j = 0; j < i + 1; j++) {
            row.push(String.fromCharCode(65 + j - i + n - 1));
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
