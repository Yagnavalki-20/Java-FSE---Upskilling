import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server address
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server at " + hostname + ":" + port);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String serverMsg, clientMsg;

            while (true) {
                // Read input from client user
                System.out.print("Client: ");
                clientMsg = stdIn.readLine();
                out.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Connection closed by client.");
                    break;
                }

                // Read server response
                serverMsg = in.readLine();
                if (serverMsg == null) {
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server: " + serverMsg);
            }

            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
