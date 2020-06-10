package othello;

import java.io.Serializable;

public class Board implements Serializable {
    char board[][];
    int WPoints, BPoints, FreePoints;

    public Board() {
        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '0', '1', '_', '_', '_',},
                {'_', '_', '_', '1', '0', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',}};

    }

    public Board(char player1, char player2){
        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', player1, player2, '_', '_', '_',},
                {'_', '_', '_', player2, player1, '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',},
                {'_', '_', '_', '_', '_', '_', '_', '_',}};
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void updatePoints()
    {   WPoints=0; 
        BPoints=0; 
        FreePoints= 0;
        for(int i=0;i<8;++i)
        {   for(int j=0;j<8;++j)
            {   if(board[i][j]=='0')
                   WPoints++;
                else if(board[i][j]=='1')
                   BPoints++;
                else 
                   FreePoints++;
            }
        }
    }
    public void printScore()
    {
        System.out.println("Score :");
        System.out.println("Player 0 : " + WPoints);
        System.out.println("Player 1 : " + BPoints);
    }

}
