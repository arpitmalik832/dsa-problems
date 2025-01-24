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
 *   ["5", "5", "5", "5", "5", "5", "5", "5", "5"],
 *   ["5", "4", "4", "4", "4", "4", "4", "4", "5"],
 *   ["5", "4", "3", "3", "3", "3", "3", "4", "5"],
 *   ["5", "4", "3", "2", "2", "2", "3", "4", "5"],
 *   ["5", "4", "3", "2", "1", "2", "3", "4", "5"],
 *   ["5", "4", "3", "2", "2", "2", "3", "4", "5"],
 *   ["5", "4", "3", "3", "3", "3", "3", "4", "5"],
 *   ["5", "4", "4", "4", "4", "4", "4", "4", "5"],
 *   ["5", "5", "5", "5", "5", "5", "5", "5", "5"]
 * ]
 */
var createPattern = function (n) {
    var size = 2 * n - 1;
    var result = [];
    // Initialize the matrix
    for (var i = 0; i < size; i++) {
        result[i] = [];
    }
    for (var i = 0; i < size; i++) {
        for (var j = 0; j < size; j++) {
            // Find the minimum distance from edges
            var top_1 = i;
            var left = j;
            var bottom = size - 1 - i;
            var right = size - 1 - j;
            // The value at each position will be n minus the minimum distance
            var minDist = Math.min(Math.min(top_1, bottom), Math.min(left, right));
            var value = n - minDist;
            result[i][j] = value.toString();
        }
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
