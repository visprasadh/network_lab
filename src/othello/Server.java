package othello;

import java.io.*;
import java.net.*;

class Server {
    public static void main(String args[]) throws Exception
    {
        // Create server Socket
        ServerSocket ss = new ServerSocket(8888);

        // connect it to client socket
        Socket s1 = ss.accept();
        System.out.println("Player 1 Connected !!");

        Socket s2 = ss.accept();
        System.out.println("Player 2 Connected !!");

        // to send data to the client
        PrintStream ps1 = new PrintStream(s1.getOutputStream());
        PrintStream ps2 = new PrintStream(s2.getOutputStream());



        // to read data coming from the client
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));

        ObjectOutputStream os1 = new ObjectOutputStream((s1.getOutputStream()));
        ObjectOutputStream os2 = new ObjectOutputStream(s2.getOutputStream());

        ObjectInputStream is1 = new ObjectInputStream(s1.getInputStream());
        ObjectInputStream is2 = new ObjectInputStream(s2.getInputStream());

        char player[] = new char[2];
        player[0] = '0';
        player[1] = '1';
        Board board = new Board(player[0],player[1]);

        int turn = 0;

        ps1.println("You are Player 0");
        ps2.println("You are Player 1");

        // server executes continuously
        while (true) {
            System.out.println("inside while");




            System.out.println("asdfs");
            if(turn == 0)
            {
                System.out.println("inside if");
                os1.writeObject(board);
                os1.flush();
                System.out.println("Board Passed");
                Input input = (Input)is1.readObject();
                System.out.println(input.row +" "+input.column);
                boolean isLegal = BoardOperations.isLegal(board, input.row, input.column, player[0],player[1]);
                if(isLegal)
                {
                    ps1.println("Waiting for your Opponent to play !!");
                    board.updatePoints();
                    turn = 1;
                }
                else
                {
                    ps1.println("Illegal move, Try Again !!");
                }
//                board = (Board) is1.readObject();
            }
            else if(turn == 1 )
            {
                System.out.println("Inside Else");
                os2.writeObject(board);
                Input input = (Input)is2.readObject();
                boolean isLegal = BoardOperations.isLegal(board, input.row, input.column, player[1],player[0]);
                if(isLegal)
                {
                    ps1.println("Waiting for your Opponent to play !!");
                    board.updatePoints();
                    turn = 0;
                }
                else
                {
                    ps1.println("Illegal move, Try Again !!");
                }
//                board = (Board)is2.readObject();
            }

            is1.close();
            is2.close();
        }

//        ps1.close();
//        ps2.close();
//        s1.close();
//        s2.close();
//        br1.close();
//        br2.close();
//        os1.close();
//        os2.close();
//        is1.close();
//        is2.close();
//        ss.close();

    }
}