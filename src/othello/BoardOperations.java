package othello;

class BoardOperations
{
    //isLegal function check whether the move is legal and updates the board if a legal move is performed.

    static boolean isLegal(Board board,int x,int y, char player, char enemy)
    {   if(isAlreadyMarked(board, x,y))
            return false;
        else if(isCapturable(board, x,y, player, enemy))
            return true;                  

        return false;
    }

    static boolean isAlreadyMarked(Board board, int x,int y)
    {   if(board.board[x][y]=='_')
            return false;
        return true;
    }

    static boolean isCapturable(Board board, int x,int y, char player, char enemy)
    {
        return updatePieces(board,x,y,player,enemy);
    }

    static boolean updatePieces(Board board,int x, int y, char player, char enemy)
    {
        int i=x,j=y;
        board.board[i][j]=player;
        boolean isCapturable = false;
              
        //CHECKING ELEMENT AND UPDATING ALONG NORTH-WEST DIRECTION
        if(i-1>=0&&j-1>=0&&board.board[i-1][j-1]==enemy)
        {   i--;j--;
            while(i>0&&j>0&&board.board[i][j]==enemy)
            {   i--;
                j--;
            }
            if(i>=0&&j>=0&&board.board[i][j]==player)
            {   if(i<x)
                    isCapturable = true;
                while(i!=x-1 && j!=y-1)
                    board.board[++i][++j]=player;
            }
        } 
        
        //CHECKING ELEMENT AND UPDATING ALONG NORTH DIRECTION 
        i=x;j=y; //Reassigning variables since i and j might have changed in the first block of updating.
        if(j-1>=0&&board.board[i][j-1]==enemy)
        {   j--;
            while(board.board[i][j]==enemy&&j>0)
            {    j--;
            }
            if(j>=0&&board.board[i][j]==player)
            {   if(j<y)
                    isCapturable = true;
                while(j!=y-1)
                    board.board[i][++j]=player;
            }
        }

        //CHECKING ELEMENT AND UPDATING ALONG NORTH-EAST DIRECTION
        i=x;j=y; 
        if(i+1<=7&&j-1>=0 && board.board[i+1][j-1]==enemy)
        {   i++;
            j--;
            while(i<7&&j>0 && board.board[i][j]==enemy)
            {   i++;
                j--;
            }
            if(i<=7&&j>=0 && board.board[i][j]==player)
            {   if(j<y)
                    isCapturable=true;
                while(i!=x+1&&j!=y-1)
                    board.board[--i][++j] = player;
            }
        }

        //CHECKING ELEMENT AND UPDATING ALONG WEST DIRECTION
        i=x;j=y; 
        if(i-1>=0 && board.board[i-1][j]==enemy)
        {   i--;
            while(i>0 && board.board[i][j]==enemy) 
            {    i--;
            }
            if(i>=0 && board.board[i][j]==player)
            {   if(i<x)
                    isCapturable = true;
                while(i!=x-1)
                    board.board[++i][j]=player;
            }
        } 

        //CHECKING ELEMENT AND UPDATING ACROSS EAST DIRECTION
        i=x;j=y; 
        if(i+1<=7 && board.board[i+1][j]==enemy)
        {   i++;
            while(i<7 && board.board[i][j]==enemy) 
            {    i++;
            }
            if(i<=7 && board.board[i][j]==player) 
            {   if(i>x)
                    isCapturable = true;
                while(i!=x+1)
                    board.board[--i][j]=player;
            }
        }
        
        //CHECKING ELEMENT AND UPDATING ALONG SOUTH-WEST DIRECTION
        i=x;j=y; 
        if(i-1>=0&&j+1<=7 && board.board[i-1][j+1]==enemy)
        {   i--;
            j++;
            while(i>0&&j<7 && board.board[i][j]==enemy)
            {   i--;
                j++;
            }
            if(i>=0&&j<=7 && board.board[i][j]==player)
            {   if(i<x)
                    isCapturable = true;
                while(i!=x-1 && j!=y+1)
                     board.board[++i][--j]=player;
            }
        }   

        //CHECKING ELEMENT AND UPDATING ALONG SOUTH DIRECTION        
        i=x;j=y; 
        if(j+1<=7 && board.board[i][j+1]==enemy)
        {  j++;
            while(j<7 && board.board[i][j]==enemy)
            {   j++;
            }
            if(j<=7 && board.board[i][j]==player) 
            {   if(j>y)
                    isCapturable = true;

                while(j!=y+1)
                    board.board[i][--j] = player;
            }
        }

        //CHECKING ELEMENT AND UPDATING ALONG SOUTH-EAST DIRECTION
        i=x;j=y;
        if(i+1<=7&&j+1<=7 && board.board[i+1][j+1]==enemy)
        {   i++;
            j++;
            while(i<7&&j<7 && board.board[i][j]==enemy)
            {   i++;
                j++;
            }
            if(i<=7&&j<=7 && board.board[i][j]==player)
            {   if(i>x)
                    isCapturable = true;
                while(i!=x+1&&j!=y+1)
                    board.board[--i][--j]=player;
            }
        }

        if(!isCapturable)
            board.board[x][y]='_';

        return isCapturable;
       //Change occurs in both variables i and j only in diagonal directions
    }  

    static boolean isOver(Board board){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++)
            {
                if(board.board[i][j] == '_')
                {
                    return false;

                }
            }
        }

        return true;
    }

    static boolean isPlayable(Board board, char player, char enemy)
    {
        for(int x =0; x<8; x++)
        {
                for (int y=0; y<8; y++)
                {
                    if(board.board[x][y] != '_')
                        continue;

                    int i=x,j=y;
                    board.board[i][j]=player;
                    boolean isCapturable = false;

                    //CHECKING ELEMENT AND UPDATING ALONG NORTH-WEST DIRECTION
                    if(i-1>=0&&j-1>=0&&board.board[i-1][j-1]==enemy)
                    {   i--;j--;
                        while(i>0&&j>0&&board.board[i][j]==enemy)
                        {   i--;
                            j--;
                        }
                        if(i>=0&&j>=0&&board.board[i][j]==player)
                        {   if(i<x)
                            isCapturable = true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ALONG NORTH DIRECTION
                    i=x;j=y; //Reassigning variables since i and j might have changed in the first block of updating.
                    if(j-1>=0&&board.board[i][j-1]==enemy)
                    {   j--;
                        while(board.board[i][j]==enemy&&j>0)
                        {    j--;
                        }
                        if(j>=0&&board.board[i][j]==player)
                        {   if(j<y)
                            isCapturable = true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ALONG NORTH-EAST DIRECTION
                    i=x;j=y;
                    if(i+1<=7&&j-1>=0 && board.board[i+1][j-1]==enemy)
                    {   i++;
                        j--;
                        while(i<7&&j>0 && board.board[i][j]==enemy)
                        {   i++;
                            j--;
                        }
                        if(i<=7&&j>=0 && board.board[i][j]==player)
                        {   if(j<y)
                            isCapturable=true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ALONG WEST DIRECTION
                    i=x;j=y;
                    if(i-1>=0 && board.board[i-1][j]==enemy)
                    {   i--;
                        while(i>0 && board.board[i][j]==enemy)
                        {    i--;
                        }
                        if(i>=0 && board.board[i][j]==player)
                        {   if(i<x)
                            isCapturable = true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ACROSS EAST DIRECTION
                    i=x;j=y;
                    if(i+1<=7 && board.board[i+1][j]==enemy)
                    {   i++;
                        while(i<7 && board.board[i][j]==enemy)
                        {    i++;
                        }
                        if(i<=7 && board.board[i][j]==player)
                        {   if(i>x)
                            isCapturable = true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ALONG SOUTH-WEST DIRECTION
                    i=x;j=y;
                    if(i-1>=0&&j+1<=7 && board.board[i-1][j+1]==enemy)
                    {   i--;
                        j++;
                        while(i>0&&j<7 && board.board[i][j]==enemy)
                        {   i--;
                            j++;
                        }
                        if(i>=0&&j<=7 && board.board[i][j]==player)
                        {   if(i<x)
                            isCapturable = true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ALONG SOUTH DIRECTION
                    i=x;j=y;
                    if(j+1<=7 && board.board[i][j+1]==enemy)
                    {  j++;
                        while(j<7 && board.board[i][j]==enemy)
                        {   j++;
                        }
                        if(j<=7 && board.board[i][j]==player)
                        {
                            if(j>y)
                            isCapturable = true;
                        }
                    }

                    //CHECKING ELEMENT AND UPDATING ALONG SOUTH-EAST DIRECTION
                    i=x;j=y;
                    if(i+1<=7&&j+1<=7 && board.board[i+1][j+1]==enemy)
                    {   i++;
                        j++;
                        while(i<7&&j<7 && board.board[i][j]==enemy)
                        {   i++;
                            j++;
                        }
                        if(i<=7&&j<=7 && board.board[i][j]==player)
                        {   if(i>x)
                            isCapturable = true;
                        }
                    }

                    board.board[x][y]='_';
                    if(isCapturable)
                        return true;
                    //Change occurs in both variables i and j only in diagonal directions
                }
            }
            return false;
        }

}