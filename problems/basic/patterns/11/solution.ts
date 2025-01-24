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
 *   ["0", "1", "", "", ""],
 *   ["1", "0", "1", "", ""],
 *   ["0", "1", "0", "1", ""],
 *   ["1", "0", "1", "0", "1"]
 * ]
 */

const createPattern = (n: number): string[][] => {
  const result: string[][] = [];

  for (let i = 0; i < n; i++) {
    const row: string[] = [];
    let stNo = (i + 1) % 2;
    for (let j = 0; j < i + 1; j++) {
      row.push(stNo.toString());
      if (stNo == 0) {
        stNo = 1;
      } else if (stNo == 1) {
        stNo = 0;
      }
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
