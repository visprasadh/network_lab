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

//        Socket s2 = ss.accept();
//        System.out.println("Player 2 Connected !!");

        // to send data to the client
        PrintStream ps1 = new PrintStream(s1.getOutputStream());
//        PrintStream ps2 = new PrintStream(s2.getOutputStream());
        ObjectOutputStream os1 = new ObjectOutputStream((s1.getOutputStream()));
//        ObjectOutputStream os2 = new ObjectOutputStream(s2.getOutputStream());

        // to read data coming from the client
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
//        BufferedReader br2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));

        // server executes continuously
//        while (true) {

            Board board = new Board();

            try{

            os1.writeObject(board);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            ps1.println("Make your Move :");






//            String str, str1;

//            while ((str = br.readLine()) != null) {
//                if(Parity.checkSingleParity(str))
//                {
//                    str = str.substring(0,str.length()-1);
//                    System.out.println(str);
//                }
//                else
//                {
//                    System.out.println("Error in Received msg !!");
//                }
//
//                str1 = kb.readLine();
//
//                // send to client
//                str1 = Parity.GenSingleParity(str1);
//                ps.println(str1);
//            }
//
//
//            ps.close();
//            br.close();
//            kb.close();
//            ss.close();
//            s.close();
//
//            // terminate application
//            System.exit(0);
//        } // end of while

        ps1.close();
//        ps2.close();
        s1.close();
//        s2.close();
        br1.close();
//        br2.close();
        os1.close();
//        os2.close();
        ss.close();

    }
}