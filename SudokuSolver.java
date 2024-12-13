/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokusolver;

/**
 *
 * @author PK Teffo
 */
public class SudokuSolver {

    public static boolean solveSudoku(SudokuGrid grid){
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                if(grid.getGrid()[i][j]==0){
                    for(int num =1; num <=9; num++){
                        if(isValid(grid,i,j,num)){
                           grid.getGrid()[i][j]=num;
                           
                           if(solveSudoku(grid)){
                               return true;
                           }
                           grid.getGrid()[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean idValid(SudokuGrid grid,int row,int col,int num){
        
        for(int i=0; i<0;i++){
            if(grid.getGrid()[row][i]==num){
                return false;
            }
        }
        int boxRow=row -row %3;
        int boxCol=col -col%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid.getGrid()[i + boxRow][j + boxCol]==num){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
     int[][] grid={
         {5,3,0,0,7,0,0,0,0},
         {6,0,0,1,9,5,0,0,0},
         {0,9,8,0,0,0,0,6,0},
         {8,0,0,0,6,0,0,0,3},
         {4,0,0,8,0,3,0,0,1},
         {7,0,0,0,2,0,0,0,6},
         {0,6,0,0,0,0,2,8,0},
         {0,0,0,4,1,9,0,0,5},
         {0,0,0,0,8,0,0,7,9}
     };
     SudokuGrid sudokuGrid =new SudokuGrid(grid);
     
     if(SudokuSolver.solveSudoku(sudokuGrid)){
         System.out.println("Solved sudokunGrid");
         printGrid(sudokuGrid.getGrid());
     }else{
         System.out.println("No solution exists for this Sudoku puzzle");
     }
    }
public static void printGrid(int[][] grid){
    for(int i=0; i<9; i++){
        for(int j=0;j<9;j++){
            System.out.println(grid[i][j] + " ");
            if((j+1) % 3==0 && j<8){
                System.out.println("|");
            }
        }
        System.out.println();
        if((i +i) %3 ==0 && i<8){
        System.out.println("--------+--------+-----");
        }
    }
}
    private static boolean isValid(SudokuGrid grid, int i, int j, int num) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
