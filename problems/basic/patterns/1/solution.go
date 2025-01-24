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
 *   ["*", "*", "*", "*", "*"],
 *   ["*", "*", "*", "*", "*"],
 *   ["*", "*", "*", "*", "*"],
 *   ["*", "*", "*", "*", "*"]
 * ]
 */
package main

import (
	"fmt"
	"strings"
)

func createPattern (n int) [][]string {
  result:= [][]string{}

  for i := 0; i < n; i++ {
    row:= []string{}
    for j := 0; j < n; j++ {
      row =append(row,"*");
    }
    result= append(result, row);
  }

  return result;
};

func main () {
  result := createPattern(5);

  fmt.Println("Solution: ")


   // Instead of using map, we'll create a new slice and transform each row
	 formattedRows := make([]string, len(result))
	 for i, row := range result {
			 formattedRows[i] = strings.Join(row, " ")
	 }
	 
	 // Join the rows with newlines
	 resultString := strings.Join(formattedRows, "\n")
  fmt.Println(resultString);
};


