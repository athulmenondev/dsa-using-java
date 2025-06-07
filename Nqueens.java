import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nqueens {

    public static boolean isSafe(int row,int col,char [][] chessboard){
        for(int i=0;i<chessboard.length;i++){
            if (chessboard[i][col]=='Q') {
                return false;
            }
        }
        for(int j=0;j<chessboard.length;j++){
            if (chessboard[row][j]=='Q') {
                return false;
            }
        }
        int i=row;
        for(int j=col;i>=0 && j>=0;i--,j--){//upperlt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        i=row;
        for(int j=col;i>=0&& j<chessboard.length;i--,j++){//upperrt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        i=row;
        for(int j=col;i<chessboard.length&&j>=0;i++,j--){//lowerlt
            if (chessboard[i][j]=='Q') {
                return false;
            }
        }
        i=row;
        for(int j=col;i<chessboard.length && j<chessboard.length;i++,j++){//lowerrt
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
            for(int j=0;j<chessboard[0].length;j++){
                if( chessboard[i][j]=='Q'){
                    row+='Q';
                }
                else{
                    row+='.';
                }
            }
            newboard.add(row);
         }
         allboard.add(newboard);

    }
    public static void helper(char [][] chessboard,List<List<String>> allboard,int col){
        if(col==chessboard.length){
            saveBoard(chessboard,allboard);
            return;
        }
        for(int row=0;row<chessboard.length;row++){
            if (isSafe(row,col,chessboard)) {
                chessboard[row][col]='Q';
                helper(chessboard, allboard, col+1);
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
        helper(chessboard,allboards,0);
        System.out.println(allboards);
        sc.close();
    }
}