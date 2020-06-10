package othello;

public class Board {
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

}

Board B;

public class SetSomeName   //Give a suitable name for the class
{   
    public boolean isLegal(int x,int y)
    {   if(isAlreadyMarked(x,y))
           return false;
        if(isCapturable(x,y))
           return true;
    }

    public boolean isAlreadyMarked(int x,int y)
    {   if(B.board[x][y]!='_')
           return true;
    }

    public boolean isCapturable(int x,int y)
    {
        //cfgh
    }
}
