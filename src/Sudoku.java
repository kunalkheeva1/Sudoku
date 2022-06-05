import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

public class Sudoku {
    public static final int SIZE_OF_GRID = 9;  //creating a size of the grid variable for easy use in next steps
    // now issuing my own board with vacant spots as zeros in it

    public static void main(String[] args) {

        int[][] board = {{7, 2, 0, 8, 0, 0, 0, 9, 0},
                {6, 4, 9, 0, 0, 7, 0, 5, 0},
                {5, 0, 8, 2, 9, 4, 0, 0, 7},
                {0, 7, 6, 0, 0, 0, 3, 0, 1},
                {0, 0, 4, 9, 0, 3, 0, 7, 0},
                {0, 5, 2, 1, 0, 0, 4, 6, 0},
                {0, 0, 1, 6, 3, 5, 7, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 8, 1, 0, 0, 0}};
        printBoard(board);
        if(solveBoard(board)){
            System.out.println();
            System.out.println("Solved Successfully :)");
            System.out.println();
        }else{
            System.out.println("Not Solved :(");
        }
        printBoard(board);
    }

    //creating a method to print board
    public static void printBoard(int[][]board){
        for(int row=0; row<SIZE_OF_GRID; row++){
            if(row%3==0&& row!=0){
                System.out.println("------------------------");    //just providing a lines after three upper grids
            }
            for (int column=0; column<SIZE_OF_GRID; column++){
                if(column % 3==0 && column != 0){
                    System.out.print(" | ");//after three columns printing this line for clarity
                }
                System.out.print(board[row][column] +" ");
            }
            System.out.println();
        }
    }



    //creating a method to search in the row
    public static boolean isNumberInRow(int [][]board, int number, int row){

        // I will just create a loop for it so that i can iterate through it wrt given row
        for(int i =0; i<SIZE_OF_GRID; i++){
            if(board[row][i]==number){              //if my given row contains that number then it will be true
                return true;
            }
        }return  false;                             //else it is false
    }

    // will be repeating the same thing for the column
    public static boolean isNumberInColumn(int[][]board, int number , int column){
        //running a loop in given column wrt rows to find the number
        for(int i=0; i<SIZE_OF_GRID; i++){
            if(board[i][column]== number){              //if the given space matches the position then its true
                return true;
            }
        }return false;                                  //else false
    }

    //now creating a method to confirm if the number is in the grid itself
    public static boolean isNumberInBox(int[][]board,int row, int column, int number){
        //getting the local row
        int localRow = row - row%3;
        //getting local column
        int localColumn = column -column%3;

        //now getting a nested loop to iterate through the given box
        for(int i=localRow; i<localRow+3; i++){
            for(int j=localColumn; j<localColumn+3; j++){           //+3 so that it can iterate through whole box
                if(board[row][column]==number){
                    return true;                                    //and if condition meets return true
                }
            }
        }return false;                                              //otherwise false
    }

    //now creating a method in which i can apply all the above three conditions
    public static boolean isValidPlacement(int board[][], int row, int column, int number){
        return !isNumberInBox(board, row, column, number) &&
                !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column);               //if all of them are false then it is a valid spot, but i need more clarity here
    }

    //creating a method to find the position on the board for the element
    public static boolean solveBoard(int[][]board){
        for(int row=0; row<SIZE_OF_GRID; row++){                  //looping thru the rows of the grid
            for(int column=0; column<SIZE_OF_GRID; column++){     //looping thru the columns of the grid
                if(board[row][column]==0){
                    //but just in case if board number is zero then another loop to try number between 1 and 9
                    for(int numberToTry=1; numberToTry<=SIZE_OF_GRID;numberToTry++){
                        if(isValidPlacement(board, row, column, numberToTry)){          //and then if number is valid
                        board[row][column]=numberToTry;                                 //assign the number to board
                        if(solveBoard(board)){                                          //and recursively call solveBaord method
                            return true;                                                //if it returns true then ok
                        }else{                                                          //otherwise assign the 0 value and back to the loop
                            board[row][column]=0;
                        }
                    }
                }
                    return false;           //if the number from 1-9 is not a valid entry
            }
        }
    }return true;                           //overall return true

    }


}
