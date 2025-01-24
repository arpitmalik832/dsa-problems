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
 *   ["*", "*", "*", "*", "*"],
 *   ["*", " ", " ", " ", "*"],
 *   ["*", " ", " ", " ", "*"],
 *   ["*", " ", " ", " ", "*"],
 *   ["*", "*", "*", "*", "*"]
 * ]
 */

const createPattern = (n: number): string[][] => {
  const result: string[][] = [];

  for (let i = 0; i < n; i++) {
    const row: string[] = [];

    if (i == 0 || i == n - 1) {
      for (let j = 0; j < n; j++) {
        row.push("*");
      }
    } else {
      row.push("*");
      for (let j = 0; j < n - 2; j++) {
        row.push(" ");
      }
      row.push("*");
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
