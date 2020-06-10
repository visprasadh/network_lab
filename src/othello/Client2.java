package othello;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client2 {

    public static void main(String args[])
            throws Exception
    {

        Socket s = new Socket("localhost", 8888);

        System.out.println("Connected to the Game Server !!");


        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream is = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        Input input = new Input(0,0);
        Board board;
//        Board b = (Board)is.readObject();
//        b.printBoard();

        String str = br.readLine();
        System.out.println(str);

        while(true)
        {
            try{
                board = (Board)is.readObject();
                board.printBoard();
                System.out.print("Enter the Row : ");
                input.row = scanner.nextInt();
                System.out.print("Enter the Column :");
                input.column = scanner.nextInt();
                os.writeObject(input);
                str = br.readLine();
                System.out.println(str);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
//        dos.close();
//        br.close();
//        kb.close();
//        is.close();
//        os.close();
//        s.close();


    }
}

