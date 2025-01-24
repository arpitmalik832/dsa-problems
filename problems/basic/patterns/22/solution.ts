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

const createPattern = (n: number): string[][] => {
  const size = 2 * n - 1;
  const result: string[][] = [];

  // Initialize the matrix
  for (let i = 0; i < size; i++) {
    result[i] = [];
  }

  for (let i = 0; i < size; i++) {
    for (let j = 0; j < size; j++) {
      // Find the minimum distance from edges
      const top = i;
      const left = j;
      const bottom = size - 1 - i;
      const right = size - 1 - j;

      // The value at each position will be n minus the minimum distance
      const minDist = Math.min(Math.min(top, bottom), Math.min(left, right));
      const value = n - minDist;

      result[i][j] = value.toString();
    }
  }

  return result;
};

const solution = () => {
  const result = createPattern(5);

  console.log("Solution :");

  const resultString = result.map((row) => row.join(" ")).join("\n");
  console.log(resultString);
};

solution();
