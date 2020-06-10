package othello;

import java.io.*;
import java.net.*;
import java.util.zip.InflaterInputStream;

class Client {

    public static void main(String args[])
            throws Exception
    {

        // Create client socket
        Socket s = new Socket("localhost", 8888);

        System.out.println("Connected !!");
//
        // to send data to the server
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//
//        // to read data coming from the server
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//
//        // to read data from the keyboard
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        ObjectInputStream is = new ObjectInputStream(s.getInputStream());

        try{
        Board b = (Board)is.readObject();
        b.printBoard();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String str = br.readLine();
        System.out.println(str);

//        String str, str1;
//
//        while (!(str = kb.readLine()).equals("exit")) {
//            str = Parity.GenSingleParity(str);
//            // send to the server
//            dos.writeBytes(str + "\n");
//
//            // receive from the server
//
//            str1 = br.readLine();
//            if(Parity.checkSingleParity(str1))
//            {
//                str1 = str1.substring(0,str1.length()-1);
//                System.out.println(str1);
//            }
//            else
//            {
//                System.out.println("Error in Code !!");
//            }
//        }
//
//        // close connection.
        dos.close();
        br.close();
        kb.close();
        s.close();


    }
}

