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
 *   ["1", "", "", "", ""],
 *   ["2", "3", "", "", ""],
 *   ["4", "5", "6", "", ""],
 *   ["7", "8", "9", "10", ""],
 *   ["11", "12", "13", "14", "15"]
 * ]
 */

const createPattern = (n: number): string[][] => {
  const result: string[][] = [];

  let no = 1;
  for (let i = 0; i < n; i++) {
    const row: string[] = [];
    for (let j = 0; j < i + 1; j++) {
      row.push(no.toString());
      no++;
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
