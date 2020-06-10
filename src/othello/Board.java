package othello;

public class Board {
    char board[][];

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
    
    public int[] updatePoints()
    {   int points[] = new int[3];
        for(int i=0;i<8;++i)
        {   for(int j=0;j<8;++j)
            {   if(board[i][j]=='0')
                   points[0]++;
                else if(board[i][j]=='1')
                   points[1]++;
                else 
                   points[2]++;
            }
        }
        return points;
    }

}