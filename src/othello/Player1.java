package othello;

import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class Player1 {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket(5001);
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] incomingData = new byte[1024];
        Board board = new Board();

        System.out.println("Your character : " +"0");

        while(true){
            board.printBoard();

            if(BoardOperations.isOver(board))
            {
                System.out.println("Game Over !!");
                board.printScore();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(board);
                byte[] data = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 5000);
                socket.send(sendPacket);

                break;
            }
            else if(!BoardOperations.isPlayable(board, '0','1')){
                System.out.println("No Possible moves available. Opponent's turn !!");
            }
            else if(!BoardOperations.isPlayable(board, '1','0'))
            {
                System.out.println("Game Over !!");
                board.printScore();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(board);
                byte[] data = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 5000);
                socket.send(sendPacket);

                break;
            }
            else
            {
                while (true) {
                    int row = 9, col = 9;
                    try{
                        System.out.print("Enter Row : ");
                        row = scanner.nextInt();
                        System.out.print("Enter Column : ");
                        col = scanner.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        scanner.next();
                    }


                    if(row>7 || col >7)
                    {
                        System.out.println("Incorrect Index !! Try Again !!");
                        continue;
                    }

                    if (BoardOperations.isLegal(board, row, col, '0', '1')) {
                        board.updatePoints();
                        System.out.println("Waiting for opponent to play !!");
                        break;
                    }
                    else
                    {
                        System.out.println("Illegal Move, Try Again !!");
                    }
                }

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(board);
                byte[] data = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 5000);
                socket.send(sendPacket);

                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                socket.receive(incomingPacket);
                data = incomingPacket.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);
                board = (Board) is.readObject();
            }
        }
    }
}
