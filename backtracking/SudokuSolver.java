import java.util.Scanner;

public class SudokuSolver {
    public static boolean isSafe(char [][] board,int row,int col, int num){
        for (int i = 0; i < board.length; i++) {//row
            if(board[i][col]==(char)(num+'0')){
                return false;
            }
            if(board[row][i]==(char)(num+'0')){//calumn
                return false;
            }
        }
        int gr=(row/3)*3;
        int gc=(col/3)*3;
        for(int i=gr;i<gr+3;gr++){//grid
            for (int j = gc; j < gc+3; j++) {
                if(board[i][j]==(char)(num='0')){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean helper(char[][] board,int row, int col){
        if(row==board.length){//limiting case
            return true;
        }
        int nrow=0;
        int ncol=0;
        if(col!=board[0].length-1){//seting values for next call
            ncol=col+1;
        }else{
            nrow=row+1;
            ncol=0;
        }
        if (board[row][col]!='.') {//if the cuurent cell has aldready a number
            if(helper(board, nrow, ncol))
            return true;
        }else{
            for(int num=1;num<=9;num++){
                if(isSafe(board,row,col,num)){
                    board[row][col]=(char)(num+'0');
                    if(helper(board, nrow, ncol)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
    char [][] board = new char[9][9];
    System.out.println("Enter the number'number/.'");
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<9;i++){
        for (int j = 0; j < 9; j++) {
            board[i][j]=sc.nextLine().charAt(0);
        }
    }
    helper(board,0,0);//inital call
    for(int i=0;i<9;i++){
        for (int j = 0; j < 9; j++) {
            System.out.print(board[i][j]+"/t");
        }
        System.out.println("/n");
    }
    sc.close();
    }
    
}
