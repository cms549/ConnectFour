package cms549.connectfour;


import android.util.Log;

public class HardAI {

    public static int makemove(int[][] board) {
        int pos = 0;
        int[] possibleRow = new int[7];
        findPossibleMoves(possibleRow, board);

        //check if you can win
        pos= canWin(board, possibleRow, -1);
        if(pos!=-1){
            return pos;
        }
        //check if other person can win
        pos = canWin(board, possibleRow, 1);
        if(pos!=-1){
            return pos;
        }

        //check for two at the bottom
        if(board[5][3]==0){
            return 38;
        }
        if(board[5][2]==0){
            return 37;
        }
        if(board[5][4]==0){
            return 39;
        }

        //check if you can get three in a row
        pos = canThree(board, possibleRow, -1);
        if(pos!=-1){
            return pos;
        }
        //check if you block 3 in a row
        pos = canThree(board, possibleRow, 1);
        if(pos!=-1){
            return pos;
        }
        //go middle
        if(possibleRow[3]!=-1){
            Log.d("CHOOSING THE MIDDLE", "POS= "+3+possibleRow[3]*7);
            return 3+possibleRow[3]*7;
        }

        //do whatever
        for(int i=0; i< possibleRow.length;i++){
            if(possibleRow[i]!=-1){
                return i+possibleRow[i]*7;
            }
        }

        return pos;

    }

    private static int canThree(int[][] board, int[] possibleRow, int color) {
        for(int col=0; col<7; col++){
            //if column is full skip it
            if(possibleRow[col]<0){
                continue;
            }
            board[possibleRow[col]][col]=color;
            //if you can win go here
            if( inARow(board, color,3 ) ){
                board[possibleRow[col]][col]=0;
                return possibleRow[col]*6+col;
            }
            board[possibleRow[col]][col]=0;
        }
        return -1;
    }


    private static int canWin(int[][] board, int[] possibleRow, int color){
        for(int col=0; col<7; col++){
            //if column is full skip it
            if(possibleRow[col]<0){
                continue;
            }
            board[possibleRow[col]][col]=color;
            //if you can win go here
            if( inARow(board, color,4 ) ){
                board[possibleRow[col]][col]=0;
                return possibleRow[col]*6+col;
            }
            board[possibleRow[col]][col]=0;
        }
        return -1;

    }

    private static boolean inARow(int[][] board, int m, int amt) {
        //go through whole board and if you find inArow in a row return true
        int inARow=0;
        //go through each element and check right, up, up and right, and up and left
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                //count right
                int currRow = row;
                while(currRow<board.length && board[currRow][col]==m ){
                    inARow++;
                    currRow++;
                }
                if(inARow>=amt){
                    return true;
                }
                inARow=0;

                //count up
                int currCol = col;
                while(currCol<board[0].length && board[row][currCol]==m ){
                    inARow++;
                    currCol++;
                }
                if(inARow>=amt){
                    return true;
                }
                inARow=0;

                //count up and right (diagonal)
                currCol = col;
                currRow = row;
                while(currCol<board[0].length && currRow<board.length &&board[currRow][currCol]==m ){
                    inARow++;
                    currCol++;
                    currRow++;
                }
                if(inARow>=amt){
                    return true;
                }
                inARow=0;

                //count up and left (diagonal)
                currCol = col;
                currRow = row;
                while(currCol<board[0].length && currRow>=0 && board[currRow][currCol]==m ){
                    inARow++;
                    currCol++;
                    currRow--;
                }
                if(inARow>=amt){
                    return true;
                }
                inARow=0;

            }
        }


        return false;
    }


    private static void findPossibleMoves(int[] possibleRow, int[][] board){
        for(int col=0; col<7; col++){
            possibleRow[col]=-1;
            for(int row=0; row<6;row++){
                if(board[row][col]==0){
                    possibleRow[col]= row;
                    break;
                }
            }
        }
    }



}
