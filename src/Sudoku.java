public class Sudoku {
    public static final int SIZE_OF_GRID = 9;  //creating a size of the grid variable for easy use in next steps
    // now issuing my own board with vacant spots as zeros in it

    int [][] board = {{7,2,0,8,0,0,0,9,0},
                      {6,4,9,0,0,7,0,5,0},
                      {5,0,8,2,9,4,0,0,7},
                      {0,7,6,0,0,0,3,0,1},
                      {0,0,4,9,0,3,0,7,0},
                      {0,5,2,1,0,0,4,6,0},
                      {0,0,1,6,3,5,7,0,0},
                      {0,0,0,0,0,0,0,1,0},
                      {0,0,0,0,8,1,0,0,0}};

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

    public static void main(String[] args) {

    }
}
