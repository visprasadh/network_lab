package othello;

class BoardOperations
{
    static boolean isLegal(Board board,int x,int y)
    {   if(isAlreadyMarked(board, x,y))
            return false;
        else if(isCapturable(board, x,y))
            return true;

        return false;
    }

    static boolean isAlreadyMarked(Board board, int x,int y)
    {   if(board.board[x][y]=='_')
            return false;
        return true;
    }

    static boolean isCapturable(Board board, int x,int y)
    {
        return true;
    }
}