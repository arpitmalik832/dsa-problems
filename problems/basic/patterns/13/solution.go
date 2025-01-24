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
package main

import (
	"fmt"
	"strconv"
	"strings"
)

func createPattern (n int) [][]string {
  result:= [][]string{}

  no := 1
  for i := 0; i < n; i++ {
    row:= []string{}
    for j := 0; j < i + 1; j++ {
      row =append(row, strconv.Itoa(no));
      no++
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


