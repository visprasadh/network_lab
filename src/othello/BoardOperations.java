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
        if(board.board[i-1][j-1]==enemy&&i-1>=0&&j-1>=0)
        {   i--;j--;
            while(board.board[i][j]==enemy&&i>0&&j>0)
            {   i--;
                j--;
            }
            if(board.board[i][j]==player&&i>=0&&j>=0)
            {   if(i<x)
                    isCapturable = true;
                while(i!=x-1 && j!=y-1)
                    board.board[++i][++j]=player;
            }
        } 
        
        //CHECKING ELEMENT AND UPDATING ALONG NORTH DIRECTION 
        i=x;j=y; //Reassigning variables since i and j might have changed in the first block of updating.
        if(board.board[i][j-1]==enemy&&j-1>=0)
        {   j--;
            while(board.board[i][j]==enemy&&j>0)
            {    j--;
            }
            if(board.board[i][j]==player&&j>=0)
            {   if(j<y)
                    isCapturable = true;
                while(j!=y-1)
                    board.board[i][++j]=player;
            }
        }

        //CHECKING ELEMENT AND UPDATING ALONG NORTH-EAST DIRECTION
        i=x;j=y; 
        if(board.board[i+1][j-1]==enemy&&i+1<=7&&j-1>=0)
        {   i++;
            j--;
            while(board.board[i][j]==enemy&&i<7&&j>0)
            {   i++;
                j--;
            }
            if(board.board[i][j]==player&&i<=7&&j>=0) 
            {   if(j<y)
                    isCapturable=true;
                while(i!=x+1&&j!=y-1)
                    board.board[--i][++j] = player;
            }
        }

        //CHECKING ELEMENT AND UPDATING ALONG WEST DIRECTION
        i=x;j=y; 
        if(board.board[i-1][j]==enemy&&i-1>=0)
        {   i--;
            while(board.board[i][j]==enemy&&i>0) 
            {    i--;
            }
            if(board.board[i][j]==player&&i>=0) 
            {   if(i<x)
                    isCapturable = true;
                while(i!=x-1)
                    board.board[++i][j]=player;
            }
        } 

        //CHECKING ELEMENT AND UPDATING ACROSS EAST DIRECTION
        i=x;j=y; 
        if(board.board[i+1][j]==enemy&&i+1<=7)
        {   i++;
            while(board.board[i][j]==enemy&&i<7) 
            {    i++;
            }
            if(board.board[i][j]==player&&i<=7) 
            {   if(i>x)
                    isCapturable = true;
                while(i!=x+1)
                    board.board[--i][j]=player;
            }
        }
        
        //CHECKING ELEMENT AND UPDATING ALONG SOUTH-WEST DIRECTION
        i=x;j=y; 
        if(board.board[i-1][j+1]==enemy&&i-1>=0&&j+1<=7)
        {   i--;
            j++;
            while(board.board[i][j]==enemy&&i>0&&j<7)
            {   i--;
                j++;
            }
            if(board.board[i][j]==player&&i>=0&&j<=7)
            {   if(i<x)
                    isCapturable = true;
                while(i!=x-1 && j!=y+1)
                     board.board[++i][--j]=player;
            }
        }   

        //CHECKING ELEMENT AND UPDATING ALONG SOUTH DIRECTION        
        i=x;j=y; 
        if(board.board[i][j+1]==enemy&&j+1<=7)
        {  j++;
            while(board.board[i][j]==enemy&&j<7)
            {   j++;
            }
            if(board.board[i][j]==player&&j<=7) 
            {   if(j>y)
                    isCapturable = true;

                while(j!=y+1)
                    board.board[i][--j] = player;
            }
        }

        //CHECKING ELEMENT AND UPDATING ALONG SOUTH-EAST DIRECTION
        i=x;j=y;
        if(board.board[i+1][j+1]==enemy&&i+1<=7&&j+1<=7)
        {   i++;
            j++;
            while(board.board[i][j]==enemy&&i<7&&j<7)
            {   i++;
                j++;
            }
            if(board.board[i][j]==player&&i<=7&&j<=7)
            {   if(i>x)
                    isCapturable = true;
                while(i!=x+1&&j!=y+1)
                    board.board[--i][--j]=player;
            }
        }

        return isCapturable;
       //Change occurs in both variables i and j only in diagonal directions
    }  
    
}