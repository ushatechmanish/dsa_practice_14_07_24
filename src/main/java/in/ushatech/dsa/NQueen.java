package in.ushatech.dsa;

import java.util.Arrays;

// TODO Test to be written 
public class NQueen {

    public void placeNQueen(int numberOfQueens) 
    {
        int[][] state = new int[numberOfQueens][numberOfQueens];
        // Filling is not required as by default the value is 0
        // for (int[] row : state) {
        //     Arrays.fill(row, 0);
        // }
        // All not traversed are 0
        helper(numberOfQueens, state, 0);
    }

    private void helper(int numberOfQueens, int[][] state, int row) {
        // if(row == numberOfQueens-1 ) // this should be numberOfQueens because that
        // will suggest that all queens have been placed
        if (row == numberOfQueens) {
            printSolution(state);
            return;
        }
        for (int col = 0; col < numberOfQueens; ++col) 
        {
            if (isSafe(row, col, state)) {
                state[row][col] = 1;
                helper(numberOfQueens, state, row + 1);
                state[row][col] = 0;
            }
        }

    }
  

    public boolean isSafe(int row, int col, int[][] state) {
        // check for column
        for (int i = 0; i < row; ++i) {
            if (state[i][col] == 1)
                return false;
        }
        // No need to check for row as we are always selecting the next row .

        // for First diagonal elements

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (state[i][j] == 1)
                return false;
        }

        // for Second diagonal elements

        for (int i = row - 1, j = col + 1; i >= 0 && j < state[0].length; --i, ++j) {
            if (state[i][j] == 1)
                return false;
        }
        return true;
    }
    private void printSolution(int[][] state) {
        System.out.println("Solution:");
        for (int[] row : state) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new NQueen().placeNQueen(4);
    }
}
