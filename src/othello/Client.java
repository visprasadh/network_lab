package othello;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {

    public static void main(String args[])
            throws Exception
    {

        Socket s = new Socket("localhost", 8888);

        System.out.println("Connected to the Game Server !!");


        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(s.getInputStream());

        Scanner scanner = new Scanner(System.in);
//        Input input = new Input(0,0);
//        Board board;
//        Board b = (Board)is.readObject();
//        b.printBoard();

        String str = br.readLine();
        System.out.println(str);

        while(true)
        {

            System.out.println("....");
            Board board = (Board)is.readObject();
            System.out.println("Board Read");
            board.printBoard();
            System.out.print("Enter the Row : ");
            int row = scanner.nextInt();
            System.out.print("Enter the Column :");
            int column = scanner.nextInt();
            Input input = new Input(row, column);
            os.writeObject(input);
            os.flush();
            str = br.readLine();
            System.out.println(str);
            os.writeObject(board);
            os.flush();
        }
//        dos.close();
//        br.close();
//        kb.close();
//        is.close();
//        os.close();
//        s.close();

    }
}

