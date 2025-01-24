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
package main

import (
	"fmt"
	"strconv"
	"strings"
)

func min(a, b int) int {
  if a < b {
      return a
  }
  return b
}

func createPattern(n int) [][]string {
  size := 2*n - 1  // Total size of the matrix will be 2n-1
  result := make([][]string, size)
  
  // Initialize the matrix
  for i := range result {
      result[i] = make([]string, size)
  }
  
  // Fill the pattern
  for i := 0; i < size; i++ {
      for j := 0; j < size; j++ {
          // Find the minimum distance from edges
          top := i
          left := j
          bottom := size - 1 - i
          right := size - 1 - j
          
          // The value at each position will be n minus the minimum distance
          minDist := min(min(top, bottom), min(left, right))
          value := n - minDist
          
          result[i][j] = strconv.Itoa(value)
      }
  }
  
  return result
}

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


