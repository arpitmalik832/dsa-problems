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
 *   ["1", " ", " ", " ", " ", " ", " ", " ", " ", "1"],
 *   ["1", "2", " ", " ", " ", " ", " ", " ", "2", "1"],
 *   ["1", "2", "3", " ", " ", " ", " ", "3", "2", "1"],
 *   ["1", "2", "3", "4", " ", " ", "4", "3", "2", "1"],
 *   ["1", "2", "3", "4", "5", "5", "4", "3", "2", "1"]
 * ]
 */

const createPattern = (n: number): string[][] => {
  const result: string[][] = [];

  for (let i = 0; i < n; i++) {
    const row: string[] = [];
    for (let j = 0; j < i + 1; j++) {
      row.push((j + 1).toString());
    }
    for (let j = 0; j < 2 * (n - (i + 1)); j++) {
      row.push(" ");
    }
    for (let j = i; j >= 0; j--) {
      row.push((j + 1).toString());
    }
    result.push(row);
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
