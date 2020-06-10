package othello;

import java.io.Serializable;

class Input implements Serializable {
    int row, column;
    Input(int row, int col)
    {
        this.row = row;
        this.column = col;
    }
}
