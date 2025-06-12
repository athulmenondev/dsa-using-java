import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nqueens {

    public static boolean isSafe(int row,int col,char [][] chessboard){
        for(int i=0;i<chessboard.length;i++){
            if (chessboard[i][col]=='Q') {//checking the row
                return false;
            }
        }
        for(int j=0;j<chessboard.length;j++){
            if (chessboard[row][j]=='Q') {//checking the colomn
                return false;
            }
        }
        int i=row;
        for(int j=col;i>=0 && j>=0;i--,j--){//upperleftt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        i=row;
        for(int j=col;i>=0&& j<chessboard.length;i--,j++){//upperrightt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        i=row;
        for(int j=col;i<chessboard.length&&j>=0;i++,j--){//lowerleftt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        i=row;
        for(int j=col;i<chessboard.length && j<chessboard.length;i++,j++){//lowerrightt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
    public static void saveBoard(char[][] chessboard,List<List<String>> allboard){
         String row="";
         List<String> newboard=new ArrayList<>();
         for(int i=0;i<chessboard.length;i++){
            row="";
            for(int j=0;j<chessboard[0].length;j++){//saving the each row of board 
                if( chessboard[i][j]=='Q'){
                    row+='Q';
                }
                else{
                    row+='.';
                }
            }
            newboard.add(row);//adding the row to board
         }
         allboard.add(newboard);//ading the board to the boardlist

    }
    public static void helper(char [][] chessboard,List<List<String>> allboard,int col){
        if(col==chessboard.length){//limiting condition
            saveBoard(chessboard,allboard);//saving the correct board
            return;
        }
        for(int row=0;row<chessboard.length;row++){
            if (isSafe(row,col,chessboard)) {//validity checking
                chessboard[row][col]='Q';
                helper(chessboard, allboard, col+1);//recursive call
                chessboard[row][col]='.';
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of queens:");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        char [][] chessboard = new char[n][n];
        List<List<String>> allboards=new ArrayList<>();
        helper(chessboard,allboards,0);//initial call
        System.out.println(allboards);
        sc.close();
    }
}